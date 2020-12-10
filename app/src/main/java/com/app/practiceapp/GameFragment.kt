package com.app.practiceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.app.practiceapp.databinding.FragmentGameBinding


class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private var name = "Sajib"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)

        binding.startButton.setOnClickListener {
            when {
                binding.yesRadioButton.isChecked -> {
                    it.findNavController()
                        .navigate(
                            GameFragmentDirections.actionGameFragmentToGameWonFragment(name)
                        )
                }
                binding.radioGroup.checkedRadioButtonId <= 0 -> {
                    Toast.makeText(context, "Please answer the question", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    it.findNavController()
                        .navigate(GameFragmentDirections.actionGameFragmentToGameOverFragment())
                }
            }
        }
        return binding.root
    }
}