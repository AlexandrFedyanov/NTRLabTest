package com.test.afedyanov.ntrlabtest.presenter

import com.test.afedyanov.ntrlabtest.model.api.ApiCreator
import com.test.afedyanov.ntrlabtest.model.api.ApiService

/**
 * Created by Alexandr on 25.07.2016.
 */
open class BasePresenter<T> {

    var view : T? = null
    lateinit var apiService : ApiService

    constructor() {
        apiService = ApiCreator.buildApi()
    }

    fun attachView(view: T) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }

    fun onDestroyed() {

    }
}