package com.xin.lifetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {


    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        用于指定RecyclerView的布局方式
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        水平排列
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        瀑布流布局
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerFruitAdapter adapter = new RecyclerFruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);

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
