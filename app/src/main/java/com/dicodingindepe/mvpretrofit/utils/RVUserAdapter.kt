package com.dicodingindepe.mvpretrofit.utils

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dicodingindepe.mvpretrofit.R
import com.dicodingindepe.mvpretrofit.model.User
import org.jetbrains.anko.find

class RVUserAdapter(val data: List<User>) : RecyclerView.Adapter<RVUserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_rv, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItem(data[p1])
    }

    class ViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textLogin = itemView.find<TextView>(R.id.tvLogin)
        fun bindItem(user: User) {
            textLogin.text = user.login
        }
    }
}