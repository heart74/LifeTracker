package com.xin.lifetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

// 在配置文件中声明权限才能访问系统网络状态
public class BroadcastActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    private MyBroadcastReceiver myBroadcastReceiver;
    private static final String TAG = "BroadcastActivity";
    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
////        接收网络改变广播
//        intentFilter = new IntentFilter();
////        想接收什么样的广播，添加相应的action
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        networkChangeReceiver = new NetworkChangeReceiver();
//        registerReceiver(networkChangeReceiver, intentFilter);
//        动态注册 先注册再发送广播
//        intentFilter = new IntentFilter();
//        intentFilter.addAction("com.xin.lifetracker.MY_BROADCAST");
//        intentFilter.setPriority(100);
//        myBroadcastReceiver = new MyBroadcastReceiver();
//        registerReceiver(myBroadcastReceiver, intentFilter);
//        使用本地广播  本地广播同样无法通过静态注册接收
        localBroadcastManager = LocalBroadcastManager.getInstance(this);  //获取实例
        Button button5 = (Button) findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                用数组，实现多个接收器接收无序广播 ：动态注册跨应用需要在对应应用注册
                Intent[] intents = new Intent[3];
                for (int i = 0; i < 2; i++) {
                    intents[i] = new Intent("com.xin.lifetracker.MY_BROADCAST");
                }
///*在Android 7.0及以下版本不是必须的，但是Android 8.0或者更高版本，发送广播的条件更加严苛，必须添加这一行内容。
//创建的ComponentName实例化对象有两个参数，第1个参数是指接收广播类的包名，第2个参数是指接收广播类的完整类名。*/
////                intent.setClassName(this, "com.xin.lifetracker.MyBroadcastReceiver");
//                intents[0].setComponent(new ComponentName("com.xin.lifetracker", "com.xin.lifetracker.MyBroadcastReceiver"));
//                intents[1].setComponent(new ComponentName("com.xin.broadcasttest", "com.xin.broadcasttest.AnotherBroadcastReceiver"));
////                intent.setComponent(new ComponentName("com.xin.broadcasttest", "com.xin.broadcasttest.AnotherBroadcastReceiver"));
////                intent.setClassName("com.xin.broadcasttest","com.xin.lifetracker.AnotherBroadcastReceiver");
//                for (int i =  0; i < 2; i++){
//                    sendBroadcast(intents[i], null);
//                }
//                发送有序广播  从Android 8.0开始,只能使用动态注册接受有序广播,在AndroidManifest.xml静态注册的接收者无法接受有序广播
//              使用静态注册 优先级失效 且广播不能被截断
//                动态注册 先注册再发送广播
//发送一个有序广播
                //sendOrderedBroadcast(Intent intent,  //发送广播的意图对象（可以携带数据）
                //          String receiverPermission, //接收权限（如果为空，则不需要权限）
                //          BroadcastReceiver resultReceiver, //广播接收者对象(自己创建的最终的广播接收者，可以无须在清单文件中配置，也会接收到广播 )
                //          Handler scheduler,         //若传null，则默认是在主线程中
                //          int initialCode,           //初始化的一个值。可默认：Activity.RESULT_OK
                //          String initialData,        //可发送的初始化数据（相当于一条广播数据）。可为null
                //          Bundle initialExtras)      //可绑定数据传递（Intent对象也可以，所以可为null）
//                this.sendOrderedBroadcast(intent, null, new Test0Receiver(), null, Activity.RESULT_OK, "国家发放补贴1000", null);
//                sendOrderedBroadcast(intents[0], null, new FinalReceiver(), null, Activity.RESULT_OK, "有序广播", null);
//                sendOrderedBroadcast(intents[0], null);
                Log.d(TAG, "onClick: Send Broadcast");
                Intent intent = new Intent("com.xin.lifetracker.LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.xin.lifetracker.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter); //注册本地广播监听器
    }

    //    动态注册的广播接收器一定都要取消注册
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(networkChangeReceiver);
//        unregisterReceiver(myBroadcastReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver {
        //        网络状态变化 onReceive()方法就会得到执行
        @Override
        public void onReceive(Context context, Intent intent) {
//            Toast.makeText(context, "network changes", Toast.LENGTH_SHORT).show();
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
            }

        }

    }

    class FinalReceiver extends BroadcastReceiver {
        //        特殊的广播接收者：广播接收者（看成：监察者，用于模拟上述说的有序广播即便被中断，
//        依然可以接收到广播消息的特例）
        @Override
        public void onReceive(Context context, Intent intent) {
            String resultData = getResultData();
//            setResultData("hello world");
            Toast.makeText(context, "Final Receiver!" + resultData, Toast.LENGTH_SHORT).show();
        }
    }

    class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            Toast.makeText(context, "received local broadcast", Toast.LENGTH_LONG).show();
        }
    }
}
