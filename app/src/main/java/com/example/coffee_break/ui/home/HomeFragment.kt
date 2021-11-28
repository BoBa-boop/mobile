package com.example.coffee_break.ui.home

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffee_break.*
import com.example.coffee_break.databinding.FragmentHomeBinding
import recadapters.skid_coffee
import recadapters.soda_ad

class HomeFragment : Fragment() {
    lateinit var sharedPreferences: SharedPreferences

    private var _binding: FragmentHomeBinding? = null
    lateinit var rec_main1: RecyclerView

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
        rec_main1.layoutManager = GridLayoutManager(requireContext(), 2)

       //spinner
        val spinner: Spinner = view.findViewById(R.id.spinner_drink) as Spinner
        val drinks = arrayOf("Кофе","Газированная вода","Вода","Чай")
        val adapter = ArrayAdapter(requireContext(),R.layout.color_spinner,drinks)
        adapter.setDropDownViewResource(R.layout.back_dropdown)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    if(p2 == 0)
                    {
                        rec_main1.adapter = skid_coffee(requireContext(), Skid_coffee().list)
                    }
                    if (p2== 1)
                    {
                        rec_main1.adapter = soda_ad(requireContext(), soda_drinks().list)
                    }
                    if (p2== 2)
                    {
                        rec_main1.adapter = soda_ad(requireContext(), water_list().list)
                    }
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {


                }

            }
    }
    }
