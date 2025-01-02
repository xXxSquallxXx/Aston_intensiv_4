package com.example.fragments.task1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragments.R
import com.example.fragments.databinding.FragmentCBinding

class FragmentC : Fragment() {
    private var _binding: FragmentCBinding? = null
    private val binding get() = _binding!!

    private val args: FragmentCArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textMessage.text = args.message

        binding.buttonToD.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentC_to_fragmentD)
        }

        binding.buttonToAReset.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentC_to_fragmentA)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
