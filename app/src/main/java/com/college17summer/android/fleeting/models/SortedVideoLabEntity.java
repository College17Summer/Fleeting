package com.college17summer.android.fleeting.models;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;


public class SortedVideoLabEntity {
    // TODO: Complete this array
    private static final String VideoTypeList[] = {"anime", "joy", "music"};

    private static SortedVideoLabEntity sSortedVideoLabEntity;
    protected Map<String, SortedVideoList> sortedVideoLists = new HashMap<String, SortedVideoList>(9);

    public static SortedVideoLabEntity get(Context context) {
        if (sSortedVideoLabEntity == null) {
            sSortedVideoLabEntity = new SortedVideoLabEntity(context);
        }
        return sSortedVideoLabEntity;
    }

    public SortedVideoList getVideoList(Context context, String videoType) {
        SortedVideoList sortedVideoList = this.sortedVideoLists.get(videoType);
        if (sortedVideoList == null) {
            sortedVideoList = new SortedVideoList(context, videoType);
            this.sortedVideoLists.put(videoType, sortedVideoList);
        }
        return sortedVideoList;
    }

    private SortedVideoLabEntity(Context context) {
        GenSortedVideoLists(context);
    }

    // Generate all kinds of video lists
    private void GenSortedVideoLists(Context context) {
        for (int i = 0; i < this.VideoTypeList.length; i++) {
            SortedVideoList list = new SortedVideoList(context, VideoTypeList[i]);
            this.sortedVideoLists.put(VideoTypeList[i], list);
        }
    };

    public void updateVideoList(Context context, String videoType) {
        SortedVideoList list = new SortedVideoList(context, videoType);
        this.sortedVideoLists.put(videoType, list);
    }
}
