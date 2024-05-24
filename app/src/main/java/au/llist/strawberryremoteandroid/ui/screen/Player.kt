package au.llist.strawberryremoteandroid.ui.screen

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Player(onNavigateToHome: () -> Unit) {
    Text(text = "Player")
    Button(onClick = { onNavigateToHome() }) {
        Text(text = "We are here")
    }
}