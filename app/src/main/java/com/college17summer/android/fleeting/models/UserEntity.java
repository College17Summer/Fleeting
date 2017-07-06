package com.college17summer.android.fleeting.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.vov.vitamio.utils.Log;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Moonkey on 2017/6/23.
 */

public class UserEntity {

    final public static String TAG = "UserEntity";
    private static UserEntity userInstance;

    private static String res;

    @SerializedName("id")
    private long mId;
    @SerializedName("username")
    private String mUserName;
    @SerializedName("password")
    private String mPassword;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("register_time")
    private Date mTime;

    private List<CollectionVideoLabEntity> mCollections;
    private List<CategoryEntity> mCategories;
    private List<HistoryEntity> mHistories;

    public UserEntity() {
        this.mId = 0;
        this.mUserName = "";
        this.mPassword = "";
        this.mEmail = "123@example.com";
        this.mTime = new Date();
        this.mCollections = new ArrayList<CollectionVideoLabEntity>();
        this.mCategories = new ArrayList<CategoryEntity>();
        this.mHistories = new ArrayList<HistoryEntity>();
    }

    public UserEntity(UserEntity aUser) {
        this.mId = aUser.getmId();
        this.mUserName = aUser.getmUserName();
        this.mPassword = aUser.getmPassword();
        this.mEmail = aUser.getmEmail();
        this.mTime = aUser.getmTime();
        this.mCollections = aUser.getmCollections();
        this.mCategories = aUser.getmCategories();
        this.mHistories = aUser.getmHistories();
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    public List<CollectionVideoLabEntity> getmCollections() {
        return mCollections;
    }

    public void setmCollections(List<CollectionVideoLabEntity> mCollections) {
        this.mCollections = mCollections;
    }

    public List<CategoryEntity> getmCategories() {
        return mCategories;
    }

    public void setmCategories(List<CategoryEntity> mCategories) {
        this.mCategories = mCategories;
    }

    public List<HistoryEntity> getmHistories() {
        return mHistories;
    }

    public void setmHistories(List<HistoryEntity> mHistories) {
        this.mHistories = mHistories;
    }

    public static UserEntity getUserInstance() {
        if(userInstance == null) {
            userInstance = new UserEntity();
        }
        return userInstance;
    }

    public static void netInstance() {

        Log.d(TAG,"in net Instance");
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder()
                .url("https://www.baidu.com/")
                .build();
        //new call
        Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        /*
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG,"request call fail");
            }

            @Override
            public void onResponse(Call call, Response response)
                    throws IOException {
                Log.d(TAG,"request call get");
                res = response.body().string();
                Log.d(TAG,res);
            }
        });*/

        //Gson gson = new Gson();
        //UserEntity aUser = gson.fromJson(res,UserEntity.class);
    }
}
