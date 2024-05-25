package com.example.myapplication.Activities;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.LinearLayoutCompat;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.TextView;

        import com.example.myapplication.Adapters.HourlyAdapters;
        import com.example.myapplication.Domains.Hourly;
        import com.example.myapplication.R;

        import java.lang.reflect.Array;
        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterHourly;
    private  RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycleview();
        setVariable();
    }

    private void setVariable() {
        TextView next7day=findViewById(R.id.nextBtn);
        next7day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FutureActivity.class));
            }
        });
    }

    private void initRecycleview() {
        ArrayList<Hourly> items=new ArrayList<>();
        items.add(new Hourly("9 pm",28,"cloudy"));
        items.add(new Hourly("11 pm",28,"sun"));
        items.add(new Hourly("12 pm",28,"wind"));
        items.add(new Hourly("1 am",28,"rainy"));
        items.add(new Hourly("2 am",28,"storm"));

        recyclerView=findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterHourly= new HourlyAdapters(items);
        recyclerView.setAdapter(adapterHourly);
    }
}