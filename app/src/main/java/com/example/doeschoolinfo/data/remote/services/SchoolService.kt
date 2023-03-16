package com.example.doeschoolinfo.data.remote.services

import com.example.doeschoolinfo.data.remote.model.SchoolInfoResponseItem
import retrofit2.http.GET

interface SchoolService {

    @GET("s3k6-pzi2.json")
    suspend fun getSchoolInfo(): List<SchoolInfoResponseItem>
}