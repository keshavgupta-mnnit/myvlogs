package com.kgcorp.corevloglibrary.di

import com.kgcorp.corevloglibrary.data.VlogRepository
import com.kgcorp.corevloglibrary.data.VlogRepositoryImpl
import com.kgcorp.corevloglibrary.data.local.VlogLocalSource
import com.kgcorp.corevloglibrary.data.local.VlogLocalSourceImpl
import com.kgcorp.corevloglibrary.data.remote.VlogRemoteSource
import com.kgcorp.corevloglibrary.data.remote.VlogRemoteSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object MainModule {

    @Provides
    fun getRemoteSource(): VlogRemoteSource = VlogRemoteSourceImpl()

    @Provides
    fun getLocalSource(): VlogLocalSource = VlogLocalSourceImpl()

    @Provides
    fun getRepository(
        localSource: VlogLocalSource,
        remoteSource: VlogRemoteSource
    ): VlogRepository = VlogRepositoryImpl(localSource, remoteSource)
}