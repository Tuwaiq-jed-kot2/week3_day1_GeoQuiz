package com.example.geoquiz


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalStateException

// bundle 1 make const  val of b
private const val KEY_INDEX = "index"

class MainActivity : AppCompatActivity() {
    private lateinit var falseButton: Button
    private lateinit var trueButton: Button
    private lateinit var nextButton: Button
    private lateinit var previousButton: Button
    private lateinit var questionTextView: TextView

    val TAG = "Main_Activity"


    private val quizViewModel by lazy { ViewModelProvider(this).get(QuizViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext,"onCreate",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate called")
        Log.d(TAG, "Hi Iam viewModel from MainActivity ()")

        // Bundle 3
        val currentIndex =savedInstanceState?.getInt(KEY_INDEX,)?:0
        quizViewModel.currentIndex=currentIndex



        falseButton = findViewById(R.id.false_button)
        trueButton = findViewById(R.id.true_button)
        nextButton = findViewById(R.id.next_question)
        previousButton = findViewById(R.id.previous_question)
        questionTextView = findViewById(R.id.question_Tv)




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

        previousButton.setOnClickListener {
            quizViewModel.previousQuestion()
            updateQuestion()
        }


        questionTextView.setOnClickListener {
            quizViewModel.currentIndex
            updateQuestion()

        }


        updateQuestion()

    }
    // bundle 2
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_INDEX,quizViewModel.currentIndex)

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
        Toast.makeText(applicationContext,"onStart",Toast.LENGTH_SHORT).show();
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
        Toast.makeText(applicationContext,"onResume",Toast.LENGTH_SHORT).show();

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
        Toast.makeText(applicationContext,"onPause",Toast.LENGTH_SHORT).show();
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
        Toast.makeText(applicationContext,"onStop",Toast.LENGTH_SHORT).show();
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
        Toast.makeText(applicationContext,"onDestroy",Toast.LENGTH_SHORT).show();
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onrestart")
        Toast.makeText(applicationContext,"onrestart",Toast.LENGTH_SHORT).show();
    }

    private fun updateQuestion() {

        val questionTextResId = quizViewModel.currentQuestionText
        questionTextView.setText(questionTextResId)

    }

    private fun checkAnswer(userAnswer: Boolean) {
        Log.d(TAG,"Im from checkAnswer:", IllegalStateException())
        val correctAnswer = quizViewModel.currentQuestionAnswer


        if (userAnswer == correctAnswer) {
            Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT)
                .show()
            trueButton.isClickable = false
            falseButton.isClickable = true

        } else {
            Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT)
                .show()
            trueButton.isClickable = true
            falseButton.isClickable = true
        }
    }

}






