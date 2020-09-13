package com.returnnotfound.empty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.returnnotfound.empty.widget.MultiStateView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { state_view.update(MultiStateView.State.CONTENT) }
        button2.setOnClickListener { state_view.update(MultiStateView.State.LOADING) }
        button3.setOnClickListener { state_view.update(MultiStateView.State.EMPTY) }
        button4.setOnClickListener { state_view.update(MultiStateView.State.ERROR) }
    }
}