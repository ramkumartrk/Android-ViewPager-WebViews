package com.example.viewpager.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.viewpager.First_Fragment
import com.example.viewpager.Fourth_fragment
import com.example.viewpager.Second_Fragment
import com.example.viewpager.Third_Fragment

class MyPagerAdapter(context : Context,fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager)
{

    override fun getItem(position: Int): Fragment {

        when(position)
        {
            0-> return First_Fragment()
            1 -> return Second_Fragment()
            2-> return Third_Fragment()
            3-> return Fourth_fragment()
        }
            return Fragment()
    }

    override fun getCount(): Int {
       return 4
    }


}