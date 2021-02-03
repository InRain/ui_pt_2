package com.learn.fragmentstackdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.learn.fragmentstackdemo.R
import com.learn.fragmentstackdemo.databinding.FirstFragmentHolderBinding

class FirstFragmentHolder : Fragment() {
    private lateinit var holderBinding: FirstFragmentHolderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        holderBinding = FirstFragmentHolderBinding.inflate(inflater, container, false)
        return holderBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        childFragmentManager.commit() {
            setReorderingAllowed(true)
            add(R.id.holder, FirstFragment())
        }
    }
}