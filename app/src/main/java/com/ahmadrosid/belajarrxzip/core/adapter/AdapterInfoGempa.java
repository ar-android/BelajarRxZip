package com.ahmadrosid.belajarrxzip.core.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ocittwo on 2/25/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
public class AdapterInfoGempa extends FragmentPagerAdapter{

    private final List<Fragment> fragments;
    public String title[] = {"Gempa Terkini", "GempaDirasakan"};

    public AdapterInfoGempa(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override public int getCount() {
        return fragments.size();
    }

    @Override public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
