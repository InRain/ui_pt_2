package com.learn.fragmentstackdemo.util

import android.os.Bundle
import androidx.core.os.bundleOf

class FragmentArgumentManager {
    fun getCounter(args: Bundle?): Int = args?.getInt(KEY_FIRST_FRAGMENT_COUNTER) ?: 0
    fun createArgs(counter: Int) = bundleOf(KEY_FIRST_FRAGMENT_COUNTER to counter)

    companion object {
        const val KEY_FIRST_FRAGMENT_COUNTER = "KEY_FIRST_FRAGMENT_COUNTER"
    }
}