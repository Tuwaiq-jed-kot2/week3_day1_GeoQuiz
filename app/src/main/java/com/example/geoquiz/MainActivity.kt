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
            val x= Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_LONG);

            x.setGravity(Gravity.TOP,20,20)
            x.show()
        }

        trueButton.setOnClickListener {
            val y= Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_LONG);

            y.setGravity(Gravity.TOP,20,20)

            y.show()
        }

    }
}