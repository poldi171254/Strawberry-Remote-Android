package au.llist.strawberryremoteandroid.ui.screen


import android.content.pm.PackageManager
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(onNavigateToPlayer: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Strawberry Remote")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                Text(
                    text = "This is the bottom"
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {onNavigateToPlayer()}) {
                Icon(Icons.Default.Add, contentDescription = "Add")

            }
        }
    ) { innerPadding ->
        Column(
            modifier = androidx.compose.ui.Modifier.padding(innerPadding).padding().background(color = Color.LightGray),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = ("The Strawberry Remote provides very basic features to control the Strawberry Music Player:\n\n" +
                        "     You can play the next/previous song\n" +
                        "     You can Pause/Play a song\n\n" +
                        "The Remote currently only works on local networks. \n" +
                        "You will need to enable Remote Access in the Player and take note of the Ip Address and the Port the player will be listening on for a remote connection\n").trimIndent(),
                androidx.compose.ui.Modifier.padding(30.dp),

            )
            Row (
            ){
                Text(text = "This is a row")
            }
        }
    }
}


@Preview
@Composable
fun HomePreview() {
    Home(){}
}