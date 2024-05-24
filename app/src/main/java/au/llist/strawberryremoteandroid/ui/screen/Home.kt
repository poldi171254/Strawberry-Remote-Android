package au.llist.strawberryremoteandroid.ui.screen

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Home(onNavigateToPlayer: () -> Unit) {
    Text(text = "Home")
    Button(onClick = { onNavigateToPlayer() }) {
        Text(text = "Go to Player")
    }

}

@Preview
@Composable
fun HomePreview() {
    Home({})
}