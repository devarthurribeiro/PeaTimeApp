package com.tads.peatime.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tads.peatime.R
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.net.URL

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })

        root.btnFeed.setOnClickListener {
            sendGet("open", root.context)
        }

        return root
    }

    fun sendGet(path:String, ctx: Context) {
        val url = URL("http://10.77.15.64:3000/$path")
        Toast.makeText(ctx, "Comida", Toast.LENGTH_LONG).show()
        val result = url.readText()
        println(result)
    }
}