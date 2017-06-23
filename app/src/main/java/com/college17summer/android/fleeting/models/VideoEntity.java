package com.college17summer.android.fleeting.models;

/**
 * Created by zgh on 17-6-16.
 */

public class VideoEntity {
    private String mVideoId = "";
    private String mVideoUrl = "";
    private String mVideoName = "";
    // private String mVideoCover = "";

    public VideoEntity(String mVideoId, String mVideoName, String mVideoUrl) {
        this.mVideoId = mVideoId;
        this.mVideoUrl = mVideoUrl;
        this.mVideoName = mVideoName;
    }

    public String getmVideoId() {
        return mVideoId;
    }

    public void setmVideoId(String mVideoId) {
        this.mVideoId = mVideoId;
    }

    public String getmVideoUrl() {
        return mVideoUrl;
    }

    public void setmVideoUrl(String mVideoUrl) {
        this.mVideoUrl = mVideoUrl;
    }

    public String getmVideoName() {
        return mVideoName;
    }

    public void setmVideoName(String mVideoName) {
        this.mVideoName = mVideoName;
    }

}

