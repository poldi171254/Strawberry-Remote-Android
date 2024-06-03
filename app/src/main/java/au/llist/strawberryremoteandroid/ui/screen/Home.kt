package au.llist.strawberryremoteandroid.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import au.llist.strawberryremoteandroid.R


@Composable
fun Home(onNavigateToPlayer: () -> Unit){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        shadowElevation = 10.dp
    ) {
        Column {
            WelcomeCard()
        }

    }
}

@Composable
fun WelcomeCard(){
    Row (horizontalArrangement = Arrangement.Center){
        Image(
            painter = painterResource(R.drawable.strawberry),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(100.dp)
                //.clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary)
        )

    }
    Spacer(modifier = Modifier.width(8.dp))
    Text(text = "This is the text")
}

@Preview
@Composable
fun HomePreview() {
    Home(){}
}