package com.example.smartport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FlightsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights);
        // Set status bar to transparent


        RecyclerView recyclerView = findViewById(R.id.rv_list);
        List <cardItem> mlist = new ArrayList<>();
        mlist.add(new cardItem(R.drawable.tenerife, "Ryanair", "Dublin to Tenerife", R.drawable.ryanair));
        mlist.add(new cardItem(R.drawable.paris, "Aer Lingus", "Dublin to Paris", R.drawable.aerlingus));
        mlist.add(new cardItem(R.drawable.london, "Ryanair", "Dublin to London", R.drawable.ryanair));
        mlist.add(new cardItem(R.drawable.newyork, "Aer Lingus", "Dublin to New York", R.drawable.aerlingus));

        Adapter adapter = new Adapter(this, mlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
