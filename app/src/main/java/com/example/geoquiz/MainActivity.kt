package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.view.Gravity


class MainActivity : AppCompatActivity() {

   private lateinit var falseButton:Button
   private lateinit var trueButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        falseButton = findViewById(R.id.false_button)
        trueButton = findViewById(R.id.true_button)

        falseButton.setOnClickListener {
            val toast =Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_LONG)
            toast.show()
            toast.setGravity(Gravity.TOP,200,200)
            toast.show()
        }

        trueButton.setOnClickListener {
            val toast = Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_LONG)
            toast.show()
            toast.setGravity(Gravity.TOP,200,200)
            toast.show()
        }


    }


}
