package com.jp.aboutme.main.gtwgame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.jp.aboutme.R
import com.jp.aboutme.databinding.GtwgameFragmentBinding
import timber.log.Timber

class GTWGameFragment : Fragment() {

    private lateinit var binding: GtwgameFragmentBinding

    private lateinit var viewModel: GTWGameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        // Inflate view and obtain an instance of the binding class
        binding = inflate(
            inflater,
            R.layout.gtwgame_fragment,
            container,
            false
        )


        Timber.i("Called ViewModelProvider.get")

        // Get the viewModel
        viewModel = ViewModelProvider(this).get(GTWGameViewModel::class.java)

        // Set the viewmodel for databinding - this allows the bound layout access to all the data in the ViewModel
        binding.gameViewModel = viewModel

        // Specify the fragment view as the lifecycle owner of the binding.
        // This is used so that the binding can observe LiveData updates
        binding.lifecycleOwner = viewLifecycleOwner

        // Observer for the Game finished event
        viewModel.eventGameFinish.observe(viewLifecycleOwner, { hasFinished ->
            if (hasFinished) gameFinished()
        })

        return binding.root
    }

    /**
     * Called when the game is finished
     */
    private fun gameFinished() {
        Toast.makeText(activity, "Game has just finished", Toast.LENGTH_SHORT).show()
        val action = GTWGameFragmentDirections.actionGtwgameToScore()
        action.score = viewModel.score.value?:0
        NavHostFragment.findNavController(this).navigate(action)
        viewModel.onGameFinishComplete()
    }
}