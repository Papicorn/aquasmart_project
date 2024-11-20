package com.example.aquasmart10.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aquasmart10.api.RetrofitInstance
import com.example.aquasmart10.model.modelKolam
import kotlinx.coroutines.launch

class KolamViewModel : ViewModel() {
    private val _kolam = MutableLiveData<List<modelKolam>>()
    val kolam: LiveData<List<modelKolam>> get() = _kolam

    fun fetchKolam() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getKolam()
                _kolam.value = response
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}