package au.llist.strawberryremoteandroid.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import au.llist.strawberryremoteandroid.R


@Composable
fun StrawberryHome(modifier: Modifier = Modifier,
                   navController: NavController
){
    Column(modifier = modifier
        .fillMaxSize()
        .padding(20.dp)
    ) {
        Text(stringResource(R.string.welcome_title), modifier = Modifier.padding(20.dp), fontSize = 15.sp, fontWeight = FontWeight.ExtraBold)
        Text(stringResource(R.string.welcome_text1))
        Spacer(modifier = Modifier.height(20.dp))
        Text(stringResource(R.string.welcome_text2))
        Text(stringResource(R.string.welcome_text3), modifier = Modifier.padding(20.dp), fontSize = 15.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Text(stringResource(R.string.welcome_text4))
        Text(stringResource(R.string.welcome_text5), modifier = Modifier.padding(20.dp))

        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly,Alignment.Bottom) {
            ElevatedButton(onClick = { navController.navigate("remote connection") },
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
