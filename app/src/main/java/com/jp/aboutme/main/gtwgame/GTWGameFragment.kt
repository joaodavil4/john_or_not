package com.jp.aboutme.main.gtwgame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil.*
import androidx.fragment.app.Fragment
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

        binding.correctButton.setOnClickListener { onCorrect() }
        binding.skipButton.setOnClickListener { onSkip() }
        binding.endGameButton.setOnClickListener { onEndGame() }
        updateScoreText()
        updateWordText()
        return binding.root
    }

    /** Methods for buttons presses **/

    private fun onSkip() {
        viewModel.onSkip()
        updateWordText()
        updateScoreText()
    }
    private fun onCorrect() {
        viewModel.onCorrect()
        updateScoreText()
        updateWordText()
    }

    private fun onEndGame() {
        gameFinished()
    }

    /** Methods for updating the UI **/

    private fun updateWordText() {
        binding.wordText.text = viewModel.word

    }

    private fun updateScoreText() {
        binding.scoreText.text = viewModel.score.toString()
    }

    /**
     * Called when the game is finished
     */
    private fun gameFinished() {
        Toast.makeText(activity, "Game has just finished", Toast.LENGTH_SHORT).show()
        val action = GTWGameFragmentDirections.actionGtwgameToScore()
        action.score = viewModel.score
        NavHostFragment.findNavController(this).navigate(action)
    }
}