package com.example.hxhwiki.view.coreNavigation
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
object NenScreen

@Serializable
object TriviaScreen



@Serializable
data class LeccionTreceDetalle(val nombre: String, val edad: Int)