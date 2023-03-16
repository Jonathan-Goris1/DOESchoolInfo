package com.example.doeschoolinfo.domain.repository

import com.example.doeschoolinfo.data.remote.model.SchoolInfoResponseItem
import com.example.doeschoolinfo.data.util.Result
import com.example.doeschoolinfo.domain.model.SchoolInfoItem

interface SchoolRepository {

    suspend fun getSchoolInfo(): Result<List<SchoolInfoItem>>
}