package com.example.ahmedd.news_app.Adapters;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }


    public void AddFragmentPage(Fragment fragment, String title ){
        fragments.add(fragment);
        titles.add(title);
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }


    @Override
    public int getCount() {
        return fragments.size();
    }
}



