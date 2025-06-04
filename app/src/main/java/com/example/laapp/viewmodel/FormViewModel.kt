package com.kentsanoff.landapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kentsanoff.landapp.data.db.LandField
import com.kentsanoff.landapp.data.repository.LandRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FormViewModel(private val repository: LandRepository) : ViewModel() {

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _cropType = MutableStateFlow("")
    val cropType: StateFlow<String> = _cropType

    private val _editDate = MutableStateFlow("")
    val editDate: StateFlow<String> = _editDate

    private val _notes = MutableStateFlow("")
    val notes: StateFlow<String> = _notes

    fun updateName(value: String) {
        _name.value = value
    }

    fun updateCropType(value: String) {
        _cropType.value = value
    }

    fun updateEditDate(value: String) {
        _editDate.value = value
    }

    fun updateNotes(value: String) {
        _notes.value = value
    }

    fun saveField(onSaved: () -> Unit) {
        val field = LandField(
            name = _name.value.trim(),
            cropType = _cropType.value.trim(),
            editDate = _editDate.value.trim(),
            notes = _notes.value.trim()
        )

        viewModelScope.launch {
            repository.insertField(field)
            onSaved()
        }
    }
}
