package au.llist.strawberryremoteandroid.network

import android.util.Log
import androidx.navigation.NavController
import kotlinx.coroutines.runBlocking
import nw.remote.MsgType

fun ConnectRemote(ip: String, port: Int, navController: NavController) {
    val TAG = "MyRemote"

    val tcpClient = TcpClient(ip, port)
    Log.d(TAG, "Connecting to server")

    // Use runBlocking to wait for the connect coroutine to complete
    runBlocking {
        tcpClient.connect().join() // Wait for the connect coroutine to finish
    }

    if (tcpClient.isConnected()) {
        Log.d(TAG, "Sending message to server")
        // Get song info
        // Send a request to get the Song details
        runBlocking {
            tcpClient.sendMessage(MsgType.MSG_TYPE_REQUEST_SONG_INFO).join()
        }
        if (tcpClient.msgSent()){
            Log.d(TAG, "Message sent")
            runBlocking {
                tcpClient.readResponse { response ->
                    if (response != null) {
                        when (response.type) {
                            MsgType.MSG_TYPE_REPLY_SONG_INFO -> {
                                val songMetadata = response.responseSongMetadata
                                Log.d(TAG, "Received song metadata: ${songMetadata.songMetadata.title}")
                            }
                            else -> {
                                Log.d(TAG,"Received unknown response type: ${response.type}")
                            }
                        }
                    } else {
                        Log.d(TAG, "No response received")
                    }
                }
            }
            navController.navigate("player")
        }
        else{
            // Need a screen for error
            Log.d(TAG, "Problem sending Message")
        }

    } else {
        navController.navigate("connection failed")
    }
}