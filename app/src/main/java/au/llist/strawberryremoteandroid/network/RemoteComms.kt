package au.llist.strawberryremoteandroid.network



import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import nw.remote.Message
import nw.remote.MsgType
import nw.remote.RequestSongMetadata
import nw.remote.message
import java.io.InputStream
import java.io.OutputStream

import java.net.Socket

class RemoteComms(addrIn: String, portIn: Int) {
    private val addr = addrIn
    private val port = portIn
    private var clientSocket = Socket()
    var outputStream: OutputStream = OutputStream.nullOutputStream()
    var inputStream: InputStream = InputStream.nullInputStream()
    private var isConnected = false
    private val Version = 1
    private var buffer = ByteArray(1024) // Adjust as needed
    var inMsg = Message.newBuilder()
    var outMsg = Message.newBuilder()
    var ll = Message.newBuilder()


    var reqSong = RequestSongMetadata.newBuilder()


    @OptIn(ExperimentalCoroutinesApi::class)
    fun connectRemote() = runBlocking {
        launch(newSingleThreadContext("MyOwnThread")) {
            //launch(newSingleThreadContext("MyOwnThread")) {
            try {
                println("${Thread.currentThread()} has run.")
                clientSocket = Socket(addr, port)
                isConnected = true
                outputStream = clientSocket.getOutputStream()
                inputStream = clientSocket.getInputStream()
                initMsgReuest()
            } catch (e: Exception) {
                isConnected = false
                println("Error: ${e.message}")
            }
        }
        println("${Thread.currentThread()} has run.")
        val aa = ""
    }

    fun isConnected():Boolean{
        return isConnected
    }

    fun initMsgReuest(){
        outMsg.clear()
        outMsg.setType(MsgType.MSG_TYPE_REQUEST_SONG_INFO)
        reqSong.setSend(true)
        outMsg.setRequestSongMetadata(reqSong)

        readMsg()
        println("Errorr wtf")
    }

    fun sendMsg() {
        try {
            // outputStream.write(outMsg.toByteArray())

        }
        catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }

    fun readMsg(){


        try {
            val bytesAvailable = inputStream.available()
            if (bytesAvailable > 0){
                val bytesRead = inputStream.read(buffer,0,bytesAvailable)

            }

        }
        catch(e: Exception) {
            println("Error: ${e.message}")
        }

    }


    fun CloseSocket(){
        clientSocket.close()
    }
}