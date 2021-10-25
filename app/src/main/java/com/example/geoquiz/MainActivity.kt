package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // buttons
   private lateinit var falseButton:Button
   private lateinit var trueButton:Button
   private lateinit var nextButton: ImageButton
   private lateinit var previousButton: ImageButton
   private lateinit var questionTextView:TextView

   // question bank
   private val questionsBank = listOf(
       Questions(R.string.first_question,true),
       Questions(R.string.second_question,false),
       Questions(R.string.third_question,false),
       Questions(R.string.fourth_question,true),
       Questions(R.string.fifth_question,false),
       Questions(R.string.sixth_question,true)
   )

    private var currentIndex = 0

    val TAG = "MainActivity"

    // function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG,"onCreate()")

        falseButton = findViewById(R.id.false_button)
        trueButton = findViewById(R.id.true_button)
        nextButton = findViewById(R.id.next_question_button)
        previousButton = findViewById(R.id.previous_question_button)
        questionTextView = findViewById(R.id.question_Tv)


        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        nextButton.setOnClickListener {
            try{
                currentIndex = (currentIndex + 1)
                updateQuestion()
            }catch (e:ArrayIndexOutOfBoundsException){
                val toast = Toast.makeText(this,R.string.maximum_index,Toast.LENGTH_LONG)
                toast.setGravity(Gravity.TOP,0,0)
                toast.show()
                currentIndex--
            }

        }

        previousButton.setOnClickListener {
            try {

                currentIndex = (currentIndex - 1)
                updateQuestion()
            } catch (e: ArrayIndexOutOfBoundsException) {
                val toast = Toast.makeText(this, R.string.negative_index, Toast.LENGTH_LONG)
                toast.setGravity(Gravity.TOP, 0, 0)
                toast.show()
                currentIndex++
            }

        }
            questionTextView.setOnClickListener{
                try{
                    currentIndex = (currentIndex + 1)
                    updateQuestion()
                }catch (e:ArrayIndexOutOfBoundsException){
                    val toast = Toast.makeText(this,R.string.maximum_index,Toast.LENGTH_LONG)
                    toast.setGravity(Gravity.TOP,0,0)
                    toast.show()
                    currentIndex--
                }
            }


        updateQuestion()

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy()")
    }

    private fun updateQuestion() {
        val questionTextResid = questionsBank[currentIndex].textResId
        questionTextView.setText(questionTextResid)
    }

    private fun checkAnswer(userAnswer:Boolean){
        val correctAnswer = questionsBank[currentIndex].answer


        if (userAnswer == correctAnswer){
            val toast = Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP,0,0)
            toast.show()
        }else {
            val toast = Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP,0,0)
            toast.show()

        }

    }
}