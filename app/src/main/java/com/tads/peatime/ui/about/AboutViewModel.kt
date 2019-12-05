package com.tads.peatime.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        //value = "Sobre \n\n App desenvolvido nas disciplinas de MC e PDM. Alunos: Arthur Ribeiro e Pedro Ricardo"
    }
    val text: LiveData<String> = _text
}
