package com.example.hxhwiki.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import com.example.hxhwiki.R

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hxhwiki.view.coreNavigation.NenScreen
import com.example.hxhwiki.view.coreNavigation.TriviaScreen


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel(),
    navController: NavController
) {
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { padding ->
        // Usa un único Column para todo el contenido
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFA5D6A7))
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 6.dp,
                        shape = RectangleShape,
                        clip = false
                    )
                    .background(Color(0xFF388E3C))
                    .padding(vertical = 5.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hxhlogo),
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)) // Bordes redondeados
                    .background(Color(0xFFD0E8D0)) // Color más claro que el fondo para contraste
                    .padding(16.dp)
            ) {
                Text(
                    text = "Hunter x Hunter trata sobre la historia de Gon Freecs, un niño que se convierte en cazador profesional para encontrar a su padre, Ging, quien también fue un cazador legendario y lo abandonó cuando era pequeño. Para lograrlo, Gon debe pasar el riguroso y peligroso \"Examen de Cazador\" y, en el camino, conoce y se hace amigo de otros tres aspirantes: Kurapika, Leorio y Killua.",
                    style = MaterialTheme.typography.titleLarge.copy(
                        lineHeight = 20.sp
                    ),
                    color = Color(0xFF2E7D32) // Verde oscuro para buen contraste
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Coloca todas las imágenes dentro de un solo Column scrollable
            Image(
                modifier = Modifier
                    .height(300.dp)
                    .width(300.dp),
                painter = painterResource(id = R.drawable.imagenarco),
                contentDescription = "Arco de la historia"
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Hunter X Hunter 1999 VS Hunter X Hunter 2011",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1B5E20),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(end = 20.dp)
                ) {
                    Text(
                        text = "1999",
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2E7D32)
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Image(
                        modifier = Modifier
                            .height(220.dp)
                            .width(150.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        painter = painterResource(id = R.drawable.gonantiguo),
                        contentDescription = "Hunter X Hunter 1999"
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(start = 20.dp)
                ) {
                    Text(
                        text = "2011",
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2E7D32)
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Image(
                        modifier = Modifier
                            .height(220.dp)
                            .width(150.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        painter = painterResource(id = R.drawable.gonactual),
                        contentDescription = "Hunter X Hunter 2011"
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Mueve los botones dentro del mismo Column
            Button(
                onClick = { navController.navigate(NenScreen) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2E7D32)
                )
            ) {
                Text(
                    text = "Tipos X de X Nen",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp,
                        lineHeight = 20.sp
                    )
                )
            }
            Button(
                onClick = { navController.navigate(TriviaScreen) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF6D00)
                )
            ) {
                Text(
                    text = "Trivia de Hunter X Hunter",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp,
                        lineHeight = 20.sp
                    )
                )
            }
        }
    }
}


