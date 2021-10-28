package com.example.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel


private   const val TAG = "Main_Activity"

class QuizViewModel: ViewModel() {

    private val questionBank = listOf(
        Question(R.string.first_question,true),
        Question(R.string.second_question,false),
        Question(R.string.third_question,false)
    )

    var currentIndex = 0

    var isCheater = false

    val currentQuestionText  : Int
                    get() = questionBank[currentIndex].textResId

    val currentQuestionAnswer : Boolean
                    get() = questionBank[currentIndex].answer

    fun nextQuestion(){
        currentIndex = (currentIndex + 1)
    }



}