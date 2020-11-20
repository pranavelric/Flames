package com.flame.flames.ui.walkThrough

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.flame.flames.ui.walkThrough.fragments.FirstWalkFragment
import com.flame.flames.ui.walkThrough.fragments.SecondWalkFragment

class ViewPagerAdapter(private val fragmentManager: FragmentManager, private val behaviour: Int) :
    FragmentPagerAdapter(fragmentManager, behaviour) {

    override fun getCount(): Int {
        return 2
    }



    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return FirstWalkFragment()
            1 -> return SecondWalkFragment()
            else -> return FirstWalkFragment()
        }

    }
}