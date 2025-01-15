package au.llist.strawberryremoteandroid.network

import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import java.net.Socket

class RemoteComms(addrIn: String, portIn: Int) {
    private val addr = addrIn
    private val port = portIn
    private var clientSocket = Socket()
    private var isConnected = false

    fun ConnectRemote() = runBlocking {
        launch {
            //launch(newSingleThreadContext("MyOwnThread")) {
            try {
                clientSocket = Socket(addr, port)
                isConnected = true
            } catch (e: Exception) {
                isConnected = false
                //println("Error: ${e.message}")
            }
        }
    }

    fun IsConnected():Boolean{
        return isConnected
    }

    fun CloseSocket(){
        clientSocket.close()
    }
}