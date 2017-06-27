package com.college17summer.android.fleeting.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.college17summer.android.fleeting.R;

/**
 * Created by zgh on 17-6-20.
 */

public class SettingFragment extends Fragment {
    private static final String ARG_USER_ID = "mUserId";
    private String mUserId;
    private TextView historyView;
    private TextView collectionsView;
    private TextView categoryView;



    public SettingFragment() {
        // Required empty public constructor
    }


    public static SettingFragment newInstance(String mUserId) {
        SettingFragment fragment = new SettingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USER_ID, mUserId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mUserId = getArguments().getString(ARG_USER_ID);
        }
    }

    // Update UI
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);


        updateUI();
        return view;
    }

    private void updateUI() {

    }
}
