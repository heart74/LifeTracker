package com.xin.lifetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.List;

public class LitePalActivity extends AppCompatActivity {
    private static final String TAG = "LitePalActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal);
        Button createDatabase = (Button) findViewById(R.id.create_database_pal);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
            }
        });
        Button addData = (Button) findViewById(R.id.add_data_pal);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("Unknow");
                book.save();
            }
        });
        Button updateData = (Button) findViewById(R.id.update_data_pal);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                //                如果对象已存储则更新，限制较大
                book.setName("The Lost Symbol");
                book.setAuthor("Dan Brown");
                book.setPages(510);
                book.setPrice(19.95);
                book.setPress("Unknow");
                book.save();
//                book.setPrice(10.99);
//                book.save();
//                另外一种更新方法
                book.setPress("Anchor");
                book.setPrice(6.66);
                book.updateAll("name = ? and author = ?", "The Lost Symbol", "Dan Brown");
//                将数据更新成默认值 比如int:0, String: null, boolean:false
//                Book book = new Book();
//                book.setToDefault();
//                book.updateAll();  //不指定约束条件对所有数据都生效
            }
        });
        Button deleteData = (Button) findViewById(R.id.delete_data_pal);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.deleteAll(Book.class, "price < ?", "15");
            }
        });
        Button queryData = (Button) findViewById(R.id.query_data_pal);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = LitePal.findAll(Book.class);
                for (Book book : books) {
                    Log.d(TAG, "book name is " + book.getName());
                    Log.d(TAG, "book author is " + book.getAuthor());
                    Log.d(TAG, "book pages is " + book.getPages());
                    Log.d(TAG, "book price is " + book.getPrice());
                    Log.d(TAG, "book press is " + book.getPress());
//                    LitePal.findLast(Book.class);
//                    LitePal.findFirst(Book.class);
//                    LitePal.select("name", "author").find(Book.class);   // 只查name和author
//                    LitePal.where("pages > ?", "400").find(Book.class); // 指定查询的约束条件
//                    LitePal.order("price desc").find(Book.class);
//                    LitePal.limit(3).offset(1).find(Book.class)  // 只查表的前三+1条数据 offset为偏移量
//                    以上可以组合
//                    Cursor c = LitePal.findBySQL("select * from Book where pages > ? and
//                    price < ?", "400", "20");   // 使用SQL   需要有SQLiteDatabase对象

                }
            }
        });
    }
}
