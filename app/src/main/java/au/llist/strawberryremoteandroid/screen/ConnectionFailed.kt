package au.llist.strawberryremoteandroid.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import au.llist.strawberryremoteandroid.R
import au.llist.strawberryremoteandroid.network.ConnectRemote

@Composable
fun ConnectionFailed(modifier: Modifier = Modifier,
                     navController: NavController){
    Column (modifier = modifier
        .fillMaxSize()
        .padding(20.dp)
    ) {
        Text(
            stringResource(R.string.connection_error), modifier = Modifier.padding(20.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center)
    }
    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly, Alignment.Bottom){
        ElevatedButton(onClick = { navController.navigate("remote connection")  },
            colors = ButtonDefaults.buttonColors(Color.LightGray)) {
            Text("Retry")
        }
        ElevatedButton(onClick = { System.exit(1) },
            colors = ButtonDefaults.buttonColors(Color.LightGray)) {
            Text("Exit")
        }
    }
}