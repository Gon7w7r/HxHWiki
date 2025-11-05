package com.example.hxhwiki.view.home.screens.userDetailData



import com.example.hxhwiki.R

data class Character(
    val name: String,
    val age: Int,
    val origin : String,
    val power: String,
    val goal: String,
    val imageRes: Int
)

object UserData {
    val characters = listOf(
        Character("Gon Freecss", 14,"Isla Ballena", "Jajanken", "Encontrar a su padre", R.drawable.gonactual),
        Character("Killua Zoldyck", 14,"Montaña Kukuroo", "Electricidad (Transmutación)", "Ser libre de su familia", R.drawable.killua),
        Character("Hisoka Morow", 28,"Glam Gastland", "Bungee Gum", "Peleas interesantes", R.drawable.hisoka),

    )
}
