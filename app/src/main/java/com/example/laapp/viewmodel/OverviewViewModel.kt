package com.kentsanoff.landapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kentsanoff.landapp.data.db.LandField
import com.kentsanoff.landapp.data.repository.LandRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class OverviewViewModel(repository: LandRepository) : ViewModel() {

    val fields: StateFlow<List<LandField>> =
        repository.getAllFields()
            .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
}
