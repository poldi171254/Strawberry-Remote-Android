package au.llist.strawberryremoteandroid.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Player(onNavigateToHome: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
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
            FloatingActionButton(onClick = {onNavigateToHome() }) {
                Icon(Icons.Default.Add, contentDescription = "Add")

            }
        }
    ) { innerPadding ->
        Box (
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
        ){
             Column (
                 modifier = androidx.compose.ui.Modifier
                     .padding(innerPadding)
                     .padding()
                     .background(color = Color.LightGray),
                 verticalArrangement = Arrangement.spacedBy(16.dp),
                 horizontalAlignment = Alignment.CenterHorizontally
             ){
                 Row {
                     androidx.wear.compose.material.Text(text = "Row1")
                 }
                 Row {
                     androidx.wear.compose.material.Text(text = "Row2")
                 }
             }
        }
    }
}