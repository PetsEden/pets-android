package com.marekchen.pets.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.marekchen.pets.R
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View

class MineFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_mine, container, false);
    }
}
