package com.college17summer.android.fleeting.models;

import android.content.Context;

import com.college17summer.android.fleeting.utils.ApiAddress;
import com.college17summer.android.fleeting.utils.NetRes;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hyoukana on 6/28/17.
 */

public class CollectionVideoLabEntity {

    private static CollectionVideoLabEntity sCollectionVideoLabEntity;
    private List<VideoEntity> videoEntities = new ArrayList<>();

    public static CollectionVideoLabEntity get(Context context) {
        if (sCollectionVideoLabEntity == null) {
            sCollectionVideoLabEntity = new CollectionVideoLabEntity(context);
        }
        return sCollectionVideoLabEntity;
    }

    private CollectionVideoLabEntity(Context context) {
        if ( UserEntity.getUserInstance().getmUserName() != "") {
            GenRecommendVideoList(UserEntity.getUserInstance().getmUserName());
        }
    }

    public VideoEntity getVideo(long videoId) {
        for (VideoEntity videoEntity : videoEntities) {
            if (videoEntity.getmVideoId() == videoId) {
                return videoEntity;
            }
        }
        return null;
    }

    public List<VideoEntity> getVideos() {
        if ( UserEntity.getUserInstance().getmUserName() != "") {
            GenRecommendVideoList(UserEntity.getUserInstance().getmUserName());
        }
        return this.videoEntities;
    }


    public void setVideos(List<VideoEntity> videos) {
        this.videoEntities.clear();
        this.videoEntities.addAll(videos);
    }

    private void GenRecommendVideoList(final String userName) {
        new Thread(new Runnable() {
            String url = ApiAddress.url_collection_list + "/" + userName;
            String result = "[{id: 0 , cover: error}]";
            List<VideoEntity> videos = new ArrayList<VideoEntity>();

            @Override
            public void run() {
                try {
                    result = NetRes.getRes(url);
                    videos = NetRes.getGson().fromJson(result, new TypeToken<ArrayList<VideoEntity>>(){}.getType());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                setVideos(videos);
            }
        }).start();
    }
}
