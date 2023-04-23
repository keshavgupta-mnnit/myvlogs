package com.kgcorp.corevloglibrary.data

import com.kgcorp.corevloglibrary.models.datamodels.VlogDetailsModel

interface VlogRepository {
    fun getData(): List<VlogDetailsModel>
    fun addData(data: VlogDetailsModel): Boolean
}