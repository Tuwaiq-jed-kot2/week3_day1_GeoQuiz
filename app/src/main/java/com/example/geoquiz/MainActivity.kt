package com.example.geoquiz

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider


private const val KEY_INDEX = "index"
const val EXTRA_ANSWER_IS_TRUE_OR_FALSE = "answerIsTrue"
const val EXTRA_QUSETION_TEXT = "your QUSTRIO"

private const val REQUEST_CODE_CHEAT = 999

class MainActivity : AppCompatActivity() {


   private lateinit var falseButton:Button
   private lateinit var trueButton:Button
   private lateinit var nextButton:Button
   private lateinit var questionTextView:TextView
   private lateinit var cheatButton: Button





    private val TAG = "Main_Activity"

    private val quizViewModel   by lazy {    ViewModelProvider(this).get(QuizViewModel::class.java)}





    private val  getCheateingResultLncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

            if (it.resultCode == Activity.RESULT_OK){
                quizViewModel.isCheater = it.data?.getBooleanExtra(EXTRA_ANSWER_SHOWN,false) ?:false

            }

        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val currentIndex =  savedInstanceState?.getInt(KEY_INDEX) ?: 0
        Log.d(TAG , "bundle val : $currentIndex ")
        quizViewModel.currentIndex = currentIndex


        falseButton = findViewById(R.id.false_button)
        trueButton = findViewById(R.id.true_button)
        nextButton = findViewById(R.id.next_question)
        questionTextView = findViewById(R.id.qusetion_Tv)
        cheatButton = findViewById(R.id.cheat_btn)


        cheatButton.setOnClickListener {

            val intent = Intent(this, CheatActivity::class.java)
            intent.putExtra(EXTRA_ANSWER_IS_TRUE_OR_FALSE,quizViewModel.currentQuestionAnswer)
            intent.putExtra(EXTRA_QUSETION_TEXT,quizViewModel.currentQuestionText)

            getCheateingResultLncher.launch(intent)



           // startActivityForResult(intent, REQUEST_CODE_CHEAT)

        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        nextButton.setOnClickListener {
            quizViewModel.nextQuestion()
            updateQuestion()
        }

        updateQuestion()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "a value been saved")
        outState.putInt(KEY_INDEX,quizViewModel.currentIndex)
    }


    private fun updateQuestion(){
       val questionTextResId = quizViewModel.currentQuestionText
       questionTextView.setText(questionTextResId)
   }

  private fun checkAnswer(userAnswer:Boolean){
      val correctAnswer = quizViewModel.currentQuestionAnswer


      val toastMassage = when{
          quizViewModel.isCheater -> R.string.judgment_toast
          userAnswer == correctAnswer -> R.string.correct_toast
          else -> R.string.incorrect_toast
      }

      Toast.makeText(this,toastMassage,Toast.LENGTH_LONG).show()

  }


}