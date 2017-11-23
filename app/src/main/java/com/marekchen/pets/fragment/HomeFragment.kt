package com.marekchen.pets.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marekchen.pets.Bean.Twitter

import com.marekchen.pets.R
import com.marekchen.pets.adapter.HomeCardAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import android.support.v7.widget.LinearLayoutManager

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data1 = Twitter(name = "WENDY", distinct = "江苏 淮安", message = "ddddddddd")
        val data2 = Twitter(name = "WENDY", distinct = "江苏 淮安", message = "ddddddddd")
        val data3 = Twitter(name = "WENDY", distinct = "江苏 淮安", message = "ddddddddd")
        val dataList = mutableListOf(data1, data2, data3)
        val adapter = HomeCardAdapter(dataList)
        val layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        card_recycler_view.layoutManager = layoutManager
        card_recycler_view.adapter = adapter
    }
}
