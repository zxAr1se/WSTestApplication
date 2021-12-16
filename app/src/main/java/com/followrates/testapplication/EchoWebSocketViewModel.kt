package com.followrates.testapplication

import okhttp3.OkHttpClient
import okhttp3.Request

class EchoWebSocketViewModel{

    private var client: OkHttpClient = OkHttpClient()
    private lateinit var wsListener: EchoWebSocketListener

    fun start() {
        val request = Request.Builder().url("wss://api.demo.hitbtc.com/api/3/ws/public").build()
        wsListener = EchoWebSocketListener()
        val ws: okhttp3.WebSocket = client.newWebSocket(request, wsListener)

        client.dispatcher.executorService.shutdown()
    }

    fun getInfo(): String = wsListener.result
}