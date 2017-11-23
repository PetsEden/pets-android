package com.marekchen.pets

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.marekchen.pets.fragment.MineFragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import java.util.*
import com.jaeger.library.StatusBarUtil
import com.marekchen.pets.fragment.SimpleFragment

class MainActivity : AppCompatActivity() {

    private val mFragmentList: MutableList<Fragment> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setStatusBar()
        bottom_navigation_bar.setBarBackgroundColor(android.R.color.white)
        bottom_navigation_bar.activeColor = R.color.colorPrimaryDark
        bottom_navigation_bar.inActiveColor = R.color.grayTextColor
        bottom_navigation_bar.setMode(BottomNavigationBar.MODE_FIXED)
        bottom_navigation_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        bottom_navigation_bar
                .addItem(BottomNavigationItem(R.drawable.ic_home2, R.string.home).setInactiveIconResource(R.drawable.ic_home1))
                .addItem(BottomNavigationItem(R.drawable.ic_found2, R.string.found).setInactiveIconResource(R.drawable.ic_found1))
                .addItem(BottomNavigationItem(R.drawable.ic_message2, R.string.message).setInactiveIconResource(R.drawable.ic_message1))
                .addItem(BottomNavigationItem(R.drawable.ic_mine2, R.string.mine).setInactiveIconResource(R.drawable.ic_mine1))
                .initialise()
        bottom_navigation_bar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabSelected(position: Int) {
                vp_home.currentItem = position
            }

            override fun onTabUnselected(position: Int) {

            }

            override fun onTabReselected(position: Int) {

            }
        })

        mFragmentList.add(MineFragment())
        mFragmentList.add(MineFragment())
        mFragmentList.add(MineFragment())
        mFragmentList.add(MineFragment())

        vp_home.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                bottom_navigation_bar.selectTab(position)
                when (position) {
                    0 -> {
                    }
                    else -> {
                        val random = Random()
                        val color = 0xff000000.toInt() or random.nextInt(0xffffff)
                        if (mFragmentList[position] is SimpleFragment) {
                            (mFragmentList[position] as SimpleFragment).setTvTitleBackgroundColor(color)
                        }
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
        vp_home.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return mFragmentList[position]
            }

            override fun getCount(): Int {
                return mFragmentList.size
            }
        }
    }

    private fun setStatusBar() {
        StatusBarUtil.setTranslucentForImageViewInFragment(this@MainActivity, 50, null)
    }
}
