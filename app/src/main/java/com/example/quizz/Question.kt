package com.example.quizz

import java.io.Serializable

class Question(val topicName: String,
               val topicImage: Int,
               val questions: ArrayList<String>,
               val answers: ArrayList<Int>,
               val multiple_choices: ArrayList<ArrayList<String>>) : Serializable
{

}