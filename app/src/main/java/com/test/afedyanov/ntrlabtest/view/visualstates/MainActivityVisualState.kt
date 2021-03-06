package com.test.afedyanov.ntrlabtest.view.visualstates

import android.view.View
import com.test.afedyanov.ntrlabtest.view.activity.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.view_data_item.*

/**
 * Created by Alexandr on 25.07.2016.
 */

fun MainActivity.setNormalState() {
    dataLayout.visibility = View.VISIBLE
    noDataTextView.visibility = View.INVISIBLE
    progress.visibility = View.INVISIBLE
    pullToRefresh.isRefreshing = false
}

fun MainActivity.setLoadingState() {
    dataLayout.visibility = View.INVISIBLE
    noDataTextView.visibility = View.INVISIBLE
    progress.visibility = View.VISIBLE
    pullToRefresh.isRefreshing = false
}

fun MainActivity.setRefreshingState() {
    dataLayout.visibility = View.VISIBLE
    noDataTextView.visibility = View.INVISIBLE
    progress.visibility = View.INVISIBLE
    pullToRefresh.isRefreshing = true
}

fun MainActivity.setErrorState(errorMessage: String) {
    showDialog(errorMessage)
    setEmptyState()
}

fun MainActivity.setEmptyState() {
    dataLayout.visibility = View.INVISIBLE
    noDataTextView.visibility = View.VISIBLE
    progress.visibility = View.INVISIBLE
    pullToRefresh.isRefreshing = false
}