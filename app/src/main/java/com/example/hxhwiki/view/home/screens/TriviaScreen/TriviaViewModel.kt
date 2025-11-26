// TriviaViewModel.kt
package com.example.hxhwiki.view.home.screens.TriviaScreen

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hxhwiki.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TriviaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(TriviaUiState())
    val uiState: StateFlow<TriviaUiState> = _uiState.asStateFlow()

    private val questions = listOf(
        TriviaQuestion(
            nivel = "FÁCIL",
            nivelColor = Color(0xFF4CAF50),
            pregunta = "¿Cómo se llama el mejor amigo de Gon?",
            opciones = listOf("Killua", "Leorio", "Kurapika", "Hanzo"),
            respuestaCorrecta = 0,
            imagen = R.drawable.pregunta1
        ),
        TriviaQuestion(
            nivel = "FÁCIL",
            nivelColor = Color(0xFF4CAF50),
            pregunta = "¿Qué criatura captura Gon al inicio del anime en la Isla Ballena?",
            opciones = listOf("Un lobo salvaje", "Un pez gigante", "Un pájaro mutante", "Un jabalí de Nen"),
            respuestaCorrecta = 1,
            imagen = R.drawable.pregunta2
        ),
        TriviaQuestion(
            nivel = "FÁCIL",
            nivelColor = Color(0xFF4CAF50),
            pregunta = "¿Cuál es el objetivo principal de Kurapika?",
            opciones = listOf("Vengar a su familia", "Ser el mejor cazador", "Matar a Killua", "Encontrar a Ging"),
            respuestaCorrecta = 0,
            imagen = R.drawable.pregunta3
        ),
        TriviaQuestion(
            nivel = "MEDIO",
            nivelColor = Color(0xFFFFC107),
            pregunta = "¿Cuál es el nombre completo del presidente de la Asociación de Cazadores?",
            opciones = listOf("Isaac Netero", "Gon Freecss", "Satotz Hunter", "Kite Han"),
            respuestaCorrecta = 0,
            imagen = R.drawable.pregunta4
        ),
        TriviaQuestion(
            nivel = "MEDIO",
            nivelColor = Color(0xFFFFC107),
            pregunta = "¿Qué condición impone Kurapika para usar su cadena \"Chain Jail\"?",
            opciones = listOf(
                "No puede usarla contra humanos",
                "Solo la puede usar con miembros de la Tropa Fantasma",
                "Debe recibir daño antes",
                "Debe estar en modo Emperador"
            ),
            respuestaCorrecta = 1,
            imagen = R.drawable.pregunta5
        ),
        TriviaQuestion(
            nivel = "MEDIO",
            nivelColor = Color(0xFFFFC107),
            pregunta = "¿Cómo se llama la hermana de Killua que tiene el poder de conceder deseos?",
            opciones = listOf("Alluka", "Kalluto", "Kikyo", "Milluki"),
            respuestaCorrecta = 0,
            imagen = R.drawable.pregunta6
        ),
        TriviaQuestion(
            nivel = "DIFÍCIL",
            nivelColor = Color(0xFFF44336),
            pregunta = "¿Qué jugador de Greed Island tiene la habilidad \"Little Flower\" (Pequeña Flor)?",
            opciones = listOf("Genthru", "Tsezguerra", "Binolt", "Bara"),
            respuestaCorrecta = 0,
            imagen = R.drawable.pregunta7
        ),
        TriviaQuestion(
            nivel = "DIFÍCIL",
            nivelColor = Color(0xFFF44336),
            pregunta = "¿Cuál es la habilidad principal de Knuckle?",
            opciones = listOf("Hakoware", "Nen Hook", "Interest Rush", "Godspeed"),
            respuestaCorrecta = 0,
            imagen = R.drawable.pregunta8
        ),
        TriviaQuestion(
            nivel = "DIFÍCIL",
            nivelColor = Color(0xFFF44336),
            pregunta = "¿Cuál es el nombre del juego que Gon y Killua entran para encontrar pistas sobre Ging?",
            opciones = listOf("Nen Quest", "Dark Continent", "Greed Island", "Hunter's Maze"),
            respuestaCorrecta = 2,
            imagen = R.drawable.pregunta9
        ),
        TriviaQuestion(
            nivel = "LEYENDA",
            nivelColor = Color(0xFF9C27B0),
            pregunta = "¿Qué número tenía el participante Hanzo durante el examen de cazador?",
            opciones = listOf("94", "294", "255", "103"),
            respuestaCorrecta = 1,
            imagen = R.drawable.pregunta10
        ),
        TriviaQuestion(
            nivel = "LEYENDA",
            nivelColor = Color(0xFF9C27B0),
            pregunta = "En el arco de las Hormigas Quimera, ¿qué peinado tenía Knov cuando aparece por primera vez?",
            opciones = listOf(
                "Corto y peinado hacia atrás",
                "Mullet con patillas",
                "Peinado con raya al lado, bien formal",
                "Peluca blanca estilo punk"
            ),
            respuestaCorrecta = 2,
            imagen = R.drawable.pregunta11
        ),
        TriviaQuestion(
            nivel = "LEYENDA",
            nivelColor = Color(0xFF9C27B0),
            pregunta = "¿Qué personaje impide el paso a Gon y Killua cuando suben al piso 200 por primera vez?",
            opciones = listOf(
                "Chrollo",
                "Hisoka",
                "Kurapika",
                "Genthru"
            ),
            respuestaCorrecta = 1,
            imagen = R.drawable.pregunta12
        )
    )

    init {
        _uiState.value = _uiState.value.copy(questions = questions)
    }

    fun selectAnswer(selectedAnswer: Int) {
        viewModelScope.launch {
            val currentState = _uiState.value
            val currentQuestion = currentState.questions[currentState.currentQuestionIndex]

            val newScore = if (selectedAnswer == currentQuestion.respuestaCorrecta) {
                currentState.score + 1
            } else {
                currentState.score
            }

            val nextQuestionIndex = currentState.currentQuestionIndex + 1
            val showResults = nextQuestionIndex >= currentState.questions.size

            _uiState.value = currentState.copy(
                score = newScore,
                currentQuestionIndex = nextQuestionIndex,
                showResults = showResults
            )
        }
    }

    fun restartGame() {
        viewModelScope.launch {
            _uiState.value = TriviaUiState(questions = questions)
        }
    }

    fun exitGame() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(showResults = false)
        }
    }
}

data class TriviaUiState(
    val questions: List<TriviaQuestion> = emptyList(),
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val showResults: Boolean = false
)

// Función de extensión para convertir Color de Android a Compose Color
fun Int.toComposeColor(): androidx.compose.ui.graphics.Color {
    return androidx.compose.ui.graphics.Color(this)
}