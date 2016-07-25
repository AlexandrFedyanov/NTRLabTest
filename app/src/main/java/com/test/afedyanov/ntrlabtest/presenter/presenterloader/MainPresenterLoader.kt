package com.test.afedyanov.ntrlabtest.presenter.presenterloader

import android.content.Context
import android.support.v4.content.Loader
import com.test.afedyanov.ntrlabtest.presenter.presenterinterface.IMainPresenter
import com.test.afedyanov.ntrlabtest.presenter.presenterinterface.PresenterFactory

/**
 * Created by Alexandr on 25.07.2016.
 */
class MainPresenterLoader(context: Context, private val presenterFactory: PresenterFactory<IMainPresenter>): Loader<IMainPresenter>(context) {
    var presenter : IMainPresenter? = null

    override fun onStartLoading() {
        if (presenter != null) {
            deliverResult(presenter)
            return
        }
        forceLoad()
    }

    override fun onForceLoad() {
        presenter = presenterFactory.createPresenter()
        deliverResult(presenter)
    }

    override fun onReset() {
        presenter?.onDestroyed()
        presenter = null
    }
}