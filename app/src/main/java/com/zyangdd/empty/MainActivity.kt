package com.zyangdd.empty

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.zyangdd.empty.base.AppDialog
import com.zyangdd.empty.widget.MultiStateView.State
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            AppDialog(this).apply {
                title = "Alert"
//                negative = "negative"
                positive = "positive"
//                neutral = "neutral"
                message = "Have an new app version! Do you want to upgrade now?"
            }.show()
        }
        button2.setOnClickListener { state_view.update(State.LOADING) }
        button3.setOnClickListener { state_view.update(State.EMPTY) }
        button4.setOnClickListener { state_view.update(State.ERROR) }
    }
}