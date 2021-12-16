package com.followrates.testapplication


import android.os.Bundle
import android.view.View
import com.followrates.testapplication.databinding.FragmentEchoWebSocketBinding

class EchoWebSocketFragment :
    BaseFragment<FragmentEchoWebSocketBinding>(R.layout.fragment_echo_web_socket){

    private lateinit var echoWebSocketListener: EchoWebSocketListener
    private val echoWebSocketViewModel = EchoWebSocketViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        echoWebSocketListener = EchoWebSocketListener()
        binding.btn.setOnClickListener {
            echoWebSocketViewModel.apply {
                start()
                binding.message.text = getInfo()
            }
        }
    }
}