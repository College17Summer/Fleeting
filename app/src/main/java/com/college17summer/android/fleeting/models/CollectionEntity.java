package com.college17summer.android.fleeting.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by hyoukana on 6/28/17.
 */

public class CollectionEntity {

    @SerializedName("id")
    private long mId;
    @SerializedName("user_id")
    private long mUserId;
    @SerializedName("video_id")
    private long mVideoId;
    @SerializedName("time")
    private Date mTime;

    public CollectionEntity() {
        this.mId = 0;
        this.mUserId = 0;
        this.mVideoId = 0;
        this.mTime = new Date();
    }

    public CollectionEntity(long mId, long mUserId, long mVideoId, Date mTime) {
        this.mId = mId;
        this.mUserId = mUserId;
        this.mVideoId = mVideoId;
        this.mTime = mTime;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public long getmUserId() {
        return mUserId;
    }

    public void setmUserId(long mUserId) {
        this.mUserId = mUserId;
    }

    public long getmVideoId() {
        return mVideoId;
    }

    public void setmVideoId(long mVideoId) {
        this.mVideoId = mVideoId;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }
}
