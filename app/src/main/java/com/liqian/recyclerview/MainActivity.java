package com.liqian.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button llBtn;
    private Button gridBtn;
    private Button sgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        llBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LinearRecyclerView.class);
                startActivity(intent);

            }
        });

        gridBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GridRecyclerView.class);
                startActivity(intent);

            }
        });

        sgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StaggeredGridView.class);
                startActivity(intent);

            }
        });


    }

    private void initView() {
        llBtn = findViewById(R.id.ll_Btn);

        gridBtn = findViewById(R.id.grid_btn);

        sgBtn = findViewById(R.id.sg_btn);
    }


}