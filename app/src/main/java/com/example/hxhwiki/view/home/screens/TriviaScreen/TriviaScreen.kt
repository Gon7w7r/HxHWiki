package com.example.hxhwiki.view.home.screens.TriviaScreen

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hxhwiki.R // ← AGREGAR ESTE IMPORT
import com.example.hxhwiki.utils.SoundManager
import com.example.hxhwiki.utils.rememberSoundManager // ← AGREGAR ESTE IMPORT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TriviaScreen(
    navController: NavController,
    viewModel: TriviaViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val soundManager = rememberSoundManager() // ← AGREGAR ESTO

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Trivia Hunter X Hunter",
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    TextButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Text(
                            text = "← Volver",
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
        ) {
            when {
                uiState.showResults -> {
                    // SONIDO AL COMPLETAR TRIVIA ← AGREGAR ESTO
                    LaunchedEffect(uiState.showResults) {
                        if (uiState.showResults) {
                            soundManager.playSound(R.raw.triviacompletada)
                        }
                    }
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
                        },
                        soundManager = soundManager // ← AGREGAR ESTO
                    )
                }
                else -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Cargando preguntas...", color = MaterialTheme.colorScheme.onBackground)
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
    onAnswerSelected: (Int) -> Unit,
    soundManager: SoundManager // ← AGREGAR ESTE PARÁMETRO
) {
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) { isVisible = true }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Indicador
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(tween(500)) + slideInVertically(tween(500))
        ) {
            Text(
                text = "Pregunta $questionNumber/$totalQuestions",
                style = MaterialTheme.typography.titleSmall.copy(
                    color = MaterialTheme.colorScheme.outline
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Nivel
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(tween(500, delayMillis = 200)) +
                    slideInVertically(tween(500, delayMillis = 200))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = pregunta.nivelColor,
                        shape = MaterialTheme.shapes.medium
                    )
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
            enter = fadeIn(tween(500, delayMillis = 400)) +
                    slideInVertically(tween(500, delayMillis = 400))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {

                // Pregunta bonita
                Text(
                    text = pregunta.pregunta,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center,
                        lineHeight = 28.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 12.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Imagen en card con bordes + sombra
                Card(
                    shape = MaterialTheme.shapes.medium,
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                ) {
                    androidx.compose.foundation.Image(
                        painter = painterResource(id = pregunta.imagen),
                        contentDescription = "Imagen de pregunta",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        val optionColors = listOf(
            Color(0xFF4CAF50) to Color.White,  // Verde
            Color(0xFF2196F3) to Color.White,  // Azul
            Color(0xFFFF9800) to Color.White,  // Naranjo
            Color(0xFFF44336) to Color.White   // Rojo
        )

        // Opciones
        pregunta.opciones.forEachIndexed { index, opcion ->
            val (bg, fg) = optionColors[index]

            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(tween(400, delayMillis = 600 + index * 100)) +
                        slideInHorizontally(
                            initialOffsetX = { -100 },
                            animationSpec = tween(400, delayMillis = 600 + index * 100)
                        )
            ) {
                Button(
                    onClick = {
                        soundManager.playSound(R.raw.click) // ← SONIDO AL APRETAR OPCIÓN
                        onAnswerSelected(index)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = bg,
                        contentColor = fg
                    )
                ) {
                    Text(
                        text = "${'a' + index}) $opcion",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(vertical = 8.dp)
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

    var isVisible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { isVisible = true }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(tween(800)) +
                    slideInVertically(
                        initialOffsetY = { it / 2 },
                        animationSpec = tween(800)
                    )
        ) {
            Text(
                text = "¡Trivia Completada!",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                ),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(tween(600, delayMillis = 300)) +
                    slideInVertically(
                        initialOffsetY = { it / 4 },
                        animationSpec = tween(600, delayMillis = 300)
                    )
        ) {
            Text(
                text = "$puntaje/$totalPreguntas",
                style = MaterialTheme.typography.displayMedium.copy(
                    fontWeight = FontWeight.Black,
                    color = MaterialTheme.colorScheme.primary
                )
            )
        }

        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(tween(400, delayMillis = 600))
        ) {
            Text(
                text = "(${percentage.toInt()}%)",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.outline
                )
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(tween(500, delayMillis = 900)) +
                    slideInVertically(
                        initialOffsetY = { 50 },
                        animationSpec = tween(500, delayMillis = 900)
                    )
        ) {
            Text(
                text = resultText,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                ),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(tween(500, delayMillis = 1200))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = onRestart,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
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
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                        contentColor = MaterialTheme.colorScheme.onSurfaceVariant
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
    val respuestaCorrecta: Int,
    val imagen: Int,
)

@Preview(showBackground = true)
@Composable
fun TriviaScreenPreview() {
    TriviaScreen(navController = rememberNavController())
}