package com.ebac.jokenpo

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.ebac.jokenpo.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    lateinit var engine: JokenpoEngine
    lateinit var bind: FragmentResultBinding
    lateinit var resultText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentResultBinding.inflate(inflater, container, false)
        engine = JokenpoEngine(resources.getStringArray(R.array.available_players_array))

        val currentPlay = arguments?.getString("currentPlay")
        resultText = bind.resultLabel

        currentPlay?.let {
            updateResultText(currentPlay)
        }

        setHasOptionsMenu(true)
        return bind.root

        //return inflater.inflate(R.layout.fragment_result, container, false)
    }

    private fun updateResultText(currentPlay: String){
       val resultGame = engine.calculateResult(currentPlay)

       resultText.text = when(resultGame){
           Result.WIN -> "Você ganhou"
           Result.LOSS -> "Você perdeu"
           else -> "Você empatou"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.second_screen_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController())
    }
}