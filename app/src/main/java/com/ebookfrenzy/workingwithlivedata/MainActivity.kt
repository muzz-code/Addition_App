package com.ebookfrenzy.workingwithlivedata

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        viewModel.currentNumber.observe(
            this,
            Observer {
                findViewById<TextView>(R.id.tv_textView).text = it.toString()
            }
        )
        viewModel.currentBoolean.observe(
            this,
            Observer {
                findViewById<TextView>(R.id.tv_boolean_text).text = it.toString()
            }
        )

        incrementText()
    }
    fun incrementText() {
        findViewById<Button>(R.id.btn_button).setOnClickListener {
            viewModel.currentNumber.value = ++viewModel.number
            viewModel.currentBoolean.value = viewModel.number % 2 == 0
        }
    }
}
