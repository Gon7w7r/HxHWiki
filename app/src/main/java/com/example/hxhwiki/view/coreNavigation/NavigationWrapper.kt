package com.example.hxhwiki.view.coreNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.hxhwiki.view.home.HomeScreen
import com.example.hxhwiki.view.home.HomeViewModel
import com.example.hxhwiki.view.home.screens.NenScreen
import com.example.hxhwiki.view.home.screens.NenDetailScreen
import com.example.hxhwiki.view.home.screens.TriviaScreen.TriviaScreen
import com.example.hxhwiki.view.home.screens.UserDetailScreen


@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {

        // Pantalla principal
        composable<Home> {
            HomeScreen(
                homeViewModel = HomeViewModel(),
                navController = navController
            )
        }

        // Nueva pantalla NenScreen
        composable<NenScreen> {
            NenScreen(navController = navController)
        }

        // Nueva pantalla NenScreen
        composable<TriviaScreen> {
            TriviaScreen(navController = navController)
        }

        composable<NenDetailScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<NenDetailScreen>()
            NenDetailScreen(
                nenTitle = args.nenType, // usamos el valor del parámetro
                navController = navController
            )
        }


        composable<UserDetailScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<UserDetailScreen>()
            UserDetailScreen(
                name = args.userName,
                navController = navController
            )
        }




    }
}