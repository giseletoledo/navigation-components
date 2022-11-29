package com.ebac.jokenpo

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.ebac.jokenpo.databinding.FragmentPlayerBinding

class PlayerFragment : Fragment() {

    lateinit var root: View
    lateinit var selectPlay: Spinner
    private lateinit var onItemSelectedListener: OnItemSelectedListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        onItemSelectedListener = context as OnItemSelectedListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPlayerBinding.inflate(inflater, container, false)
        root = binding.root
        selectPlay = binding.spinner

        setupSelectPlaySpinner()
        setHasOptionsMenu(true)
        return root
    }

    private fun setupSelectPlaySpinner(){
        val adapter =
            ArrayAdapter.createFromResource(
                requireContext(),
                R.array.available_players_array,
                android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        selectPlay.adapter = adapter
        //Quem escuta as alterações(eventos)
        //selectPlay.onItemSelectedListener = this -> quando implementa o onItemSelectedListener

        selectPlay.onItemSelectedListener = onItemSelectedListener
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.second_screen_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController())
    }

   /* override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val plays = resources.getStringArray(R.array.available_players_array)
        val selectedPlay = plays[position]

        Toast.makeText(requireContext(), "Jogada selecionada: $selectedPlay", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }*/
}