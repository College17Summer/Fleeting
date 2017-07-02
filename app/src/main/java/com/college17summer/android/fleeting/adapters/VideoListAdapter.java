package com.college17summer.android.fleeting.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college17summer.android.fleeting.R;
import com.college17summer.android.fleeting.models.VideoEntity;
import com.college17summer.android.fleeting.utils.VideoHolder;
import com.college17summer.android.fleeting.views.activities.VideoPlayActivity;

import java.util.List;

/**
 * Created by Moonkey on 2017/6/23.
 */

public class VideoListAdapter extends RecyclerView.Adapter<VideoHolder> {
    private Context mContext;
    private List<VideoEntity> videoEntityList;

    public VideoListAdapter(Context mContext, List<VideoEntity> videoEntityList) {
        this.mContext = mContext;
        this.videoEntityList = videoEntityList;
    }

    @Override
    public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext.getApplicationContext())
                .inflate(R.layout.fragment_video_item, parent, false);

        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoHolder holder, int position) {
        final VideoEntity videoEntity = videoEntityList.get(position);
        holder.mVideoCover.setImageURI(videoEntity.getmVideoCover());
        holder.mVideoTitle.setText(videoEntity.getmVideoTitle());
        holder.mVideoPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext.getApplicationContext(), VideoPlayActivity.class);
                intent.putExtra("videoUrl", videoEntity.getmVideoUrl());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoEntityList.size();
    }
}
