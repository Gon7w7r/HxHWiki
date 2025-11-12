package com.example.hxhwiki.view.home.screens.nenDetailData


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hxhwiki.data.NenData
import com.example.hxhwiki.data.NenType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NenViewModel : ViewModel() {

    private val _selectedNen = MutableStateFlow<NenType?>(null)
    val selectedNen: StateFlow<NenType?> = _selectedNen

    fun loadNenByTitle(title: String) {
        viewModelScope.launch {
            val nen = NenData.nenTypes.find { it.title == title }
            _selectedNen.value = nen
        }
    }
}
