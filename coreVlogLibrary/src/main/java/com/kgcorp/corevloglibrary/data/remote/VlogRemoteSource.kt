package com.kgcorp.corevloglibrary.data.remote

import com.kgcorp.corevloglibrary.models.datamodels.VlogDetailsModel

interface VlogRemoteSource {
    fun getData(): List<VlogDetailsModel>
    fun addData(data: VlogDetailsModel): Boolean
}