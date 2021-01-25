package com.zyangdd.empty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zyangdd.empty.databinding.ActivityMainBinding
import com.zyangdd.empty.widget.MultiStateView.State

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
//            AppDialog(this).apply {
//                title = "Alert"
////                negative = "negative"
//                positive = "positive"
////                neutral = "neutral"
//                message = "Have an new app version! Do you want to upgrade now?"
//            }.show()
        }
        binding.button2.setOnClickListener { binding.stateView.update(State.LOADING) }
        binding.button3.setOnClickListener { binding.stateView.update(State.EMPTY) }
        binding.button4.setOnClickListener { binding.stateView.update(State.ERROR) }
    }
}