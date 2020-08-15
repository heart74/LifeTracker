package com.xin.lifetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {
    private NotificationManager manager;
    private static final String TAG = "NotificationActivity";
    private String channelId = "chat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
        String channelName = "聊天消息";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
// Android8.0之后 带渠道的通知创建
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);//第一步
        NotificationChannel channel = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {//
            channel = new NotificationChannel(channelId, channelName, importance);//第二步
            manager.createNotificationChannel(channel);//第三步
//            四五步见函数
        } else {
            Log.d(TAG, "error ");
        }
//        sendNotice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(NotificationActivity.this, UIBestActivity.class);
//                PendingIntent pendingIntent = PendingIntent.getActivity(NotificationActivity.this, 0,
//                        intent, 0);
//                final Notification notification = new NotificationCompat.Builder(
//                        NotificationActivity.this, channelId)//第四步
//                        .setAutoCancel(true).setContentTitle("收到聊天消息")
//                        .setContentText("今天晚上吃什么?????????????????????????????????")
//                        .setSmallIcon(R.drawable.pic_1)
//                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.avatar))
//                        .setContentIntent(pendingIntent)
//                        .setWhen(System.currentTimeMillis())
//                        //设置红色
////                .setColor(Color.parseColor("#F00606"))
//                        .build();
//                Log.d(TAG, "onClick: ");
//                manager.notify(1, notification);         //第五步
//                //Toast.makeText(MainActivity.this,"H",Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    //    创建渠道函数定义
//    private void createNotificationChannel() {
//        // Create the NotificationChannel, but only on API 26+ because
//        // the NotificationChannel class is new and not in the support library
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            CharSequence name = getString(R.string.channel_name);
//            String description = getString(R.string.channel_description);
//            int importance = NotificationManager.IMPORTANCE_DEFAULT;
//            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
//            channel.setDescription(description);
//            // Register the channel with the system; you can't change the importance
//            // or other notification behaviors after this
//            NotificationManager notificationManager = getSystemService(NotificationManager.class);
//            notificationManager.createNotificationChannel(channel);
//        }
//    }
    String test = "//        // the NotificationChannel class is new and not in the support library\n" +
            "//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {\n" +
            "//            CharSequence name = getString(R.string.channel_name);\n" +
            "//            String description = getString(R.string.channel_description);\n" +
            "//            int importance = NotificationManager.IMPORTANCE_DEFAULT;\n" +
            "//            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);\n" +
            "//            channel.setDescription(description);\n" +
            "//            // Register the channel with the system; you can't change the importance\n" +
            "//            // or other notification behaviors after this\n" +
            "//            NotificationManager notificationManager = getSystemService(NotificationManager.class);\n";

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:
//                为通知添加点击事件
                Intent intent = new Intent(this, UIBestActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                        intent, 0);
                Notification notification = new NotificationCompat.Builder(
                        this, channelId)//第四步
                        .setAutoCancel(true).setContentTitle("收到聊天消息")
//                        .setContentText(test)
//                        .setStyle(new NotificationCompat.BigTextStyle().bigText(test))
                        .setStyle(new NotificationCompat.BigPictureStyle()
                                .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.img_1)))
                        .setSmallIcon(R.drawable.pic_1)
                        .setAutoCancel(true)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.avatar))
                        .setContentIntent(pendingIntent)
                        .setWhen(System.currentTimeMillis())
                        //设置红色
//                .setColor(Color.parseColor("#F00606"))
                        .build();
                Log.d(TAG, "onClick: button");
                manager.notify(1, notification);         //第五步
                //Toast.makeText(MainActivity.this,"H",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }
    }
}
