package com.example.hxhwiki.view.home.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hxhwiki.view.coreNavigation.Home
import com.example.hxhwiki.view.coreNavigation.NenDetailScreen

@Composable

fun NenScreen(navController: NavController) {

    val bg = MaterialTheme.colorScheme.surfaceContainerHighest
    val onBg = MaterialTheme.colorScheme.onSurface
    val primary = MaterialTheme.colorScheme.primary
    val onPrimary = MaterialTheme.colorScheme.onPrimary

    Scaffold(
        containerColor = bg
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(bg),
            contentAlignment = Alignment.Center
        ) {

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp, vertical = 40.dp)

            ) {
                val (
                    enhancement, transmutation, emission,
                    manipulation, conjuration, specialization,
                    centerKanji,
                    enhKanji, transKanji, emisKanji, maniKanji, conjKanji, specKanji
                ) = createRefs()

                val circleSize = 75.dp

                // =============== CÍRCULOS NEN (COLORES ORIGINALES) ===============

                NenCircle(
                    text = "強",
                    color = Color(0xFFDA3B3B),    // Enhancement red
                    modifier = Modifier
                        .size(circleSize)
                        .constrainAs(enhancement) {
                            top.linkTo(parent.top, margin = 120.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    onClick = { navController.navigate(NenDetailScreen("Enhancement")) }
                )

                Text(
                    text = "Enhancement",
                    color = onBg,
                    fontSize = 15.sp,
                    modifier = Modifier.constrainAs(enhKanji) {
                        bottom.linkTo(enhancement.top, margin = 8.dp)
                        start.linkTo(enhancement.start)
                        end.linkTo(enhancement.end)
                    }
                )

                NenCircle(
                    text = "放",
                    color = Color(0xFFFFB347),    // Emission orange
                    modifier = Modifier
                        .size(circleSize)
                        .constrainAs(emission) {
                            top.linkTo(enhancement.bottom, margin = 40.dp)
                            end.linkTo(enhancement.start, margin = 60.dp)
                        },
                    onClick = { navController.navigate(NenDetailScreen("Emission")) }
                )

                Text(
                    text = "Emission",
                    color = onBg,
                    fontSize = 15.sp,
                    modifier = Modifier.constrainAs(emisKanji) {
                        bottom.linkTo(emission.top, margin = 8.dp)
                        start.linkTo(emission.start)
                        end.linkTo(emission.end)
                    }
                )

                NenCircle(
                    text = "変",
                    color = Color(0xFF0023FF),    // Transmutation blue
                    modifier = Modifier
                        .size(circleSize)
                        .constrainAs(transmutation) {
                            top.linkTo(enhancement.bottom, margin = 40.dp)
                            start.linkTo(enhancement.end, margin = 60.dp)
                        },
                    onClick = { navController.navigate(NenDetailScreen("Transmutation")) }
                )

                Text(
                    text = "Transmutation",
                    color = onBg,
                    fontSize = 15.sp,
                    modifier = Modifier.constrainAs(transKanji) {
                        bottom.linkTo(transmutation.top, margin = 8.dp)
                        start.linkTo(transmutation.start)
                        end.linkTo(transmutation.end)
                    }
                )

                NenCircle(
                    text = "特",
                    color = Color(0xFF6A00A4),    // Specialization purple
                    modifier = Modifier
                        .size(circleSize)
                        .constrainAs(specialization) {
                            top.linkTo(enhancement.bottom, margin = 350.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    onClick = { navController.navigate(NenDetailScreen("Specialization")) }
                )

                Text(
                    text = "Specialization",
                    color = onBg,
                    fontSize = 15.sp,
                    modifier = Modifier.constrainAs(specKanji) {
                        bottom.linkTo(specialization.top, margin = 8.dp)
                        start.linkTo(specialization.start)
                        end.linkTo(specialization.end)
                    }
                )

                NenCircle(
                    text = "操",
                    color = Color(0xFF3FB905),    // Manipulation green
                    modifier = Modifier
                        .size(circleSize)
                        .constrainAs(manipulation) {
                            top.linkTo(emission.bottom, margin = 80.dp)
                            end.linkTo(specialization.start, margin = 60.dp)
                        },
                    onClick = { navController.navigate(NenDetailScreen("Manipulation")) }
                )

                Text(
                    text = "Manipulation",
                    color = onBg,
                    fontSize = 15.sp,
                    modifier = Modifier.constrainAs(maniKanji) {
                        bottom.linkTo(manipulation.top, margin = 8.dp)
                        start.linkTo(manipulation.start)
                        end.linkTo(manipulation.end)
                    }
                )

                NenCircle(
                    text = "具",
                    color = Color(0xFF656565),    // Conjuration gray
                    modifier = Modifier
                        .size(circleSize)
                        .constrainAs(conjuration) {
                            top.linkTo(transmutation.bottom, margin = 80.dp)
                            start.linkTo(specialization.end, margin = 60.dp)
                        },
                    onClick = { navController.navigate(NenDetailScreen("Conjuration")) }
                )

                Text(
                    text = "Conjuration",
                    color = onBg,
                    fontSize = 15.sp,
                    modifier = Modifier.constrainAs(conjKanji) {
                        bottom.linkTo(conjuration.top, margin = 8.dp)
                        start.linkTo(conjuration.start)
                        end.linkTo(conjuration.end)
                    }
                )

                Text(
                    text = "発",
                    color = onBg,
                    fontSize = 64.sp,
                    modifier = Modifier.constrainAs(centerKanji) {
                        top.linkTo(enhancement.bottom)
                        bottom.linkTo(specialization.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                )
            }
        }

        // ----------- BOTÓN VOLVER (USANDO EL TEMA) -----------
        Button(
            onClick = { navController.navigate(Home) },
            colors = ButtonDefaults.buttonColors(
                containerColor = primary,
                contentColor = onPrimary
            ),
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "⬅ Volver",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}




@Composable
fun NenCircle(
    text: String,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        shape = CircleShape,
        colors = CardDefaults.cardColors(containerColor = color),
        modifier = modifier.clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NenScreenPreview() {
    NenScreen(navController = rememberNavController())
}