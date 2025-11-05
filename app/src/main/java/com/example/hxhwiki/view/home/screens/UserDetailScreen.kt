package com.example.hxhwiki.view.home.screens

import com.example.hxhwiki.view.home.screens.userDetailData.UserData
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hxhwiki.R
import androidx.navigation.compose.rememberNavController
@Composable
fun UserDetailScreen(
    name: String,
    navController: NavController
) {
    val character = UserData.characters.find { it.name == name }

    if (character == null) {
        Text("Personaje no encontrado", color = Color.White)
        return
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .width(270.dp)
                .height(450.dp)
        ) {

            // Imagen plantilla (fondo)
            Image(
                painter = painterResource(id = R.drawable.huntercard),
                contentDescription = "Hunter Card",
                modifier = Modifier.fillMaxSize()
            )



            // Imagen del personaje en el recuadro blanco
            Image(
                painter = painterResource(id = character.imageRes),
                contentDescription = character.name,
                modifier = Modifier
                    .width(186.dp)
                    .height(144.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = 30.dp),
                        contentScale = ContentScale.FillBounds

            )

            // === CAMPOS DE INFORMACIÓN ===

            Text(
                text = "Nombre: ${character.name}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 28.dp, y = 295.dp)
            )

            Text(
                text = "Edad: ${character.age}",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 25.dp, y = 340.dp)
            )

            Text(
                text = "Origen: ${character.origin}",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 25.dp, y = 366.dp)
            )

            Text(
                text = "Poder: ${character.power}",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 25.dp, y = 392.dp)
            )

            Text(
                text = "Objetivo: ${character.goal}",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 25.dp, y = 415.dp)
            )
        }

        // Botón volver
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
        ) {
            Text("⬅ Volver", color = Color.White)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun UserDetailScreenPreview() {
    UserDetailScreen(
        name = "Hisoka Morow",
        navController = rememberNavController()
    )
}
