package com.example.demo.utils;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OkHttpClientKit {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//    private static OkHttpClient client = new OkHttpClient();
    private static OkHttpClient client =new OkHttpClient().newBuilder()
        .connectTimeout(100, TimeUnit.SECONDS)
        .writeTimeout(100, TimeUnit.SECONDS)
        .readTimeout(200, TimeUnit.SECONDS).build();

    public static String postJSON(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
