package com.example.hxhwiki.view.coreNavigation
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
object NenScreen

@Serializable
object TriviaScreen


@Serializable
object enhancementScreen
@Serializable
object emissionScreen
@Serializable
object transmutationScreen
@Serializable
object specializationScreen
@Serializable
object manipulationScreen
@Serializable
object conjurationScreen

@Serializable
data class LeccionTreceDetalle(val nombre: String, val edad: Int)