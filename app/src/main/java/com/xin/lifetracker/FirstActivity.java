package com.xin.lifetracker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    private static final String TAG = "FirstActivity";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        得到MenuInflater对象，调用inflate方法就可以给当前活动创建菜单。
        getMenuInflater().inflate(R.menu.main, menu);
//        true表示允许创建的菜单显示出来
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
            default:
        }
        return true;
    }

    // 活动在第一次创建时被调用
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Task id is " + getTaskId());
        // 给当前活动加载一个布局 xml
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                吐司显示文字
//                Toast.makeText(FirstActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT).show();
//                销毁活动
//                finish();
//                使用Intent在活动之间穿梭
//                显式intent
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                隐式intent
//                Intent intent = new Intent("com.xin.lifetracker.ACTION_START");
//                intent.addCategory("com.xin.lifetracker.MY_CATEGORY");
//                隐式intent打开网页
//                Intent intent = new Intent(Intent.ACTION_VIEW);
////                setData接受一个Uri对象，指定当前intent正在操作的数据
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                调用系统拨号界面
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
//                向下一个活动传递数据
//                String data = "Hello SecondActivity";
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                intent.putExtra("extra_data", data);   // 第一个参数是键 用于后面从Intent取值
//                startActivity(intent);
//                返回数据给上一个活动
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                startActivityForResult(intent, 1);
//                活动的启动模式
                Intent intent = new Intent(FirstActivity.this, LitePalActivity.class);
                startActivity(intent);
//                SecondActivity.actionStart(FirstActivity.this, "data1", "data2");
            }
        });


    }

    // 得到返回的数据， 可能来自多个活动
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d(TAG, returnedData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}
