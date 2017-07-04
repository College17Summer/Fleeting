package com.college17summer.android.fleeting.models;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Moonkey on 2017/6/29.
 */

// Video list sorted by video type
public class SortedVideoList {
    private String videoType;
    private List<VideoEntity> videoEntities = new ArrayList<>(5);

    public String getVideoType() {
        return videoType;
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
        return this.videoEntities;
    }


    // Generate sorted video list
    public SortedVideoList(Context context, String videoType) {
        this.videoType = videoType;
        GenSortedVideoList(videoType);
    }

    private void GenSortedVideoList(String videoType) {
        new Thread(new Runnable() {
            // TODO: Add all urls to a static file
            String url = "http://182.254.230.24:5000/fleeting/api/v1.0/sortedlist/" + getVideoType();
            String result = "[{id: 0 , cover: error}]";
            List<VideoEntity> videos = new ArrayList<VideoEntity>();

            @Override
            public void run() {
                try {
                    result = getRes(url);
                    videos = gson.fromJson(result, new TypeToken<ArrayList<VideoEntity>>(){}.getType());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                setVideos(videos);
            }
        }).start();
    }

    public void setVideos(List<VideoEntity> videos) {
        this.videoEntities.clear();
        this.videoEntities.addAll(videos);
    }

    // Get information from Internet
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();
    public String getRes (String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }
}
