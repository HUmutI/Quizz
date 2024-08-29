package com.example.quizz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.quizz.databinding.FragmentMainMenuBinding
import com.example.quizz.databinding.FragmentResultBinding



class resultFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.playAgainButton.setOnClickListener {
            val action = resultFragmentDirections.actionResultFragmentToQuizTopicFragment()
            Navigation.findNavController(view).navigate(action)
        }
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        val valueFromFirstFragment = viewModel.sharedString
        binding.nameTextView.text = "Hey ${valueFromFirstFragment}!"

        arguments?.let {
            val result = resultFragmentArgs.fromBundle(it).trueFalseResult
            binding.scoreTextView.text = result
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}