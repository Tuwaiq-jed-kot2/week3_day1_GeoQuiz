package com.example.geoquiz

import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {

    private var questionsBank = listOf(
        Questions(R.string.first_question,true,false),
        Questions(R.string.second_question,false,false),
        Questions(R.string.third_question,false,false),
        Questions(R.string.fourth_question,true,false),
        Questions(R.string.fifth_question,false,false),
        Questions(R.string.sixth_question,true,false)
    )

    var currentIndex = 0

    var isCheater = false

    val currentQuestionText : Int
                get () = questionsBank[currentIndex].textResId

    val currentQuestionAnswer : Boolean
                get() = questionsBank[currentIndex].answer

    var currentQuestionIsAnswered : Boolean
                get() = questionsBank[currentIndex].isAnswered
                set(value) {
                    questionsBank[currentIndex].isAnswered = value
                }




                    fun nextQuestion (){
                        if (currentIndex in 0..questionsBank.size -2 ){
                            currentIndex = (currentIndex + 1)


                        }
                    }
                    fun previousQuestion () {
                        if (currentIndex > 0){
                            currentIndex = (currentIndex - 1)

                        }
                    }
}
