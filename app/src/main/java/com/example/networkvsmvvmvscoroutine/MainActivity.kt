package com.example.networkvsmvvmvscoroutine

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var viewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tvText : TextView = findViewById(R.id.tv_text)
        var process : ProgressBar = findViewById(R.id.progress_bar)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        tvText.visibility = View.INVISIBLE
        process.visibility = View.VISIBLE

        viewModel.getData(this)

        viewModel.image.observe(this, Observer {
            tvText.visibility = View.VISIBLE
            process.visibility = View.GONE

            tvText.text = it.url

        })

    }

}


