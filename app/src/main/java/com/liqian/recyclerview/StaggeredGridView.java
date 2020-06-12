package com.liqian.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.HashMap;

public class StaggeredGridView extends AppCompatActivity implements MyItemClickListener{

    private RecyclerView recyclerView;
    private Context mContext;
    private ArrayList<HashMap<String, Object>> itemList;
    private StaggeredGridViewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_st);


        initData();
        initView();
    }

    private void initData() {
        itemList = new ArrayList<HashMap<String, Object>>();/*在数组中存放数据*/
        for (int i = 0; i <= 10; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemText", "这是第" + i + "号位置");
            if(i % 2 == 0){
                map.put("dolphin",R.drawable.dolphin);
            }else{
                map.put("bear",R.drawable.bear);
            }
            itemList.add(map);

        }
    }


    private void initView() {
        recyclerView = findViewById(R.id.recycle_view_sg);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        adapter = new StaggeredGridViewAdapter(this,itemList);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);

    }




    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, (String)itemList.get(position).get("ItemText"), Toast.LENGTH_SHORT).show();
    }
}