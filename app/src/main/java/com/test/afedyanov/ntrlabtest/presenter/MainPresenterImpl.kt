package com.test.afedyanov.ntrlabtest.presenter

import com.test.afedyanov.ntrlabtest.model.entity.Data
import com.test.afedyanov.ntrlabtest.presenter.presenterinterface.IMainPresenter
import com.test.ntrlabtest.simpletest.view.viewinterface.IMainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Alexandr on 25.07.2016.
 */
class MainPresenterImpl: BasePresenter<IMainView>(), IMainPresenter {

    var isLoading = false
    var data: Data? = null

    override fun getData() {
        if (isLoading)
            view?.showLoading()
        else if (data == null) {
            view?.showLoading()
            loadData()
        } else
            view?.setData(data)
    }

    override fun refreshData() {
        if (isLoading)
            view?.showLoading()
        else {
            if (data == null)
                view?.showLoading()
            else
                view?.showRefreshing()
            loadData()
        }
    }

    fun loadData() {
        isLoading = true
        apiService.getData().enqueue(object: Callback<Data?> {
            override fun onResponse(call: Call<Data?>?, response: Response<Data?>?) {
                if (response!!.isSuccessful) {
                    data = response.body();
                    view?.setData(data)
                } else
                    view?.showError(response.message())
                isLoading = false
            }

            override fun onFailure(call: Call<Data?>?, t: Throwable?) {
                view?.showError(t!!.message.toString())
                isLoading = false
            }
        })
    }

}