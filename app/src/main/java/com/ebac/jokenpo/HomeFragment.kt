package com.ebac.jokenpo

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebac.jokenpo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LifeCycle", "onCreateView")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        //return super.onCreateView(inflater, container, savedInstanceState)

        Log.d("LifeCycle", "onCreateView")

        binding.startButton.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToGameNav()
            findNavController().navigate(action)
        }
        return  binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("LifeCycle", "onSaveInstance")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("LifeCycle", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()

        Log.d("LifeCycle", "onDetach")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Log.d("LifeCycle", "onAttach")
    }
}