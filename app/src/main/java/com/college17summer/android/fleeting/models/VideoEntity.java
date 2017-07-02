package com.college17summer.android.fleeting.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zgh on 17-6-16.
 */

public class VideoEntity {
    @SerializedName("id")
    private long mVideoId;
    @SerializedName("title")
    private String mVideoTitle;
    @SerializedName("cover")
    private String mVideoCover;
    @SerializedName("description")
    private String mVideoDescription;
    @SerializedName("url")
    private String mVideoUrl;
    @SerializedName("size")
    private long mVideoSize;
    @SerializedName("type")
    private String mVideoType;


    public VideoEntity(long mVideoId, String mVideoUrl, String mVideoTitle, String mVideoCover, long mVideoSize, String mVideoType) {
        this.mVideoId = mVideoId;
        this.mVideoUrl = mVideoUrl;
        this.mVideoTitle = mVideoTitle;
        this.mVideoCover = mVideoCover;
        this.mVideoSize = mVideoSize;
        this.mVideoType = mVideoType;
    }

    public String getmVideoDescription() {
        return mVideoDescription;
    }

    public void setmVideoDescription(String mVideoDescription) {
        this.mVideoDescription = mVideoDescription;
    }

    public String getmVideoCover() {
        return mVideoCover;
    }

    public void setmVideoCover(String mVideoCover) {
        this.mVideoCover = mVideoCover;
    }

    public long getmVideoSize() {
        return mVideoSize;
    }

    public void setmVideoSize(long mVideoSize) {
        this.mVideoSize = mVideoSize;
    }

    public String getmVideoType() {
        return mVideoType;
    }

    public void setmVideoType(String mVideoType) {
        this.mVideoType = mVideoType;
    }

    public long getmVideoId() {
        return mVideoId;
    }

    public void setmVideoId(long mVideoId) {
        this.mVideoId = mVideoId;
    }

    public String getmVideoUrl() {
        return mVideoUrl;
    }

    public void setmVideoUrl(String mVideoUrl) {
        this.mVideoUrl = mVideoUrl;
    }

    public String getmVideoTitle() {
        return mVideoTitle;
    }

    public void setmVideoTitle(String mVideoTitle) {
        this.mVideoTitle = mVideoTitle;
    }

}

