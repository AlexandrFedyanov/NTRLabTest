package com.test.afedyanov.ntrlabtest.presenter.presenterinterface

/**
 * Created by Alexandr on 25.07.2016.
 */
interface PresenterFactory <T> {

    fun createPresenter(): T
}