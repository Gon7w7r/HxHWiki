package com.example.hxhwiki.view.home.screens.TriviaScreen

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TriviaScreen(
    navController: NavController,
    viewModel: TriviaViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        containerColor = Color(0xFF0D260D),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Trivia Hunter X Hunter",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    Button(
                        onClick = { navController.popBackStack() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Text(
                            text = "← Volver",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1B5E20)
                )
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0D260D))
                .padding(padding)
        ) {
            when {
                uiState.showResults -> {
                    ResultScreen(
                        puntaje = uiState.score,
                        totalPreguntas = uiState.questions.size,
                        onRestart = { viewModel.restartGame() },
                        onExit = {
                            viewModel.exitGame()
                            navController.popBackStack()
                        }
                    )
                }
                uiState.questions.isNotEmpty() -> {
                    QuestionScreen(
                        pregunta = uiState.questions[uiState.currentQuestionIndex],
                        questionNumber = uiState.currentQuestionIndex + 1,
                        totalQuestions = uiState.questions.size,
                        onAnswerSelected = { selectedAnswer ->
                            viewModel.selectAnswer(selectedAnswer)
                        }
                    )
                }
                else -> {
                    // Loading state
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Cargando preguntas...", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun QuestionScreen(
    pregunta: TriviaQuestion,
    questionNumber: Int,
    totalQuestions: Int,
    onAnswerSelected: (Int) -> Unit
) {
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        isVisible = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Indicador de progreso
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(animationSpec = tween(500)) +
                    slideInVertically(animationSpec = tween(500))
        ) {
            Text(
                text = "Pregunta $questionNumber/$totalQuestions",
                style = MaterialTheme.typography.titleSmall.copy(
                    color = Color(0xFFAAAAAA)
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Nivel de dificultad
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(animationSpec = tween(500, delayMillis = 200)) +
                    slideInVertically(animationSpec = tween(500, delayMillis = 200))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(pregunta.nivelColor, MaterialTheme.shapes.medium)
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Nivel: ${pregunta.nivel}",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Pregunta
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(animationSpec = tween(500, delayMillis = 400)) +
                    slideInVertically(animationSpec = tween(500, delayMillis = 400))
        ) {
            Text(
                text = pregunta.pregunta,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 28.sp
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Opciones de respuesta con animación escalonada
        pregunta.opciones.forEachIndexed { index, opcion ->
            // Colores bonitos para cada opción
            val buttonColors = listOf(
                Color(0xFFE3F2FD) to Color(0xFF0D47A1), // Azul claro/oscuro
                Color(0xFFE8F5E8) to Color(0xFF1B5E20), // Verde claro/oscuro
                Color(0xFFFFF8E1) to Color(0xFFF57F17), // Amarillo claro/naranja oscuro
                Color(0xFFFCE4EC) to Color(0xFF880E4F)  // Rosa claro/rojo oscuro
            )

            val (backgroundColor, textColor) = buttonColors[index]

            // Cada opción aparece con un delay diferente
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(animationSpec = tween(400, delayMillis = 600 + index * 100)) +
                        slideInHorizontally(
                            initialOffsetX = { -100 },
                            animationSpec = tween(400, delayMillis = 600 + index * 100)
                        )
            ) {
                Button(
                    onClick = { onAnswerSelected(index) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = backgroundColor,
                        contentColor = textColor
                    )
                ) {
                    Text(
                        text = "${'a' + index}) $opcion",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(vertical = 8.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun ResultScreen(
    puntaje: Int,
    totalPreguntas: Int,
    onRestart: () -> Unit,
    onExit: () -> Unit
) {
    val percentage = (puntaje.toFloat() / totalPreguntas.toFloat()) * 100
    val resultText = when {
        percentage >= 90 -> "¡Eres un Cazador Élite!"
        percentage >= 70 -> "¡Excelente conocimiento!"
        percentage >= 50 -> "¡Buen trabajo!"
        else -> "¡Sigue practicando!"
    }

    // Estado para controlar las animaciones
    var isVisible by remember { mutableStateOf(false) }

    // Activar animación después de que el componente se monte
    LaunchedEffect(Unit) {
        isVisible = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título - aparece primero
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(animationSpec = tween(800)) +
                    slideInVertically(
                        initialOffsetY = { fullHeight -> fullHeight / 2 },
                        animationSpec = tween(800)
                    )
        ) {
            Text(
                text = "¡Trivia Completada!",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Puntaje - aparece segundo
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(animationSpec = tween(600, delayMillis = 300)) +
                    slideInVertically(
                        initialOffsetY = { fullHeight -> fullHeight / 4 },
                        animationSpec = tween(600, delayMillis = 300)
                    )
        ) {
            Text(
                text = "$puntaje/$totalPreguntas",
                style = MaterialTheme.typography.displayMedium.copy(
                    fontWeight = FontWeight.Black,
                    color = Color(0xFF4CAF50)
                )
            )
        }

        // Porcentaje - aparece tercero
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(animationSpec = tween(400, delayMillis = 600))
        ) {
            Text(
                text = "(${percentage.toInt()}%)",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color(0xFFAAAAAA)
                )
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Resultado - aparece cuarto
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(animationSpec = tween(500, delayMillis = 900)) +
                    slideInVertically(
                        initialOffsetY = { 50 },
                        animationSpec = tween(500, delayMillis = 900)
                    )
        ) {
            Text(
                text = resultText,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        // Botones - aparecen últimos
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(animationSpec = tween(500, delayMillis = 1200))
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = onRestart,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF4CAF50)
                    )
                ) {
                    Text(
                        text = "Jugar de Nuevo",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onExit,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF757575)
                    )
                ) {
                    Text(
                        text = "Salir",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}



data class TriviaQuestion(
    val nivel: String,
    val nivelColor: Color,
    val pregunta: String,
    val opciones: List<String>,
    val respuestaCorrecta: Int
)

@Preview()
@Composable
fun TriviaScreenPreview() {
    TriviaScreen(navController = rememberNavController())
}