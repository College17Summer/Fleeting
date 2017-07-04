package com.college17summer.android.fleeting.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Moonkey on 2017/6/23.
 */

public class CategoryEntity {

    @SerializedName("id")
    private long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("description")
    private String mDescription;

    public CategoryEntity() {
        this.mId = 0;
        this.mName = "Category";
        this.mDescription = "This is a description of category.";
    }

    public CategoryEntity(long mId, String mName, String mDescription) {
        this.mId = mId;
        this.mName = mName;
        this.mDescription = mDescription;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
