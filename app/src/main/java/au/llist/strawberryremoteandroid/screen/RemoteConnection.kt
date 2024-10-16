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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun RemoteConnection(modifier: Modifier = Modifier,
                     navController: NavController){
    var ipConnect by remember { mutableStateOf("192.168.1.1") }
    var portConnect by remember { mutableStateOf("5050") }

    Column (modifier = modifier
        .fillMaxSize()
        .padding(20.dp)
    ){
        Text(stringResource(R.string.network_heading), modifier = Modifier.padding(20.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(20.dp))
        Text(stringResource(R.string.enter_ip), modifier = Modifier.padding(20.dp))
        OutlinedTextField(value = ipConnect,
            onValueChange = {ipConnect = it},
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 30.dp)
                .padding(10.dp),
            singleLine = true,
            textStyle = TextStyle(
                fontWeight = FontWeight.Bold,
                color = Color.Magenta,
                fontSize = 28.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(stringResource(R.string.enter_port), modifier = Modifier.padding(20.dp))
        OutlinedTextField(value = portConnect,
            onValueChange = {portConnect = it},
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 30.dp)
                .padding(10.dp),
            singleLine = true,
            textStyle = TextStyle(
                fontWeight = FontWeight.Bold,
                color = Color.Magenta,
                fontSize = 28.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly, Alignment.Bottom){
            //ElevatedButton(onClick = { navController.navigate("player")},

            ElevatedButton(onClick = {ConnectRemote(ipConnect, portConnect.toInt(), navController)},
                colors = ButtonDefaults.buttonColors(Color.LightGray)) {
                Text("Continue")
                }
            ElevatedButton(onClick = { System.exit(1) },
                colors = ButtonDefaults.buttonColors(Color.LightGray)) {
                Text("Exit")
            }
        }
    }
}
