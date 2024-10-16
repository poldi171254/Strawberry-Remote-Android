package au.llist.strawberryremoteandroid.network

import android.widget.Toast
import androidx.navigation.NavController
import java.net.Socket

fun ConnectRemote(ip: String,
                  port: Int,
                  navController: NavController) {
    try {
        val clientSocket = Socket(ip,port)
        navController.navigate("player")

    }catch (e: Exception) {
        //println("Error: ${e.message}")
        navController.navigate("connection failed")
    }
}