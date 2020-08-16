package com.xin.lifetracker;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class HttpUtil {

    public static void sendHttpRequest(final String address, final HttpCallbackListener listener) {
        // 开启子线程执行具体的网络操作防止主线程堵塞
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL(address);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    if (listener != null) {
                        // 回调onFinish()方法
                        listener.onFinish(response.toString());
                    }
                } catch (Exception e) {
                    if (listener != null) {
                        // 回调onError()方法
                        listener.onError(e);
                    }
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
//        okhttp3.Callback这是OkHttp库中自带的一个回调接口，enqueue()方法内部开好了子线程，在子线程中执行
//        HTTP请求，将最终的请求结果回调到okhttp3.Callback中
    }
}

// 工具类测试
class HttpUtilText {
    public static void main(String args) {
//        HttpURLConnection
        String address = "";
        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                // 在这里根据返回内容执行具体的逻辑
            }

            @Override
            public void onError(Exception e) {
            }
        });

//         OKHttp
        HttpUtil.sendOkHttpRequest(address, new okhttp3.Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // 得到服务器返回的具体内容
                String responseData = response.body().toString();
            }

            @Override
            public void onFailure(Call call, IOException e) {
                // 在这里对异常情况进行处理
            }
        });
    }
}