package au.llist.strawberryremoteandroid.network

import android.util.Log
import kotlinx.coroutines.*
import nw.remote.Message
import nw.remote.MsgType
import nw.remote.RequestSongMetadata
import nw.remote.SongMetadata
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStream
import java.net.Socket

class TcpClient(private val serverAddress: String, private val serverPort: Int) {
    private var clientSocket: Socket? = null
    private var outputStream: OutputStream = OutputStream.nullOutputStream()
    private var inputStream: InputStream = InputStream.nullInputStream()
    @Volatile
    private var isConnected = false
    @Volatile
    private var msgSent = false
    @Volatile
    private var messageRcvd = false
    private val Version = 1
    private var msgOut = Message.newBuilder()

    private var msgIn = ""
    private var reqSong = RequestSongMetadata.newBuilder()
    private val TAG = "MyRemote"

    private val scope = CoroutineScope(Dispatchers.IO)

    /**
     * Connects to the server using a coroutine.
     * @return The Job object for the connect coroutine.
     */
    fun connect(): Job {
        return scope.launch(CoroutineName("Connect")) {
            try {
                clientSocket = Socket(serverAddress, serverPort)
                Log.d(TAG, "Connected to server at $serverAddress:$serverPort")
                outputStream = clientSocket!!.getOutputStream()
                inputStream = clientSocket!!.getInputStream()
                isConnected = true
            } catch (e: Exception) {
                isConnected = false
                Log.d(TAG, "Failed to connect: ${e.message}")
            }
        }
    }

    /**
     * Sends a message to the server.
     * @param serializedData The message to send.
     */
    fun sendMessage(msgType: MsgType): Job {
        return scope.launch(CoroutineName("Send Message")) {
            // Build the message
            msgSent = false
            msgOut.clear()
            msgOut.setType(msgType)
            when (msgType) {
                MsgType.MSG_TYPE_REQUEST_SONG_INFO -> {
                    reqSong.setSend(true).build()
                    msgOut.setRequestSongMetadata(reqSong).build()
                }
                MsgType.MSG_TYPE_REQUEST_PLAY -> {}
                MsgType.MSG_TYPE_REQUEST_NEXT -> {}
                MsgType.MSG_TYPE_REQUEST_PREVIOUS -> {}
                MsgType.MSG_TYPE_REQUEST_PAUSE -> {}
                MsgType.MSG_TYPE_REQUEST_FINISH -> {}
                else -> {
                    Log.d(TAG, "Unknown message type: ${msgType}")
                }
            }
            try {
                Log.d(TAG, "Try to send message")
                outputStream.write(msgOut.build().toByteArray())
                outputStream.flush()
                msgSent = true
                Log.d(TAG, "Message sent")
            } catch (e: Exception) {
                msgSent = false
                Log.d(TAG, "Failed to send message: ${e.message}")
            }
        }
    }

    /**
     * Reads the server's response using a coroutine.
     * @param callback A callback function to handle the response.
     */
    fun readResponse(callback: (Message?) -> Unit) {
        scope.launch(CoroutineName("Send Message")) {
            try {
                val buffer = ByteArray(10024)
                val bytesRead = inputStream.read(buffer)
                if (bytesRead > 0) {
                    val response = Message.parseFrom(buffer.copyOf(bytesRead))
                    Log.d(TAG, "Response received: ${response.type}")
                        callback(response)
                } else {
                        callback(null)

                }
            } catch (e: Exception) {
                Log.d(TAG, "Failed to read response: ${e.message}")
                withContext(Dispatchers.Main) {
                    callback(null)
                }
            }
        }
    }

    fun isConnected(): Boolean {
        Log.d(TAG, "isConnect is ${isConnected}")
        return isConnected
    }

    fun msgSent(): Boolean{
        Log.d(TAG, "msgSent is ${msgSent}")
        return msgSent
    }

    fun messageRcvd() : Boolean{
        return messageRcvd
    }
    /**
     * Closes the connection to the server.
     */
    fun disconnect() {
        try {
            this.clientSocket?.close()
            println("Disconnected from server")
        } catch (e: Exception) {
            println("Failed to disconnect: ${e.message}")
            e.printStackTrace()
        }
    }

    /**
     * Cancels the coroutine scope when the TcpClient is no longer needed.
     */
    fun cleanup() {
        scope.cancel()
    }
}