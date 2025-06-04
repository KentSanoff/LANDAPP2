package com.kentsanoff.landapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kentsanoff.landapp.data.db.LandField
import com.kentsanoff.landapp.data.repository.LandRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: LandRepository) : ViewModel() {

    private val _landField = MutableStateFlow<LandField?>(null)
    val landField: StateFlow<LandField?> = _landField

    fun loadField(id: Int) {
        viewModelScope.launch {
            _landField.value = repository.getFieldById(id)
        }
    }

    fun deleteField(id: Int) {
        viewModelScope.launch {
            _landField.value?.let {
                repository.deleteField(it)
            }
        }
    }
}
