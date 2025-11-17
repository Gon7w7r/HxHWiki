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

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.*

@Composable
fun NenDetailScreen(
    nenTitle: String,
    navController: NavController,
    viewModel: NenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val nenType by viewModel.selectedNen.collectAsState()

    LaunchedEffect(nenTitle) {
        viewModel.loadNenByTitle(nenTitle)
    }

    val bg = MaterialTheme.colorScheme.surfaceContainer
    val onBg = MaterialTheme.colorScheme.onSurface
    val cardBg = MaterialTheme.colorScheme.surfaceContainerHigh
    val primary = MaterialTheme.colorScheme.primary
    val onPrimary = MaterialTheme.colorScheme.onPrimary

    if (nenType == null) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(bg),
            contentAlignment = Alignment.Center
        ) {
            Text("Cargando...", color = onBg)
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // --- TÍTULO ---
        Text(
            text = nenType!!.title,
            color = onBg,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        // --- DESCRIPCIÓN ---
        Text(
            text = nenType!!.description,
            color = onBg.copy(alpha = 0.85f),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 12.dp)
        )

        Text(
            text = "Personajes que usan este tipo:",
            color = onBg,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 20.dp)
        )

        // --- LISTA ---
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
                colors = CardDefaults.cardColors(
                    containerColor = cardBg
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
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
                        color = onBg,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate(NenScreen) },
            colors = ButtonDefaults.buttonColors(
                containerColor = primary,
                contentColor = onPrimary
            ),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text("⬅ Volver", fontWeight = FontWeight.Bold)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun NenDetailScreenPreview() {
    NenDetailScreen(nenTitle = "Transmutation", navController = rememberNavController())
}
