package com.college17summer.android.fleeting.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.college17summer.android.fleeting.R;
import com.college17summer.android.fleeting.views.activities.CategoryActivity;
import com.college17summer.android.fleeting.views.activities.CollectionActivity;
import com.college17summer.android.fleeting.views.activities.CommentActivity;
import com.college17summer.android.fleeting.views.activities.HistoryActivity;

/**
 * Created by zgh on 17-6-20.
 */

public class SettingFragment extends Fragment {

    private static final String ARG_USER_ID = "mUserId";

    private String mUserId;
    private TextView tvHistory;
    private TextView tvCollection;
    private TextView tvCategory;
    private TextView tvComment;


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

    private void init(View v) {


        // bind view collection
        tvCollection = (TextView)v.findViewById(R.id.txt_my_collection);
        tvCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CollectionActivity.class);
                startActivity(intent);
            }
        });

        // bind view category
        tvCategory = (TextView)v.findViewById(R.id.txt_my_category);
        tvCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CategoryActivity.class);
                startActivity(intent);
            }
        });

        // bind view comment
        tvComment = (TextView)v.findViewById(R.id.txt_my_comment);
        tvComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CommentActivity.class);
                startActivity(intent);
            }
        });

        // bind view history
        tvHistory = (TextView)v.findViewById(R.id.txt_my_history);
        tvHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HistoryActivity.class);
                startActivity(intent);
            }
        });
    }

    // Update UI
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);


        init(view);

        updateUI();
        return view;
    }

    private void updateUI() {

    }


}
