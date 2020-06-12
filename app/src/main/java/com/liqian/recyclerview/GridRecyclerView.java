package com.liqian.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class GridRecyclerView extends AppCompatActivity implements MyItemClickListener {

    private RecyclerView recyclerView;
    private Context mContext;
    private ArrayList<HashMap<String, Object>> itemList;
    private GridRecyclerViewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        initData();
        initView();


    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler_view_g);
        recyclerView.setLayoutManager(new GridLayoutManager(GridRecyclerView.this,3));
        adapter = new GridRecyclerViewAdapter(this, itemList);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new MyDecoration(this));
    }

    private void initData() {
        itemList = new ArrayList<HashMap<String, Object>>();/*在数组中存放数据*/
        for (int i = 0; i < 30; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemText", "这是第" + i + "号位置");
            map.put("ItemImage",R.drawable.ic_baseline_ac_unit_24);
            itemList.add(map);
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, (String)itemList.get(position).get("ItemText"), Toast.LENGTH_SHORT).show();
    }

}