package com.example.doeschoolinfo.di

import com.example.doeschoolinfo.data.remote.repository.SchoolRepositoryImpl
import com.example.doeschoolinfo.data.remote.services.SchoolService
import com.example.doeschoolinfo.domain.repository.SchoolRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun bindSchoolRepository(
        apiService: SchoolService,
        @Dispatcher(NiaDispatchers.IO) ioDispatcher: CoroutineDispatcher,
    ): SchoolRepository {
        return SchoolRepositoryImpl(apiService, ioDispatcher)
    }
}
