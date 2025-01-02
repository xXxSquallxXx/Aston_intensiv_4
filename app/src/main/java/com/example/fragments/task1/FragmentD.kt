package com.example.fragments.task1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragments.R
import com.example.fragments.databinding.FragmentDBinding

class FragmentD : Fragment() {
    private var _binding: FragmentDBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonToBReset.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentD_to_fragmentB)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
