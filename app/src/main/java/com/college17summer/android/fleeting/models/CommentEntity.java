package com.college17summer.android.fleeting.models;

import java.util.Date;

/**
 * Created by Moonkey on 2017/6/23.
 */

public class CommentEntity {

    private long mId;
    private String mContent;
    private String mIp;
    private Date mTime;

    public CommentEntity() {
        this.mId = 0;
        this.mContent = "this is test comment No.";
        this.mIp = "255.255.255.255";
        this.mTime = new Date();
    }

    public CommentEntity(long mId, String mContent, String mIp, Date mTime) {
        this.mId = mId;
        this.mContent = mContent;
        this.mIp = mIp;
        this.mTime = mTime;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmIp() {
        return mIp;
    }

    public void setmIp(String mIp) {
        this.mIp = mIp;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }
}
