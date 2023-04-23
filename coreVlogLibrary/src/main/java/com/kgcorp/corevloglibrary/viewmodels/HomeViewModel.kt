package com.kgcorp.corevloglibrary.viewmodels

import androidx.lifecycle.ViewModel
import com.kgcorp.corevloglibrary.data.VlogRepository
import com.kgcorp.corevloglibrary.models.datamodels.VlogDetailsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: VlogRepository) : ViewModel() {
    fun getData(): List<VlogDetailsModel> {
        return repository.getData()
    }

}