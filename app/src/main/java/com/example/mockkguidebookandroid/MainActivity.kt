package com.example.mockkguidebookandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val test = "Something".removeFirstLastChar()
    }

    fun String.removeFirstLastChar(): String = this.substring(1,this.length -1)
}