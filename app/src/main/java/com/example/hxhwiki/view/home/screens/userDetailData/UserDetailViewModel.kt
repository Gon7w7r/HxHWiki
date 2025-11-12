package com.example.hxhwiki.view.home.screens.userDetailData

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserDetailViewModel : ViewModel() {

    private val _selectedCharacter = MutableStateFlow<Character?>(null)
    val selectedCharacter: StateFlow<Character?> = _selectedCharacter

    fun loadCharacterByName(name: String) {
        _selectedCharacter.value = UserData.characters.find { it.name == name }
    }
}
