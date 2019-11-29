package com.tads.peatime.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Horários"
    }
    val text: LiveData<String> = _text
}