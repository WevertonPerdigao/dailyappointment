package com.andersonk.androidcourse.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.andersonk.androidcourse.fragments.HelloFragment
import com.andersonk.androidcourse.fragments.StackFragment

class FragmentsTabs(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(
    fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {


    val stackFragment = StackFragment()
    val helloFragment = HelloFragment()


    override fun getPageTitle(position: Int): CharSequence? {
         super.getPageTitle(position)
        return when (position) {
            0 -> {
                "Stack"
            }
            else -> {
                "Hello"
            }
        }
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                stackFragment
            }
            else -> {
                helloFragment
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }


}