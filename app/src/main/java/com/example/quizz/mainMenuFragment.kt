package com.example.quizz

import android.os.Bundle
import android.text.Layout.Directions
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizz.databinding.FragmentMainMenuBinding
import androidx.navigation.Navigation
import androidx.lifecycle.ViewModelProvider

class mainMenuFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel
    private var _binding: FragmentMainMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainMenuBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startButtonnn.setOnClickListener {
            clicked_start_button(it)
        }
    }

    fun clicked_start_button(view: View) {
        val action = mainMenuFragmentDirections.actionMainMenuFragmentToQuizTopicFragment()
        Navigation.findNavController(view).navigate(action)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        viewModel.sharedString = binding.editTextName.text.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }



}