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
import androidx.compose.ui.layout.ContentScale
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

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel(),
    navController: NavController
) {
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                        colors = listOf(Color(0xFF1B5E20), Color(0xFF388E3C))
                    )
                )
                .padding(padding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header con logo
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF0D260D))
                    .padding(vertical = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hxhlogo),
                    contentDescription = "Hunter X Hunter Logo",
                    modifier = Modifier
                        .height(120.dp)
                        .width(120.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Tarjeta de descripción
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(16.dp),
                        clip = true
                    )
                    .background(Color(0xFFE8F5E8))
                    .padding(20.dp)
            ) {
                Text(
                    text = "Hunter x Hunter trata sobre la historia de Gon Freecs, un niño que se convierte en cazador profesional para encontrar a su padre, Ging, quien también fue un cazador legendario y lo abandonó cuando era pequeño. Para lograrlo, Gon debe pasar el riguroso y peligroso \"Examen de Cazador\" y, en el camino, conoce y se hace amigo de otros tres aspirantes: Kurapika, Leorio y Killua.",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        lineHeight = 22.sp,
                        color = Color(0xFF2E7D32)
                    ),
                    textAlign = TextAlign.Justify
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // === IMAGEN DEL ARCO - OPCIÓN 4 MEJORADA ===
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                // Título de la imagen
                Text(
                    text = "ARCO DE HISTORIA PRINCIPAL",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    ),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Imagen con marco blanco
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(
                            elevation = 12.dp,
                            shape = RoundedCornerShape(16.dp),
                            clip = true
                        )
                        .background(Color.White, RoundedCornerShape(16.dp))
                        .padding(3.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.imagenarco),
                        contentDescription = "Arco de la historia",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp)),
                        contentScale = ContentScale.FillWidth
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Sección de comparación
                Text(
                    text = "HUNTER X HUNTER: 1999 VS 2011",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Black,
                        color = Color.White,
                        letterSpacing = 1.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp),
                    textAlign = TextAlign.Center
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    // Versión 1999
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "1999",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFFFD54F)
                            ),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Box(
                            modifier = Modifier
                                .shadow(
                                    elevation = 6.dp,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFF1A237E))
                        ) {
                            Image(
                                modifier = Modifier
                                    .height(180.dp)
                                    .fillMaxWidth(),
                                painter = painterResource(id = R.drawable.gonantiguo),
                                contentDescription = "Hunter X Hunter 1999",
                                contentScale = ContentScale.Crop
                            )
                        }
                        Text(
                            text = "Estilo Clásico",
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = Color.White
                            ),
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    // Versión 2011
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "2011",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF4FC3F7)
                            ),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Box(
                            modifier = Modifier
                                .shadow(
                                    elevation = 6.dp,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFFB71C1C))
                        ) {
                            Image(
                                modifier = Modifier
                                    .height(180.dp)
                                    .fillMaxWidth(),
                                painter = painterResource(id = R.drawable.gonactual),
                                contentDescription = "Hunter X Hunter 2011",
                                contentScale = ContentScale.Crop
                            )
                        }
                        Text(
                            text = "Estilo Moderno",
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = Color.White
                            ),
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                // Botones de navegación
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(
                        onClick = { navController.navigate(NenScreen) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF1565C0)
                        ),
                        shape = RoundedCornerShape(12.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 8.dp,
                            pressedElevation = 4.dp
                        )
                    ) {
                        Text(
                            text = "TIPOS DE NEN",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.sp
                            )
                        )
                    }

                    Button(
                        onClick = { navController.navigate(TriviaScreen) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF6D00)
                        ),
                        shape = RoundedCornerShape(12.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 8.dp,
                            pressedElevation = 4.dp
                        )
                    ) {
                        Text(
                            text = "TRIVIA HUNTER X HUNTER",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.sp
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}


