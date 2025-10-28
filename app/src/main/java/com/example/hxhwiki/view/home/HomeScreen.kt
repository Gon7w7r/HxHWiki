package com.example.hxhwiki.view.home

import androidx.compose.foundation.Image
import com.example.hxhwiki.R

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),  // Coloca verticalScroll aquí
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                painter = painterResource(id = R.drawable.hxhlogo),
                contentDescription = null
            )

            Text(
                style = MaterialTheme.typography.titleLarge,
                text = "Hunter x Hunter trata sobre la historia de Gon Freecs, un niño que se convierte en cazador profesional para encontrar a su padre, Ging, quien también fue un cazador legendario y lo abandonó cuando era pequeño. Para lograrlo, Gon debe pasar el riguroso y peligroso \"Examen de Cazador\" y, en el camino, conoce y se hace amigo de otros tres aspirantes: Kurapika, Leorio y Killua.\n"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Coloca todas las imágenes dentro de un solo Column scrollable
            Image(
                modifier = Modifier
                    .height(300.dp)
                    .width(300.dp),
                painter = painterResource(id = R.drawable.imagenarco),
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .height(300.dp)
                    .width(300.dp),
                painter = painterResource(id = R.drawable.imagenarco),
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .height(300.dp)
                    .width(300.dp),
                painter = painterResource(id = R.drawable.imagenarco),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Mueve los botones dentro del mismo Column
            Button(
                onClick = { navController.navigate(NenScreen) },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = "Tipos X de X Nen")
            }
            Button(
                onClick = { navController.navigate(TriviaScreen) },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = "Trivia de Hunter X Hunter")
            }
        }
    }
}
