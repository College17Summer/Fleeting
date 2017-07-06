package com.college17summer.android.fleeting.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.college17summer.android.fleeting.models.SortedVideoList;
import com.college17summer.android.fleeting.views.fragments.SortedVideosFragment;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by zgh on 17-6-15.
 */

public class SortedTabsAdapter extends FragmentPagerAdapter{
    // Kinds of videos
    private String[] tabs = {"anime", "music", "joy", "game", "dance"};
    //  private static Map<String, SortedVideosFragment> fragments = new HashMap<>(3);
    //, "joy", "movie","music","pool"
    private Context context;

    public SortedTabsAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
//        for (int i = 0; i < 3; i++) {
//            fragments.put(tabs[i], SortedVideosFragment.newInstance(tabs[i]));
//        }
    }

    @Override
    public Fragment getItem(int position) {
        Log.e("VideoListFragment: ", "getItem: " + tabs[position]);
        return SortedVideosFragment.newInstance(tabs[position]);
//        return fragments.get(tabs[position]);
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


