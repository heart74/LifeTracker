package com.xin.lifetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private static final String TAG = "ListViewActivity";
    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear",
            "Grape", "Pineapple", "Strawberry", "Cheery", "Mango", "Apple", "Banana", "Orange", "Watermelon", "Pear",
            "Grape", "Pineapple", "Strawberry", "Cheery", "Mango"};


    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, this.toString());
        setContentView(R.layout.activity_list_view);
//        借助适配器将数组中的数据传递给ListView
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                ListViewActivity.this, android.R.layout.simple_list_item_1, data);
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);

//        定制ListView的界面
        initFruits();  //初始化水果数据
        FruitAdapter adapter = new FruitAdapter(ListViewActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

//        点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListViewActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.pic_1);
            fruitList.add(apple);
            Fruit Banana = new Fruit("Banana", R.drawable.pic_2);
            fruitList.add(Banana);
            Fruit orange = new Fruit("orange", R.drawable.pic_1);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("watermelon", R.drawable.pic_2);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("pear", R.drawable.pic_1);
            fruitList.add(pear);
            Fruit grape = new Fruit("grape", R.drawable.pic_2);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("pineapple", R.drawable.pic_1);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("strawberry", R.drawable.pic_2);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("cherry", R.drawable.pic_1);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.pic_2);
            fruitList.add(mango);
        }
    }
}
