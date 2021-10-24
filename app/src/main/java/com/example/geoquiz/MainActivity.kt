package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class MainActivity : AppCompatActivity() {

   private lateinit var falseButton:Button
   private lateinit var trueButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        falseButton = findViewById(R.id.false_button)
        trueButton = findViewById(R.id.true_button)

        falseButton.setOnClickListener {
            val ToasT = Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_SHORT)
           // Toast.makeText(this,R.string.incorrect_toast, LENGTH_SHORT).show()
            ToasT.setGravity(Gravity.TOP,0,300)
            ToasT.show()

        }

        trueButton.setOnClickListener {
            Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_LONG).show()

            val trueToast = Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_LONG)

        }

    }
}