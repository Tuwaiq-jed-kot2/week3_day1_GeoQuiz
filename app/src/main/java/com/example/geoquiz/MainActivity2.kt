package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBar

class MainActivity2 : AppCompatActivity() {


    private lateinit var trueButton2: Button
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

                  var doo= actionBar?.setDisplayShowHomeEnabled(true)




    }
}
