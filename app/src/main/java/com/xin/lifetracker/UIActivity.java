package com.xin.lifetracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class UIActivity extends AppCompatActivity {
    private static final String TAG = "UIActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, this.toString());
        setContentView(R.layout.activity_ui);
        Button button = (Button) findViewById(R.id.button_4);
        final ImageView imageView = (ImageView) findViewById(R.id.image_view_1);
        final EditText editText = (EditText) findViewById(R.id.edit_text_1);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String inputText = editText.getText().toString();
//                Toast.makeText(UIActivity.this, inputText, Toast.LENGTH_SHORT).show();
////                动态修改图片
////                imageView.setImageResource(R.drawable.img_1);
////                修改进度条可见性
//                if(progressBar.getVisibility() == View.GONE){
//                    progressBar.setVisibility(View.VISIBLE);
//                }
//                else{
//                    progressBar.setVisibility(View.GONE);
//                }
////                修改进度
//                int progress = progressBar.getProgress();
//                progress = progress + 10;
//                progressBar.setProgress(progress);
//                对话框
//                AlertDialog.Builder dialog = new AlertDialog.Builder(UIActivity.this);
//                dialog.setTitle("This is Dialog");
//                dialog.setCancelable(false);
//                dialog.setMessage("hello");
//                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                dialog.show();
//                进度条对话框
                ProgressDialog progressDialog = new ProgressDialog(UIActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading……");
                progressDialog.setCancelable(true);
                progressDialog.show();
            }
        });
    }
}
