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

    // Cargar el personaje
    LaunchedEffect(name) {
        viewModel.loadCharacterByName(name)
    }

    val bg = MaterialTheme.colorScheme.surfaceContainer         // Fondo más profundo
    val cardBg = MaterialTheme.colorScheme.surfaceContainerHigh // Fondo tarjeta
    val onBg = MaterialTheme.colorScheme.onSurface              // Texto principal
    val outline = MaterialTheme.colorScheme.outlineVariant
    val primary = MaterialTheme.colorScheme.primary
    val onPrimary = MaterialTheme.colorScheme.onPrimary

    // Loading
    if (character == null) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(bg),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Cargando personaje...",
                color = onBg
            )
        }
        return
    }

    // === UI principal ===
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
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
                .background(cardBg),   // Imagen con fondo coherente
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Nombre
        Text(
            text = character!!.name,
            color = onBg,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Divider(
            color = outline,
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 10.dp)
        )

        // Datos
        InfoRow(label = "Edad", value = "${character!!.age}", textColor = onBg)
        InfoRow(label = "Origen", value = character!!.origin, textColor = onBg)
        InfoRow(label = "Poder", value = character!!.power, textColor = onBg)
        InfoRow(label = "Objetivo", value = character!!.goal, textColor = onBg)

        Spacer(modifier = Modifier.height(30.dp))

        // Botón volver (con primary para que se vea)
        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(
                containerColor = primary,
                contentColor = onPrimary
            ),
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text(
                "⬅ Volver",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun InfoRow(label: String, value: String, textColor: Color) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Text(
            text = label,
            color = textColor.copy(alpha = 0.7f),
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = value,
            color = textColor,
            fontSize = 16.sp,
            lineHeight = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserDetailScreenPreview() {
    UserDetailScreen(name = "Hisoka Morow", navController = rememberNavController())
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
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = value,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 16.sp,
            lineHeight = 20.sp
        )
    }
}

