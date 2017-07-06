package com.college17summer.android.fleeting.views.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college17summer.android.fleeting.R;
import com.college17summer.android.fleeting.adapters.SortedTabsAdapter;
import com.college17summer.android.fleeting.adapters.VideoListAdapter;
import com.college17summer.android.fleeting.models.SortedVideoLabEntity;
import com.college17summer.android.fleeting.models.VideoEntity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zgh on 17-6-19.
 */

public class SortedFragment extends Fragment {
    private static final String ARG_KIND = "mKind";
    private String mKind;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private View result;
    // private static List<SortedVideosFragment> sortedVideosFragments = new ArrayList<SortedVideosFragment>(3);

    //private RecyclerView recyclerView;
    private SortedTabsAdapter tabsAdapter;



    public SortedFragment() {
        // Required empty public constructor
    }


    public static SortedFragment newInstance() {
        SortedFragment fragment;
        fragment = new SortedFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    // Update UI
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        result =  inflater.inflate(R.layout.fragment_sorted, container, false);

        init(result);
        updateUI();
        return result;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void init(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.viewPager_sorted);
        tabsAdapter = new SortedTabsAdapter(this.getActivity().getSupportFragmentManager(), this.getActivity());
        viewPager.setAdapter(tabsAdapter);

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout_sorted);
        tabLayout.setupWithViewPager(viewPager);
    }

    // TODO: Implement concrete functions
    private void updateUI() {

    }
}
