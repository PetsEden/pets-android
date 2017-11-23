package com.marekchen.pets.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.marekchen.pets.Bean.Twitter
import com.marekchen.pets.R

/**
 * Created by chenpei on 2017/11/23.
 */

class HomeCardAdapter(dataList: MutableList<Twitter>) : RecyclerView.Adapter<HomeCardAdapter.ViewHolder>() {

    private var mData: MutableList<Twitter> = dataList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCardAdapter.ViewHolder? {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_home_card2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeCardAdapter.ViewHolder?, position: Int) {
        holder?.mNameTextView!!.text = mData[position].name
        holder?.mMessageTextView.text = mData[position].message
    }

    override fun getItemCount(): Int = mData.size

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var mNameTextView: TextView = itemView!!.findViewById(R.id.card_name)
        var mMessageTextView: TextView = itemView!!.findViewById(R.id.card_message)
        //var mMessageTextView : TextView = itemView!!.findViewById(R.id.card)
    }
}
