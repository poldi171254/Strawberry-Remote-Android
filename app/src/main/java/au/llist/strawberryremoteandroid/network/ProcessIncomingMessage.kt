package au.llist.strawberryremoteandroid.network

import nw.remote.Message
import nw.remote.MsgType

fun processIncomingMessage(serializedData: ByteArray) {
    try {
        // Deserialize the incoming data into a Message object
        val incomingMessage = Message.parseFrom(serializedData)

        // Handle the message based on its type
        when (incomingMessage.type) {
            MsgType.MSG_TYPE_REQUEST_PLAY -> {
                val requestPlay = incomingMessage.requestPlay
                println("Processing RequestPlay: play = ${requestPlay.play}")
                // Add logic to handle play requests
            }
            MsgType.MSG_TYPE_REQUEST_PAUSE -> {
                val requestPause = incomingMessage.requestPause
                println("Processing RequestPause: pause = ${requestPause.pause}")
                // Add logic to handle pause requests
            }
            MsgType.MSG_TYPE_REQUEST_STOP -> {
                val requestStop = incomingMessage.requestStop
                println("Processing RequestStop: stop = ${requestStop.stop}")
                // Add logic to handle stop requests
            }
            MsgType.MSG_TYPE_REQUEST_NEXT -> {
                val requestNextTrack = incomingMessage.requestNextTrack
                println("Processing RequestNextTrack: next = ${requestNextTrack.next}")
                // Add logic to handle next track requests
            }
            MsgType.MSG_TYPE_REQUEST_PREVIOUS -> {
                val requestPreviousTrack = incomingMessage.requestPreviousTrack
                println("Processing RequestPreviousTrack: previous = ${requestPreviousTrack.previous}")
                // Add logic to handle previous track requests
            }
            MsgType.MSG_TYPE_REPLY_SONG_INFO -> {
                val responseSongMetadata = incomingMessage.responseSongMetadata
                println("Processing ResponseSongMetadata: songMetadata = ${responseSongMetadata.songMetadata}, playerState = ${responseSongMetadata.playerState}")
                // Add logic to process song metadata replies
            }
            MsgType.MSG_TYPE_ENGINE_STATE_CHANGE -> {
                val engineStateChange = incomingMessage.engineStateChange
                println("Processing EngineStateChange: state = ${engineStateChange.state}")
                // Add logic to handle engine state changes
            }
            MsgType.MSG_TYPE_DISCONNECT -> {
                val requestDisconnect = incomingMessage.requestDisconnect
                println("Processing Disconnect: reason = ${requestDisconnect.reasonDisconnect}")
                // Add logic to handle disconnection requests
            }
            else -> {
                println("Unknown message type: ${incomingMessage.type}")
            }
        }
    } catch (e: Exception) {
        println("Failed to process incoming message: ${e.message}")
    }
}