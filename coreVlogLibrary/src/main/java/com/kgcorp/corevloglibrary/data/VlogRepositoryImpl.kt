package com.kgcorp.corevloglibrary.data

import com.kgcorp.corevloglibrary.data.local.VlogLocalSource
import com.kgcorp.corevloglibrary.data.remote.VlogRemoteSource
import com.kgcorp.corevloglibrary.models.datamodels.VlogDetailsModel
import javax.inject.Inject

class VlogRepositoryImpl @Inject constructor(
    private val localSource: VlogLocalSource,
    private val remoteSource: VlogRemoteSource
) : VlogRepository {
    override fun getData(): List<VlogDetailsModel> {
        return remoteSource.getData()
    }

    override fun addData(data: VlogDetailsModel): Boolean {
        return remoteSource.addData(data)
    }
}