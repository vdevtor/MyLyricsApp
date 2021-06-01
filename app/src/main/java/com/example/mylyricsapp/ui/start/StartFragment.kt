package com.example.mylyricsapp.ui.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mylyricsapp.R
import com.example.mylyricsapp.databinding.FragmentStartBinding
import com.example.mylyricsapp.extensions.animateImage
import com.example.mylyricsapp.extensions.blinking
import com.example.mylyricsapp.extensions.duplicateSize
import com.example.mylyricsapp.extensions.gone


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
        binding?.tvStartMessage?.blinking()

        binding?.ivStartIcon?.setOnClickListener {
            binding?.tvStartMessage?.gone()
            binding?.ivStartIcon?.duplicateSize()
            binding?.ivStartIcon?.animateImage(R.id.action_startFragment_to_homeFragment)

        }
    }
}
