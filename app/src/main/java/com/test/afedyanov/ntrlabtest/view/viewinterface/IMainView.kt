package com.test.ntrlabtest.simpletest.view.viewinterface

import com.test.afedyanov.ntrlabtest.model.entity.Data

/**
 * Created by Alexandr on 25.07.2016.
 */
interface IMainView {

    fun showLoading();

    fun showRefreshing();

    fun showError(message: String)

    fun showError(messageRes: Int)

    fun setData(data: Data?)
}