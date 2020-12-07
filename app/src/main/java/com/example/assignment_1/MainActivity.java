package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        RecyclerView recyclerView = findViewById(R.id.rclrview);

        //Decoration - Divider between items
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        MyWeatherAdapter weatherAdapter = new MyWeatherAdapter(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(weatherAdapter);
    }
}