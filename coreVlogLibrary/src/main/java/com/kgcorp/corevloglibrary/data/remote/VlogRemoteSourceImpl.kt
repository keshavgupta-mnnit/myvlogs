package com.kgcorp.corevloglibrary.data.remote

import com.kgcorp.corevloglibrary.Util
import com.kgcorp.corevloglibrary.models.datamodels.VlogDetailsModel

class VlogRemoteSourceImpl: VlogRemoteSource {
    override fun getData(): List<VlogDetailsModel> {
        return Util.dummyData
    }

    override fun addData(data: VlogDetailsModel): Boolean {
        Util.dummyData.add(0, data)
        return true
    }
}