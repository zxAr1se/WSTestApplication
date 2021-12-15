package com.followrates.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.followrates.testapplication.databinding.ActivityMainBinding
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okio.ByteString

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var client: OkHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
            .also { setContentView(it.root) }

        client = OkHttpClient()
        binding.btn.setOnClickListener {
            start()
        }
    }

    fun start() {
        val request = Request.Builder().url("wss://api.demo.hitbtc.com/api/3/ws/public").build()
        val wsListener = EchoWebSocketListener()
        val ws: okhttp3.WebSocket = client.newWebSocket(request, wsListener)

        client.dispatcher.executorService.shutdown()
    }

    inner class EchoWebSocketListener : okhttp3.WebSocketListener() {

        private val NORMAL_CLOSURE_STATUS = 1000

        override fun onOpen(webSocket: okhttp3.WebSocket, response: Response) {
            Log.d("TAG1", "onOpen: ")
        }

        override fun onMessage(webSocket: okhttp3.WebSocket, text: String) {
            output("Receiving: $text")
            Log.d("TAG2", "onMessage: ")
        }

        override fun onMessage(webSocket: okhttp3.WebSocket, bytes: ByteString) {
            output("Receiving bytes: ${bytes.hex()}")
        }

        override fun onClosing(webSocket: okhttp3.WebSocket, code: Int, reason: String) {
            webSocket.close(NORMAL_CLOSURE_STATUS, null)
            Log.d("TAG3", "onClosing: ")
        }

        override fun onFailure(webSocket: okhttp3.WebSocket, t: Throwable, response: Response?) {
            output("Error: ${t.message}")
            Log.d("TAG4", "onFailure: ")
        }
    }

    private fun output(text: String) {
        runOnUiThread {
            binding.message.text = text
        }
    }
}