package com.marekchen.pets.fragment

import android.os.Bundle
import android.support.annotation.ColorInt
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.marekchen.pets.R

class SimpleFragment : Fragment() {
    private var mTvTitle: TextView? = null
    private var mFakeStatusBar: View? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragement_simple, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mTvTitle = view!!.findViewById<View>(R.id.tv_title) as TextView
        mFakeStatusBar = view.findViewById(R.id.fake_status_bar)
    }

    fun setTvTitleBackgroundColor(@ColorInt color: Int) {
        mTvTitle!!.setBackgroundColor(color)
        mFakeStatusBar!!.setBackgroundColor(color)
    }
}

