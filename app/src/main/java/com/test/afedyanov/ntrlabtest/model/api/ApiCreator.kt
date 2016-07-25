package com.test.afedyanov.ntrlabtest.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Alexandr on 25.07.2016.
 */
class ApiCreator {

    companion object {
        fun buildApi(): ApiService {
            val retrofit = Retrofit.Builder()
                    .baseUrl(ApiConstants.API_PATH)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}