package com.college17summer.android.fleeting.utils;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Moonkey on 2017/7/5.
 */

public class NetRes {
    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();
    public static String getRes (String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }
    public static Gson getGson() {
        return gson;
    }
}
