package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var falseButton: Button
    private lateinit var trueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        falseButton = findViewById(R.id.false_button)
        trueButton = findViewById(R.id.true_button)

        falseButton.setOnClickListener {
            Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_LONG).show()
            val myToast1 = Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT)
            myToast1.setGravity(Gravity.TOP, 0, 0)
            myToast1.show()

            trueButton.setOnClickListener {
                Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_LONG).show()
                val myToast2 = Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT)
                myToast2.setGravity(Gravity.TOP, 0, 0)
                myToast2.show()
            }

        }
    }
