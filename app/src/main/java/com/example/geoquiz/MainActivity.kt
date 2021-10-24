package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

   private lateinit var falseButton:Button
   private lateinit var trueButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        falseButton = findViewById(R.id.false_button)
        trueButton = findViewById(R.id.true_button)

        falseButton.setOnClickListener {

            val text = R.string.incorrect_toast
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext , text , duration)
            toast.show()
            toast.setGravity(Gravity.TOP , 0 , 0)

        }

        trueButton.setOnClickListener {
            val text = R.string.correct_toast
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext , text , duration)
            toast.show()
            toast.setGravity(Gravity.TOP , 0 , 0)
        }

    }
}