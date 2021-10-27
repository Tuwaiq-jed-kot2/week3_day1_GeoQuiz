package com.example.geoquiz

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

const val EXTRA_ANSWER_SHOWN = "cheater alert"

class CheatActivity : AppCompatActivity() {

    private lateinit var cheatAnswer :TextView
    private lateinit var showAnswerButton:Button


    var answerIstrueOrFalse = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        cheatAnswer = findViewById(R.id.cheat_answer)
        showAnswerButton = findViewById(R.id.show_answer_button)


        answerIstrueOrFalse = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE_OR_FALSE,false)


        showAnswerButton.setOnClickListener {
            cheatAnswer.text = answerIstrueOrFalse.toString()
            setAnswerShownResult()

        }
    }
    fun setAnswerShownResult(){
        val data = Intent().apply {
            putExtra(EXTRA_ANSWER_SHOWN,true)
        }

        setResult(Activity.RESULT_OK,data)
    }

}