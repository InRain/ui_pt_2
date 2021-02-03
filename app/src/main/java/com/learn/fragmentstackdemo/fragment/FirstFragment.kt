package com.learn.fragmentstackdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.learn.fragmentstackdemo.R
import com.learn.fragmentstackdemo.databinding.FirstFragmentBinding
import com.learn.fragmentstackdemo.util.FragmentArgumentManager

class FirstFragment : Fragment() {
    private lateinit var firstFragmentBinding: FirstFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        firstFragmentBinding = FirstFragmentBinding.inflate(inflater, container, false)
        return firstFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val argManager = FragmentArgumentManager()

        val counterValue = argManager.getCounter(arguments)
        firstFragmentBinding.textViewCount.text = "$counterValue"

        firstFragmentBinding.textView.setOnClickListener {

            parentFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(
                    R.id.holder,
                    FirstFragment::class.java,
                    argManager.createArgs(counterValue + 1)
                )
                addToBackStack(null)
                commit()
            }
        }

    }
}