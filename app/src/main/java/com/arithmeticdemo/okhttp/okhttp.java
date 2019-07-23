package com.arithmeticdemo.okhttp;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class okhttp {

    public void okhttpTest() {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("")
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
