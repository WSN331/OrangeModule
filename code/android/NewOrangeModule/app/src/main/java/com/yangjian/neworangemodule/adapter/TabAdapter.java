package com.yangjian.neworangemodule.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yangjian.neworangemodule.fragment.ShopFragment;

import java.util.List;

/**
 * Created by Yang on 2017/11/23.
 * Function：将TabLayout和ViewPager关联起来
 */

public class TabAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public TabAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ShopFragment.titles[position];
    }
}
