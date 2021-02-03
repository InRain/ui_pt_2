package com.learn.fragmentstackdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.learn.fragmentstackdemo.R
import com.learn.fragmentstackdemo.databinding.SecondFragmentBinding
import com.learn.fragmentstackdemo.util.FragmentArgumentManager

class SecondFragment : Fragment() {
    private lateinit var secondFragmentBinding: SecondFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        secondFragmentBinding = SecondFragmentBinding.inflate(inflater, container, false)
        return secondFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val argManager = FragmentArgumentManager()

        val counterValue = argManager.getCounter(arguments)
        secondFragmentBinding.textViewCount.text = "$counterValue"

        secondFragmentBinding.textView.setOnClickListener {

            parentFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(
                    R.id.holder,
                    SecondFragment::class.java,
                    argManager.createArgs(counterValue + 1)
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}