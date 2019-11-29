package com.tads.peatime.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tads.peatime.R
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class TimesFragment : Fragment() {

    private lateinit var timesViewModel: TimesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        timesViewModel =
            ViewModelProviders.of(this).get(TimesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        timesViewModel.text.observe(this, Observer {
            textView.text = it
        })

        var huors = mutableListOf("06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00")

        var adapter = ArrayAdapter<String>(
            root.context, // Context
            android.R.layout.simple_spinner_item, // Layout
            huors
        )

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        root.spinner.adapter = adapter

        return root
    }
}