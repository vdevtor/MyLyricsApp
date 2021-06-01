package com.example.mylyricsapp.ui.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mylyricsapp.R
import com.example.mylyricsapp.databinding.FragmentStartBinding
import com.example.mylyricsapp.extensions.animeImage
import com.example.mylyricsapp.extensions.navigateWithAnimations

class StartFragment : Fragment() {
    private var binding: FragmentStartBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animateStart()

    }

    private fun animateStart() {
        binding?.ivStartIcon?.setOnClickListener {
            binding?.ivStartIcon?.animeImage().also {
                findNavController().navigateWithAnimations(R.id.action_startFragment_to_homeFragment)
            }
        }
    }
}
