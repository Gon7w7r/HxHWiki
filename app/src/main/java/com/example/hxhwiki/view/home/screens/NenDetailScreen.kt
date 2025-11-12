package com.example.hxhwiki.view.home.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hxhwiki.view.coreNavigation.NenScreen
import com.example.hxhwiki.view.home.screens.nenDetailData.NenViewModel

@Composable
fun NenDetailScreen(
    nenTitle: String,
    navController: NavController,
    viewModel: NenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val nenType by viewModel.selectedNen.collectAsState()

    // Cargar al entrar
    LaunchedEffect(nenTitle) {
        viewModel.loadNenByTitle(nenTitle)
    }

    // Si no hay datos todavía
    if (nenType == null) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Text("Cargando...", color = Color.White)
        }
        return
    }

    // --- UI principal ---
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título del tipo de Nen
        Text(
            text = nenType!!.title,
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        // Descripción
        Text(
            text = nenType!!.description,
            color = Color(0xFFB0B0B0),
            fontSize = 16.sp,
            lineHeight = 22.sp
        )

        // Subtítulo
        Text(
            text = "Personajes que usan este tipo:",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 16.dp)
        )

        // Lista de personajes
        nenType!!.users.forEach { user ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .height(80.dp)
                    .clickable {
                        navController.navigate(
                            com.example.hxhwiki.view.coreNavigation.UserDetailScreen(user.name)
                        )
                    },
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = user.imageRes),
                        contentDescription = user.name,
                        modifier = Modifier
                            .size(55.dp)
                            .padding(end = 12.dp)
                    )

                    Text(
                        text = user.name,
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { navController.navigate(NenScreen) },
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
        ) {
            Text("⬅ Volver", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NenDetailScreenPreview() {
    NenDetailScreen(nenTitle = "Transmutation", navController = rememberNavController())
}
