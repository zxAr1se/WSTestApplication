package com.followrates.testapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(
    @LayoutRes val layoutRes: Int
) : Fragment() {
    protected lateinit var binding: VB

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return initDataBinding(inflater, container).also { binding ->
            this.binding = binding
        }.root
    }

    private fun initDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): VB = DataBindingUtil.inflate(
        inflater,
        layoutRes,
        container,
        false
    )
}