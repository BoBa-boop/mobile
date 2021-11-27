package com.example.coffee_break.ui.home

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffee_break.*
import com.example.coffee_break.databinding.FragmentHomeBinding
import recadapters.skid_coffee

class HomeFragment : Fragment() {
    lateinit var sharedPreferences: SharedPreferences
    private var _binding: FragmentHomeBinding? = null
    lateinit var rec_main1:RecyclerView
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            rec_main1 = view.findViewById(R.id.rec_main1)

                rec_main1.layoutManager = GridLayoutManager(requireContext(),2)
                rec_main1.adapter = skid_coffee(requireContext(),Skid_coffee().list)
            val spinner:Spinner = view.findViewById(R.id.spinner_drink) as Spinner


            if (spinner != null) {
                val adapter = ArrayAdapter( this, android.R.layout.simple_spinner_item, )
                spinner.adapter = adapter

                spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                        selectedText = muscleGroups[position]
                    }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}