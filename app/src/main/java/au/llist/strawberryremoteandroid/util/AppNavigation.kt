package au.llist.strawberryremoteandroid.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import au.llist.strawberryremoteandroid.screen.ConnectionFailed
import au.llist.strawberryremoteandroid.screen.Player
import au.llist.strawberryremoteandroid.screen.RemoteConnection
import au.llist.strawberryremoteandroid.screen.StrawberryHome

@Composable
fun AppNavigation(modifier: Modifier = Modifier){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "strawberry") {
        composable(route = "strawberry") { StrawberryHome(modifier, navController)}
        composable(route = "remote connection") { RemoteConnection(modifier, navController) }
        composable(route = "player") { Player(modifier, navController) }
        composable(route = "connection failed") { ConnectionFailed(modifier, navController) }
    }
}