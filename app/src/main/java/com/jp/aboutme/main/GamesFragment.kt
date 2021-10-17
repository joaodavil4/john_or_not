package com.jp.aboutme.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.jp.aboutme.R
import com.jp.aboutme.databinding.FragmentGamesBinding
import com.jp.aboutme.databinding.GtwgameFragmentBinding


class GamesFragment : Fragment() {
    private lateinit var binding: FragmentGamesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_games,
            container,
            false
        )

        binding.ivGtwGame.setOnClickListener { view?.findNavController()?.navigate(R.id.action_gamesFragment2_to_GTWGameFragment) }


        return binding.root
    }

}