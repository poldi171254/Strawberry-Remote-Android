package au.llist.strawberryremoteandroid.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


import au.llist.strawberryremoteandroid.ui.screen.Home
import au.llist.strawberryremoteandroid.ui.screen.Player

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") { Home(onNavigateToPlayer = { navController.navigate("player") }) }
        composable("player") { Player(onNavigateToHome = { navController.navigate("home") }) }
    }
}
