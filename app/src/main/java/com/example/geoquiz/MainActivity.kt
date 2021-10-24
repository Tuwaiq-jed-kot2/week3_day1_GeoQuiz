package com.example.geoquiz

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

   private lateinit var falseButton:Button
   private lateinit var trueButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        falseButton = findViewById(R.id.false_button)
        trueButton = findViewById(R.id.true_button)

//        As it said in Android documentation about Toast setGravity method, this method doesn't work anymore for devices
//        running API30 or higher.

        //wrote it for the effort :)
        falseButton.setOnClickListener {
            val falseToast = Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_LONG)
            falseToast.setGravity(Gravity.TOP,0,0)
            falseToast.show()
        }

        trueButton.setOnClickListener {
            val trueToast = Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_LONG)
            trueToast.setGravity(Gravity.TOP,0,0)
            trueToast.show()
        }


    }
}