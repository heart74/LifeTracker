package com.xin.lifetracker;

//  HttpURLConnection网络请求回调机制  定义接口
public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}