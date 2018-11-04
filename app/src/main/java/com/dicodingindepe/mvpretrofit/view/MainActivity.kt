package com.dicodingindepe.mvpretrofit.view

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.dicodingindepe.mvpretrofit.R
import com.dicodingindepe.mvpretrofit.model.User
import com.dicodingindepe.mvpretrofit.presenter.MainPresenter
import com.dicodingindepe.mvpretrofit.utils.DataRepository
import com.dicodingindepe.mvpretrofit.utils.RVUserAdapter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(),MainView {
    private val data:MutableList<User> = mutableListOf()
    private lateinit var userAdapter:RVUserAdapter
    private lateinit var presenter:MainPresenter

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showUsers(data: List<User>) {
        this.data.clear()
        this.data.addAll(data)
        this.userAdapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        userAdapter = RVUserAdapter(data)
        rvUsers.layoutManager = LinearLayoutManager(applicationContext)
        rvUsers.adapter = userAdapter

        val service = DataRepository.create()
        presenter = MainPresenter(this,service)
        presenter.getUsers()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
