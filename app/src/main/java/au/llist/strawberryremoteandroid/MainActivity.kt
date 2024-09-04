package au.llist.strawberryremoteandroid
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import au.llist.strawberryremoteandroid.ui.theme.StrawberryRemoteAndroidTheme
import au.llist.strawberryremoteandroid.util.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StrawberryRemoteAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize().background(color = Color.Red),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}