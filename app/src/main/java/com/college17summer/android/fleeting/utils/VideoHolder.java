package com.college17summer.android.fleeting.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.college17summer.android.fleeting.R;
import com.facebook.drawee.view.SimpleDraweeView;

import org.w3c.dom.Text;

/**
 * Created by Moonkey on 2017/6/23.
 */

public class VideoHolder extends RecyclerView.ViewHolder {
    // TODO: Implement-- Make view holder able to be more generally used

    public SimpleDraweeView mVideoCover;
    public TextView mVideoTitle;
    public TextView mVideoDescription;
    public TextView mVideoType;
    public TextView mVideoDuration;
    public ImageButton mVideoPlayButton;


    public VideoHolder(View itemView) {
        super(itemView);
        mVideoCover = (SimpleDraweeView) itemView.findViewById(R.id.recommend_video_cover);
        mVideoTitle = (TextView) itemView.findViewById(R.id.video_title);
        mVideoPlayButton = (ImageButton) itemView.findViewById(R.id.video_button);
    }
}
