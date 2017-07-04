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

public class RecommendVideoLabEntity {
    // private static final String TAG = "RecommendVideoLab";

    private static RecommendVideoLabEntity sRecommendVideoLabEntity;
    private List<VideoEntity> videoEntities = new ArrayList<>();

    public static RecommendVideoLabEntity get(Context context) {
        if (sRecommendVideoLabEntity == null) {
            sRecommendVideoLabEntity = new RecommendVideoLabEntity(context);
        }
        return sRecommendVideoLabEntity;
    }

    private RecommendVideoLabEntity(Context context) {
        GenRecommendVideoList();
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
        if (this.videoEntities == null) {
            GenRecommendVideoList();
        }
        return this.videoEntities;
    }


    public void setVideos(List<VideoEntity> videos) {
        this.videoEntities.clear();
        this.videoEntities.addAll(videos);
    }

    // Get video information from Internet
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

    private void GenRecommendVideoList() {
        new Thread(new Runnable() {
            // TODO: Add all urls to a static file
            String url = "http://10.0.2.2:5000/fleeting/api/v1.0/recommendlist";
            String result = "Fail";
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
}

