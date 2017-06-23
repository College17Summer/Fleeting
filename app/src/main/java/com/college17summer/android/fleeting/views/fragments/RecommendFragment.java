package com.college17summer.android.fleeting.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college17summer.android.fleeting.R;
import com.college17summer.android.fleeting.adapters.VideoListAdapter;
import com.college17summer.android.fleeting.models.VideoEntity;
import com.college17summer.android.fleeting.models.VideoLabEntity;

import java.util.List;


public class RecommendFragment extends Fragment {
    private static final String TAG = "RecommendFragment";

    private static final String ARG_USER_ID = "mUserId";
    private String mUserId;
    private RecyclerView recyclerView;
    VideoListAdapter adapter;


    public RecommendFragment() {
        // Required empty public constructor
    }


    public static RecommendFragment newInstance(String userId) {
        RecommendFragment fragment = new RecommendFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USER_ID, userId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mUserId = getArguments().getString(ARG_USER_ID);
        }
        Log.e(TAG, "onCreate: Success");
    }



    // Update UI
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recommend_video_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    private void updateUI() {
        List<VideoEntity> videoEntityList = VideoLabEntity.get(getActivity()).getVideos();
        adapter = new VideoListAdapter(getContext(), videoEntityList);
        recyclerView.setAdapter(adapter);
    }

}
