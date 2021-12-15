package com.followrates.testapplication

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocketListener
import okio.ByteString
import org.java_websocket.WebSocket
import org.java_websocket.drafts.Draft
import org.java_websocket.framing.Framedata
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.handshake.Handshakedata
import org.java_websocket.handshake.ServerHandshake
import org.java_websocket.handshake.ServerHandshakeBuilder
import java.lang.Exception
import java.net.InetSocketAddress
import java.nio.ByteBuffer

class EchoWebSocketListener : WebSocketListener() {

    private val NORMAL_CLOSURE_STATUS = 1000

    override fun onOpen(webSocket: okhttp3.WebSocket, response: Response) {
        webSocket.send("Hello")
    }

    override fun onMessage(webSocket: okhttp3.WebSocket, bytes: ByteString) {

    }
}