package com.learn.fragmentstackdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.learn.fragmentstackdemo.R
import com.learn.fragmentstackdemo.databinding.SecondFragmentHolderBinding

class SecondFragmentHolder : Fragment() {
    private lateinit var holderBinding: SecondFragmentHolderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        holderBinding = SecondFragmentHolderBinding.inflate(inflater, container, false)
        return holderBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        childFragmentManager.commit() {
            setReorderingAllowed(true)
            add(R.id.holder, SecondFragment())
        }
    }
}