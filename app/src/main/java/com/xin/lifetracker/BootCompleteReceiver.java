package com.xin.lifetracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootCompleteReceiver extends BroadcastReceiver {

    //    不要在onReceive()方法中添加过多的逻辑或者进行任何耗时操作，因为在广播接收器中是不允许开启线程的
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        Toast.makeText(context, "Boot Complete", Toast.LENGTH_LONG).show();
    }

}
