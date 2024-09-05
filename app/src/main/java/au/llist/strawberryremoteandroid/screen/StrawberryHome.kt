package au.llist.strawberryremoteandroid.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.material.Button
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

        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { /*TODO*/ }) {

            }
            Button(onClick = { /*TODO*/ }) {
            }
        }
    }
}
