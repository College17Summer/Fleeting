package com.college17summer.android.fleeting.models;

import java.util.Date;

/**
 * Created by Moonkey on 2017/6/23.
 */

public class HistoryEntity {

    private int mId;
    private int mUserId;
    private int mVideoId;
    private Date time;
    private int process;

    public HistoryEntity() {
        this.mId = 0;
        this.mUserId = 0;
        this.mVideoId = 0;
        this.time = new Date();
        this.process = 0;
    }

    public HistoryEntity(int mId, int mUserId, int mVideoId, Date time, int process) {
        this.mId = mId;
        this.mUserId = mUserId;
        this.mVideoId = mVideoId;
        this.time = time;
        this.process = process;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmUserId() {
        return mUserId;
    }

    public void setmUserId(int mUserId) {
        this.mUserId = mUserId;
    }

    public int getmVideoId() {
        return mVideoId;
    }

    public void setmVideoId(int mVideoId) {
        this.mVideoId = mVideoId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }
}
