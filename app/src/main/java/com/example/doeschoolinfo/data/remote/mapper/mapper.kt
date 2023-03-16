package com.example.doeschoolinfo.data.remote.mapper

import com.example.doeschoolinfo.data.remote.model.SchoolInfoResponseItem
import com.example.doeschoolinfo.domain.model.SchoolInfoItem

fun SchoolInfoResponseItem.toDomainModel(): SchoolInfoItem = SchoolInfoItem(
    school_name = school_name,
    borough = borough,
    phone_number = phone_number,
    primary_address_line_1 = primary_address_line_1,
    directions1 = directions1,
    website = website,
    school_email = school_email

)