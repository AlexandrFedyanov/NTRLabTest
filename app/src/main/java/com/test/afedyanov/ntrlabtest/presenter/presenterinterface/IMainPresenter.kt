package com.test.afedyanov.ntrlabtest.presenter.presenterinterface

import com.test.ntrlabtest.simpletest.view.viewinterface.IMainView

/**
 * Created by Alexandr on 25.07.2016.
 */
interface IMainPresenter {

    fun attachView(view: IMainView)

    fun detachView()

    fun onDestroyed()

    fun getData()

    fun refreshData()
}