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

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zgh on 17-6-19.
 */

public class SortedFragment extends Fragment {
    private static final String ARG_KIND = "mKind";
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private static List<SortedVideosFragment> sortedVideosFragments = new ArrayList<SortedVideosFragment>(3);

    //private RecyclerView recyclerView;
    private SortedTabsAdapter tabsAdapter;

    private String mKind;


    public SortedFragment() {
        // Required empty public constructor
    }


    public static SortedFragment newInstance(String mKind) {
        SortedFragment fragment;
        fragment = new SortedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_KIND, mKind);
        fragment.setArguments(args);
        return fragment;
    }

    // Video Type
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mKind = getArguments().getString(ARG_KIND);
        }
    }



    // Update UI
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result =  inflater.inflate(R.layout.fragment_sorted, container, false);

        init(result);
        updateUI();
        return result;
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
