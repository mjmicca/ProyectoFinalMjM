package com.curso.android.app.prectica.proyectofinalmjm.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.prectica.proyectofinalmjm.model.Comparacion

class MainViewModel: ViewModel() {
    val comparacion: LiveData<Comparacion> get() = _compara
    private var _compara = MutableLiveData<Comparacion>(Comparacion(""))

    fun compara(texto1: String, texto2: String) {
        if (texto1 == texto2) {
            _compara.value = Comparacion("Los textos SON IGUALES")
        } else {
            _compara.value = Comparacion("Los textos NO SON IGUALES")
        }
    }
}