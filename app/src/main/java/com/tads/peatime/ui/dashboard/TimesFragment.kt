package com.tads.peatime.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tads.peatime.R

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
        return root
    }
}