package com.learn.fragmentstackdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.learn.fragmentstackdemo.databinding.ActivityMainBinding
import com.learn.fragmentstackdemo.fragment.FirstFragmentHolder
import com.learn.fragmentstackdemo.fragment.SecondFragmentHolder

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val firstFragmentHolder = FirstFragmentHolder()
        val secondFragmentHolder = SecondFragmentHolder()

        with(activityMainBinding) {

            buttonFirstStack.setOnClickListener {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    detach(secondFragmentHolder)
                    attach(firstFragmentHolder)
                    setPrimaryNavigationFragment(firstFragmentHolder)
                }
            }

            buttonSecondStack.setOnClickListener {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    detach(firstFragmentHolder)
                    attach(secondFragmentHolder)
                    setPrimaryNavigationFragment(secondFragmentHolder)
                }
            }
        }

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_holder, secondFragmentHolder)
                add(R.id.fragment_holder, firstFragmentHolder)
                setPrimaryNavigationFragment(firstFragmentHolder)
            }
        }
    }
}