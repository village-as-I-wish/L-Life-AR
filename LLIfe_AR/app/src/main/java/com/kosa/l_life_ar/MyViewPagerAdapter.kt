package com.kosa.l_life_ar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class SectionPageAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {
    private val mFragmentList: MutableList<Fragment> = ArrayList<Fragment>()
    private val mFragmentTitleList: MutableList<String> = ArrayList()
    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }
}