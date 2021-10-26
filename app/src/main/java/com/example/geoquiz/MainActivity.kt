package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalStateException

private const val TAG = "MainActivity"

//save bundle key
private const val KEY_INDEX = "index"
class MainActivity : AppCompatActivity() {
    //Widgets "Views"
    private lateinit var questionTextView: TextView
    private lateinit var scoreTextView: TextView
    private lateinit var falseButton: Button
    private lateinit var trueButton: Button
    private lateinit var nextButton: ImageButton
    private lateinit var previousButton: ImageButton

    //Attributes
    private val quizViewModel by lazy {
        ViewModelProvider(this).get(QuizViewModel::class.java)} //"QuizViewModel::class.java" to point to it

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setting this view "MainActivity.kt" with the "activity_main.xml" design
        setContentView(R.layout.activity_main)

        //getting the value in the bundle
        val currentIndex = savedInstanceState?.getInt(KEY_INDEX) ?: 0
        Log.d(TAG, "bundle value : $currentIndex")

        quizViewModel.currentIndex = currentIndex

        //linking the textView and buttons in "activity_main.xml" with this class "MainActivity.kt" using their 'id'
        questionTextView = findViewById(R.id.questionTextView)
        scoreTextView = findViewById(R.id.scoreTextView)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextQuestion )
        previousButton = findViewById(R.id.previousQuestion)

        scoreTextView.setText("${quizViewModel.score}/10")

        trueButton.setOnClickListener {
            checkAnswer(true)

        }
        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        questionTextView.setOnClickListener {
            quizViewModel.nextQuestion()
            updateQuestion()
        }
        nextButton.setOnClickListener {
            quizViewModel.nextQuestion()
            updateQuestion()
        }
        previousButton.setOnClickListener {
            quizViewModel.previousQuestion()
            updateQuestion()
        }
        updateQuestion()
    }

    //Overrides
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "a value has been saved")
        outState.putInt(KEY_INDEX, quizViewModel.currentIndex)
    }

    //Functions
    private fun updateQuestion() {
        val questionTextRedId = quizViewModel.currentQuestionText
        questionTextView.setText(questionTextRedId)
        isQuestionAnswered()
    }

    private fun isQuestionAnswered(){
        trueButton.isEnabled = !quizViewModel.isCurrentQuestionAnswered
        falseButton.isEnabled = !quizViewModel.isCurrentQuestionAnswered
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = quizViewModel.currentQuestionAnswer
        if (correctAnswer == userAnswer) {
            Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show()
            quizViewModel.isCurrentQuestionAnswered = true
            updateScore()
            updateQuestion()
        } else {
            Toast.makeText(this, R.string.Incorrect_toast, Toast.LENGTH_SHORT).show()
            quizViewModel.isCurrentQuestionAnswered = true
            updateQuestion()
        }
    }

    private fun updateScore(){
        quizViewModel.score += 1
        scoreTextView.setText("${quizViewModel.score}/10")
    }
}
