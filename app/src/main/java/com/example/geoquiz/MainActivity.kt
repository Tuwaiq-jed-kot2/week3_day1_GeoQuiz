package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import android.view.Gravity
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity as startActivity1
import androidx.core.content.ContextCompat.startActivity





class MainActivity : AppCompatActivity() {

   private lateinit var falseButton:Button
   private lateinit var trueButton:Button
   // if i used lateinit here the app will crash
   // private lateinit var buttonForGo:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        falseButton = findViewById(R.id.false_button)
        trueButton = findViewById(R.id.true_button)
      //  button2 = findViewById(R.id.button2)

        falseButton.setOnClickListener {
            Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_LONG).show()
        }

        trueButton.setOnClickListener {
            Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_LONG).show()
        }
        trueButton.setOnClickListener {
            val toast :Toast=  Toast.makeText(this,R.string.r_toast,Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP,0,350)
            toast.show()
        }
       val buttonForGo=findViewById<Button>(R.id.buttonForGo)
        buttonForGo.setOnClickListener{
           val x = Intent(this, MainActivity2::class.java)
           startActivity(intent)
       }



    }

    }

