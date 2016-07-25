package com.test.afedyanov.ntrlabtest.view.activity

import android.os.Bundle
import android.support.v4.app.LoaderManager
import com.test.afedyanov.ntrlabtest.R
import com.test.afedyanov.ntrlabtest.model.entity.Data
import com.test.afedyanov.ntrlabtest.presenter.MainPresenterImpl
import com.test.afedyanov.ntrlabtest.presenter.presenterinterface.IMainPresenter
import com.test.afedyanov.ntrlabtest.presenter.presenterinterface.PresenterFactory
import com.test.afedyanov.ntrlabtest.presenter.presenterloader.MainPresenterLoader
import com.test.afedyanov.ntrlabtest.view.visualstates.*
import com.test.ntrlabtest.simpletest.view.viewinterface.IMainView
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.view_data_item.*

/**
 * Created by Alexandr on 25.07.2016.
 */
class MainActivity : BaseToolbarActivity(), IMainView, LoaderManager.LoaderCallbacks<IMainPresenter> {

    var presenter: IMainPresenter? = null

    val PRESENTER_LOADER_ID = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = getString(R.string.main_activity_name)
        supportLoaderManager.initLoader(PRESENTER_LOADER_ID, null, this)
    }

    override fun onStart() {
        super.onStart()
        presenter?.attachView(this)
    }

    override fun onResume() {
        super.onResume()
        presenter?.getData()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
    }

    override fun setupLayout() {
        pullToRefresh.setOnRefreshListener {
            presenter?.refreshData()
        }
    }

    override fun showLoading() {
        setLoadingState()
    }

    override fun showRefreshing() {
        setRefreshingState()
    }


    override fun showError(message: String) {
        setErrorState(message)
    }

    override fun showError(messageRes: Int) {
        showError(getString(messageRes))
    }

    override fun setData(data: Data?) {
        if (data != null) {
            idTextView.text = getString(R.string.formated_id, data.id)
            nameTextView.text = getString(R.string.formated_name, data.name)
            phoneTextView.text = getString(R.string.formated_phone, data.phone)
            dateOpenTextView.text = getString(R.string.formated_date_open, data.dateOpened)
            dateClosedTextView.text = getString(R.string.formated_date_closed, data.dateClosed)
            setNormalState()
        } else
            setEmptyState()
    }

    override fun onLoaderReset(loader: android.support.v4.content.Loader<IMainPresenter>?) {
        presenter = null;
    }

    override fun onLoadFinished(loader: android.support.v4.content.Loader<IMainPresenter>?, data: IMainPresenter?) {
        presenter = data;
    }

    override fun onCreateLoader(id: Int, args: Bundle?): android.support.v4.content.Loader<IMainPresenter>? {
        return MainPresenterLoader(this, object : PresenterFactory<IMainPresenter> {
            override fun createPresenter(): IMainPresenter {
                return MainPresenterImpl()
            }
        })
    }

}
