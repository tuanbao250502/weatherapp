package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.Adapters.FutureAdapter;
import com.example.myapplication.Adapters.HourlyAdapters;
import com.example.myapplication.Domains.FutureDomain;
import com.example.myapplication.Domains.Hourly;
import com.example.myapplication.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
    private RecyclerView.Adapter FutureAdapter;
    private  RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);

        initRecycleview();
        setVariable();
        
    }

    private void setVariable() {
        ConstraintLayout backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FutureActivity.this,MainActivity.class));
            }
        });
    }

    private void initRecycleview() {
        ArrayList<FutureDomain> items=new ArrayList<>();
        items.add(new FutureDomain("Sat","storm","storm",25,10));
        items.add(new FutureDomain("Sun","cloudy","cloudy",25,10));
        items.add(new FutureDomain("Mon","windy","windy",25,10));
        items.add(new FutureDomain("Tue","cloudy_sunny","cloudy_sunny",25,10));
        items.add(new FutureDomain("Wen","sunny","sunny",25,10));
        items.add(new FutureDomain("Thu","rain","rain",25,10));


        recyclerView=findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        FutureAdapter = new FutureAdapter(items);
        recyclerView.setAdapter(FutureAdapter);
    }
}