package com.example.geoquiz


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

private const val key_index = "index"
const val EXTRA_ANSWER_IS_TRUE_OR_FALSE = "CheatActivity"
const val EXTRA_QUESTION_TEXT = "question text"
const val EXTRA_IS_ENABLED = "is enabled"
private const val REQUEST_CODE_CHEAT = 0

class MainActivity : AppCompatActivity() {

    // buttons
    lateinit var falseButton:Button
    lateinit var trueButton:Button
   private lateinit var nextButton: ImageButton
   private lateinit var previousButton: ImageButton
    lateinit var questionTextView:TextView
   private lateinit var scoreTv:TextView
   private lateinit var cheatButton: Button

   private var score = 0

    val TAG = "MainActivity"

    private val quizViewModel by lazy {ViewModelProvider(this).get(QuizViewModel::class.java)}

    // function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentIndex = savedInstanceState?.getInt(key_index) ?: 0
        Log.d(TAG,"bundle val : $currentIndex")
        quizViewModel.currentIndex = currentIndex
        Log.d(TAG,"onCreate()")

        Log.d(TAG,"Hi I'm ViewModel from main activity $quizViewModel")

        falseButton = findViewById(R.id.false_button)
        trueButton = findViewById(R.id.true_button)
        nextButton = findViewById(R.id.next_question_button)
        previousButton = findViewById(R.id.previous_question_button)
        questionTextView = findViewById(R.id.question_Tv)
        scoreTv = findViewById(R.id.score_TV)
        cheatButton = findViewById(R.id.cheat_button)



        falseButton.setOnClickListener {
            checkAnswer(false)
            updateQuestion()
        }

        trueButton.setOnClickListener {
            checkAnswer(true)
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

        cheatButton.setOnClickListener {
            val intent = Intent(this , CheatActivity::class.java)
            intent.putExtra(EXTRA_ANSWER_IS_TRUE_OR_FALSE,quizViewModel.currentQuestionAnswer)
            intent.putExtra(EXTRA_QUESTION_TEXT,quizViewModel.currentQuestionText)
            startActivityForResult(intent, REQUEST_CODE_CHEAT)
            startActivity(intent)

        }


        updateQuestion()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG," a value been saved")
        outState.putInt(key_index,quizViewModel.currentIndex)
    }


    private fun updateQuestion() {
        val questionTextResid = quizViewModel.currentQuestionText
        questionTextView.setText(questionTextResid)
        falseButton.isEnabled = !quizViewModel.currentQuestionIsAnswered
        trueButton.isEnabled = !quizViewModel.currentQuestionIsAnswered

    }

    private fun checkAnswer(userAnswer:Boolean){
        val correctAnswer = quizViewModel.currentQuestionAnswer


        val toastMessage = when {
            quizViewModel.isCheater -> R.string.cheat_judgment
            userAnswer == correctAnswer -> R.string.correct_toast
            else -> R.string.incorrect_toast
        }

    }

    @SuppressLint("SetTextI18n")
    private fun updateScore () {
        score++

        scoreTv.text = "score: $score/6"
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode != Activity.RESULT_OK){
            return
        }

        if (requestCode == REQUEST_CODE_CHEAT){
            quizViewModel.isCheater = data?.getBooleanExtra(EXTRA_ANSWER_SHOWN,false) ?: false
        }

    }
}