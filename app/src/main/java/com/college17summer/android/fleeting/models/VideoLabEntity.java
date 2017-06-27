package com.college17summer.android.fleeting.models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zgh on 17-6-16.
 */

public class VideoLabEntity {
    private static VideoLabEntity sVideoLabEntity;
    private List<VideoEntity> videoEntities = new ArrayList<VideoEntity>(10);
    public static VideoLabEntity get(Context context) {
        if (sVideoLabEntity == null) {

            sVideoLabEntity = new VideoLabEntity(context);
            for(int i = 0; i < 10; i++) {
                sVideoLabEntity.videoEntities.add(new VideoEntity("id" + i, "name" + i, "http://img.wdjimg.com/image/video/cfc2ffd94f4c2234ff9f77eb99205791_0_0.jpeg"));
            }
        }
        return sVideoLabEntity;
    }

    private VideoLabEntity(Context context) {}

    public VideoEntity getVideo(String videoId) {
        for (VideoEntity videoEntity : videoEntities) {
            if (videoEntity.getmVideoId() == videoId) {
                return videoEntity;
            }
        }
        return null;
    }

    public List<VideoEntity> getVideos() {
        return this.videoEntities;
    }
}

