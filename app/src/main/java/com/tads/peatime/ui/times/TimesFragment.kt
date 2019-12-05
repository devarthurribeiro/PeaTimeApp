package com.tads.peatime.ui.times

import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.tads.peatime.R
import kotlinx.android.synthetic.main.fragment_times.view.*
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

class TimesFragment : Fragment() {

    private lateinit var timesViewModel: TimesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        timesViewModel =
            ViewModelProviders.of(this).get(TimesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_times, container, false)

        var huors = mutableListOf("06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00")

        var adapter = ArrayAdapter<String>(
            root.context, // Context
            android.R.layout.simple_spinner_item, // Layout
            huors
        )

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        root.spinner.adapter = adapter

        root.btnSaveTime.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                //textView.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(root.context, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
            //sendGet("open", root.context)
        }

        root.fab.setOnClickListener { view ->
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                //textView.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(root.context, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }

        return root
    }

    fun sendGet(path:String, ctx:Context) {
        val url = URL("http://10.77.15.64:3000/$path")
        Toast.makeText(ctx, "ok", Toast.LENGTH_LONG).show()
        val result = url.readText()
        println(result)
    }
}