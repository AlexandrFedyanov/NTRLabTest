package com.test.afedyanov.ntrlabtest.model.api

import com.test.afedyanov.ntrlabtest.model.entity.Data
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Alexandr on 25.07.2016.
 */
interface ApiService {

    @GET(ApiConstants.GET_DATA_FUN)
    fun getData() : Call<Data>
}