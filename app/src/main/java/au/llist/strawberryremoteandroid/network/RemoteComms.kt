package au.llist.strawberryremoteandroid.network

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import nw.remote.RemoteMessages.Message
import nw.remote.RemoteMessages.MsgType
import nw.remote.message
import nw.remote.requestConnect
import java.io.BufferedReader
import java.io.InputStreamReader

import java.net.Socket

class RemoteComms(addrIn: String, portIn: Int) {
    private val addr = addrIn
    private val port = portIn
    private var clientSocket = Socket()
    private var isConnected = false


    @OptIn(ExperimentalCoroutinesApi::class)
    fun connectRemote() = runBlocking {
        launch(newSingleThreadContext("MyOwnThread")) {
            //launch(newSingleThreadContext("MyOwnThread")) {
            try {
                clientSocket = Socket(addr, port)
                InitMsgReuest()
            } catch (e: Exception) {
                isConnected = false
                println("Error: ${e.message}")
            }
        }
    }

    fun IsConnected():Boolean{
        return isConnected
    }


    fun InitMsgReuest(){
        SendMsg(
            message {
                version = 1
                type = MsgType.MSG_TYPE_CONNECT
                requestConnect {
                    sendCurrentSong = true
                }
            }
        )
    }


    fun SendMsg(msg: Message) {
        try{clientSocket.getOutputStream().write(msg.toByteArray())
            clientSocket.getOutputStream().flush()}
        catch (e: Exception) {
            println("Error: ${e.message}")
        }

        val msgIn = message {  }

        val reader = clientSocket.getInputStream().readAllBytes()


    }

    fun CloseSocket(){
        clientSocket.close()
    }
}