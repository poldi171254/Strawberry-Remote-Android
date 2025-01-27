package au.llist.strawberryremoteandroid.network

import androidx.navigation.NavController
import au.llist.strawberryremoteandroid.util.SongInfo

fun ConnectRemote(ip: String, port: Int, navController: NavController){

    val remotecomms = RemoteComms(ip, port)
    remotecomms.connectRemote()
    if (remotecomms.isConnected()){
        // Get song info
        val song = SongInfo("test")
        navController.navigate("player")
    } else{
        navController.navigate("connection failed")
    }

}


// port: Int,
// navController: NavController)
// fun ConnectRemote(ip: String,
// port: Int,
// navController: NavController) = runBlocking {
//
// lateinit var socket: Socket
//
// launch(newSingleThreadContext("MyOwnThread")) {
// try {
// socket = Socket()
// //val clientSocket = Socket(ip,port)
// socket.connect(InetSocketAddress(ip, port), 500)
//
// } catch (e: Exception) {
// println("Error: ${e.message}")
// navController.navigate("connection failed")
// }
// }
// navController.navigate("player")
//
// }