package com.college17summer.android.fleeting.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.college17summer.android.fleeting.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zgh on 17-6-19.
 */

public class VideoInfoFragment extends Fragment{
    Unbinder unbinder;

    public VideoInfoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_item, container, false);
        //获取数据
        ButterKnife.bind(this, view);
        unbinder = ButterKnife.bind(this, getActivity());
        initData();
        return view;
    }
    //初始化数据
    private void initData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
