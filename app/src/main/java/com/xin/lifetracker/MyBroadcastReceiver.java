package com.xin.lifetracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        String resultData = getResultData();
        setResultData("hello second");
        Log.d(TAG, "onReceive: received in MybroadcastReceiver");
        Toast.makeText(context, "received in MyBroadcastReceiver" + resultData, Toast.LENGTH_LONG).show();
//    abortBroadcast();
    }
}
