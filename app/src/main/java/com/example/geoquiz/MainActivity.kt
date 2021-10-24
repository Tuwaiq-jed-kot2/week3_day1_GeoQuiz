package com.example.geoquiz

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var falseButton: Button
    private lateinit var trueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        falseButton = findViewById(R.id.false_button)
        trueButton = findViewById(R.id.true_button)

        /*
        i tried this code below to change toast position
        but i don't know for some reason the toast position does not change
         */
        falseButton.setOnClickListener {
            //Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_LONG);
           val toast1 : Toast = Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_LONG);
            toast1.setGravity(Gravity.TOP,50,50)
            toast1.show()

        }

        trueButton.setOnClickListener {

            val toast1 : Toast = Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_LONG);
            toast1.setGravity(Gravity.TOP, 0, 0)
            toast1.show()
        }

    }

}