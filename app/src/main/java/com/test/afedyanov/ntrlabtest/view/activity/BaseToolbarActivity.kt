package com.test.afedyanov.ntrlabtest.view.activity

import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.Toast
import com.test.afedyanov.ntrlabtest.R
import kotlinx.android.synthetic.main.view_toolbar.*

/**
 * Created by Alexandr on 25.07.2016.
 */
abstract class BaseToolbarActivity : AppCompatActivity() {


    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        initToolBar()
        setupLayout()
    }

    private fun initToolBar() {
        setSupportActionBar(toolbar)
    }

    abstract fun setupLayout()

    fun showMessage(message: String) {
        val rootView = findViewById(android.R.id.content)
        val viewGroup = (rootView as ViewGroup?)?.getChildAt(0) as ViewGroup?;
        if (viewGroup is CoordinatorLayout )
            Snackbar.make(viewGroup, message, Snackbar.LENGTH_LONG).show()
        else
            rootView ?: Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }

    fun showDialog(message: String) {
        AlertDialog.Builder(this).setMessage(message)
                .setPositiveButton(R.string.ok_dialog_button, null)
                .setCancelable(true)
                .show()
    }

    fun showDialog(message: String, okText: String, cancelText: String?, onOkClick: () -> Unit?, onCancelClick: () -> Unit?) {
        AlertDialog.Builder(this).setMessage(message)
                .setPositiveButton(okText, { dialogInterface, i -> onOkClick.invoke()})
                .setNegativeButton(cancelText, { dialogInterface, i -> onCancelClick.invoke()})
                .setCancelable(false)
                .show()
    }
}