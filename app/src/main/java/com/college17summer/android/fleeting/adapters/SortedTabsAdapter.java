package com.college17summer.android.fleeting.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.college17summer.android.fleeting.views.fragments.SortedVideosFragment;


/**
 * Created by zgh on 17-6-15.
 */

public class SortedTabsAdapter extends FragmentPagerAdapter{
    // Kinds of videos
    private String[] tabs = new String[]{"kind1", "kind2", "kind3","kind4","kind5"};
    private Context context;

    public SortedTabsAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return SortedVideosFragment.newInstance(tabs[position]);
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}




/**
 * Created by zgh on 17-6-14.
 */


