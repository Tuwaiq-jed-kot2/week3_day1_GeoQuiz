package com.example.geoquiz

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

const val EXTRA_ANSWER_SHOWN = "wtf cheater!!!"

const val MY_RESULT_CODE = 999988

class CheatActivity : AppCompatActivity() {

    private lateinit var answerTv:TextView
    private lateinit var showAnswerBTN:Button
    private lateinit var QTV:TextView

    var thQuestion = 0
    var answerIsTrueOrFalse = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        answerTv = findViewById(R.id.answer_tv)
        showAnswerBTN = findViewById(R.id.show_answer_button)
        QTV  =findViewById(R.id.QTV)


        thQuestion = intent.getIntExtra(EXTRA_QUSETION_TEXT , 0)
        QTV.setText(thQuestion)

        answerIsTrueOrFalse = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE_OR_FALSE,false)

        showAnswerBTN.setOnClickListener {

            answerTv.setText(answerIsTrueOrFalse.toString())
            setAnswerShownResult()

        }
    }

    fun setAnswerShownResult(){
        val intent  = Intent()
           intent.putExtra(EXTRA_ANSWER_SHOWN,true)


        setResult(Activity.RESULT_OK,intent)

    }
}