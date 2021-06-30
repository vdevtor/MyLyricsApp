package com.example.mylyricsapp.ui.login

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mylyricsapp.R
import com.example.mylyricsapp.databinding.FragmentLoginBinding
import com.example.mylyricsapp.extensions.*


class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by activityViewModels()
    private var binding : FragmentLoginBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
      binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        viewButtonsListeners()
        viewTextChangeListeners()
        setupAnimations()

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            cancelAuthentication()
        }
    }

    private fun viewTextChangeListeners() {

    }


    private fun viewButtonsListeners() {
        binding?.ivIconMusicInside?.setOnClickListener {
            viewModel.auth()
            binding?.ivIconMusicInside?.slideUp(R.id.action_loginFragment_to_homeFragment)
        }
    }

    private fun setupAnimations(){

        binding?.ivTopFirstStar?.moveBackFoward()
        binding?.ivTopMusicItem?.moveDownUp()
        binding?.ivLastStar?.coinRotate()
        binding?.tvPressLoginBtn?.blinking()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        cancelAuthentication()
        return true
    }

    private fun cancelAuthentication() {

        viewModel.refuseAuthentication()
        findNavController().navigateWithAnimations(R.id.startFragment)
    }
}