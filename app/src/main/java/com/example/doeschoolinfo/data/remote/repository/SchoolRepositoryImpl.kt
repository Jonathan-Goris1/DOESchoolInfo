package com.example.doeschoolinfo.data.remote.repository

import com.example.doeschoolinfo.data.remote.services.SchoolService
import com.example.doeschoolinfo.data.remote.mapper.toDomainModel
import com.example.doeschoolinfo.data.util.Result
import com.example.doeschoolinfo.domain.model.SchoolInfoItem
import com.example.doeschoolinfo.domain.repository.SchoolRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject



class SchoolRepositoryImpl @Inject constructor(
    private val apiService: SchoolService,
    private val iODispatcher: CoroutineDispatcher
) : SchoolRepository {


    override suspend fun getSchoolInfo(): Result<List<SchoolInfoItem>> {
        return withContext(iODispatcher) {

            try {
                val result = apiService.getSchoolInfo().map { it.toDomainModel() }

                Result.Success(result)


            } catch (e: IOException) {
                e.printStackTrace()
                Result.Error(
                    message = e.message.toString()
                )

            } catch (e: HttpException) {
                e.printStackTrace()
                Result.Error(
                    message = e.message()
                )

            }
        }
    }
}
