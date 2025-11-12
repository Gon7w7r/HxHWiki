package com.example.hxhwiki.view.home.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hxhwiki.view.home.screens.userDetailData.UserDetailViewModel

@Composable
fun UserDetailScreen(
    name: String,
    navController: NavController,
    viewModel: UserDetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val character by viewModel.selectedCharacter.collectAsState()

    // Carga el personaje
    LaunchedEffect(name) {
        viewModel.loadCharacterByName(name)
    }

    // Pantalla de carga
    if (character == null) {
        Box(
            modifier = Modifier.fillMaxSize().background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Text("Cargando personaje...", color = Color.White)
        }
        return
    }

    // === Diseño de ficha ===
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen del personaje
        Image(
            painter = painterResource(id = character!!.imageRes),
            contentDescription = character!!.name,
            modifier = Modifier
                .size(240.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.DarkGray),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Nombre
        Text(
            text = character!!.name,
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Divider(
            color = Color(0xFF444444),
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 10.dp)
        )

        // Datos personales
        InfoRow(label = "Edad", value = "${character!!.age}")
        InfoRow(label = "Origen", value = character!!.origin)
        InfoRow(label = "Poder", value = character!!.power)
        InfoRow(label = "Objetivo", value = character!!.goal)

        Spacer(modifier = Modifier.height(30.dp))

        // Botón volver
        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2C2C2C)),
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("⬅ Volver", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Text(
            text = label,
            color = Color(0xFFAAAAAA),
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = value,
            color = Color.White,
            fontSize = 16.sp,
            lineHeight = 20.sp
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun UserDetailScreenPreview() {
    UserDetailScreen(name = "Hisoka Morow", navController = rememberNavController())
}
