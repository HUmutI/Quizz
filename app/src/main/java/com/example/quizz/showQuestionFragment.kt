package com.example.quizz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.quizz.databinding.FragmentShowQuestionBinding


class showQuestionFragment : Fragment() {

    private var _binding: FragmentShowQuestionBinding? = null
    private val binding get() = _binding!!
    private var selectedChoices: MutableList<Int> = mutableListOf()
    private var true_answers: Int = 0
    private var count: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShowQuestionBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val selectedTopic = showQuestionFragmentArgs.fromBundle(it).topicRelatedQuestions
            var answerList = selectedTopic.answers
            if (selectedChoices.isEmpty()) {
                selectedChoices =
                    MutableList(selectedTopic.questions.size) { -1 }
            }

            displayQuestion(selectedTopic)

            binding.nextButton.setOnClickListener {
                println(selectedChoices)
                if (count < selectedTopic.questions.size - 1) {
                    count++
                    displayQuestion(selectedTopic)
                }
                else{
                    for (i in answerList.indices){
                        println(selectedChoices[i])
                        println(answerList[i])
                        if(answerList[i] == selectedChoices[i]+1){
                            true_answers +=1
                        }

                    }
                    println("selectedChoices:" + selectedChoices)
                    println("answerList: " + answerList)
                    val action = showQuestionFragmentDirections.actionShowQuestionFragmentToResultFragment("${true_answers}/${answerList.size}")
                    Navigation.findNavController(view).navigate(action)
                }
            }

            binding.backButton.setOnClickListener {
                println(selectedChoices)
                if (count > 0) {
                    count--
                    displayQuestion(selectedTopic)
                }
                else{

                    val action = showQuestionFragmentDirections.actionShowQuestionFragmentToQuizTopicFragment()
                    Navigation.findNavController(view).navigate(action)
                }
            }
            binding.firstChoiceRadio.setOnClickListener { handleRadioButtonClick(0) }
            binding.secondChoiceRadio.setOnClickListener { handleRadioButtonClick(1) }
            binding.thirdChoiceRadio.setOnClickListener { handleRadioButtonClick(2) }
        }

    }

    fun displayQuestion(topic: Question) {

        binding.radioGroup.clearCheck()

        binding.QnumberTextView.text = "Question ${count + 1}"
        binding.QstringTextView.text = topic.questions[count]
        binding.firstChoiceRadio.text = topic.multiple_choices[count][0]
        binding.secondChoiceRadio.text = topic.multiple_choices[count][1]
        binding.thirdChoiceRadio.text = topic.multiple_choices[count][2]

        when (selectedChoices[count]) {
            0 -> binding.firstChoiceRadio.isChecked = true
            1 -> binding.secondChoiceRadio.isChecked = true
            2 -> binding.thirdChoiceRadio.isChecked = true
        }
    }

    private fun handleRadioButtonClick(choiceIndex: Int) {
        val currentSelection = selectedChoices[count]

        if (currentSelection == choiceIndex) {
            selectedChoices[count] = -1
            binding.radioGroup.clearCheck()
        } else {
            selectedChoices[count] = choiceIndex

            when (choiceIndex) {
                0 -> binding.firstChoiceRadio.isChecked = true
                1 -> binding.secondChoiceRadio.isChecked = true
                2 -> binding.thirdChoiceRadio.isChecked = true
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
    }
}