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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
            .also { setContentView(it.root) }
    }
}