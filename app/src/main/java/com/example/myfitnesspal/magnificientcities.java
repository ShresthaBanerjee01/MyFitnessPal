package com.example.myfitnesspal;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfitnesspal.adapter.TopsubPlacesAdapter;
import com.example.myfitnesspal.model.TopsubPlacesData;

import java.util.ArrayList;
import java.util.List;

public class magnificientcities extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    Button btnClick , btnClick1; LinearLayoutManager layoutManager;
    TopsubPlacesAdapter topsubPlacesAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magnificientcities);
        List<TopsubPlacesData> topsubPlacesDataList = new ArrayList<>();
        topsubPlacesDataList.add(new TopsubPlacesData("Hill Stations",R.drawable.hillstation_tp,"Be it on a honeymoon tour, vacation with family members or an outing with friends, fun and liveliness never ceases to stop in Pahalgam. It is in this scenic hill station, you can feel and experience all the true colours of the nature at its best.Be it on a honeymoon tour, vacation with family members or an outing with friends, fun and liveliness never ceases to stop in Pahalgam. It is in this scenic hill station, you can feel and experience all the true colours of the nature at its best.","October"));
        topsubPlacesDataList.add(new TopsubPlacesData("Hill Stations",R.drawable.hillstation_tp,"A","October"));
        topsubPlacesDataList.add(new TopsubPlacesData("Hill Stations",R.drawable.hillstation_tp,"B","October"));
        topsubPlacesDataList.add(new TopsubPlacesData("Hill Stations",R.drawable.hillstation_tp,"C","October"));
        topsubPlacesDataList.add(new TopsubPlacesData("Hill Stations",R.drawable.hillstation_tp,"D","October"));
        topsubPlacesDataList.add(new TopsubPlacesData("Hill Stations",R.drawable.hillstation_tp,"E","October"));
        setTopPlacesRecycler(topsubPlacesDataList);
        btnClick=findViewById(R.id.nextbtn);
        btnClick1=findViewById(R.id.prevbtn);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutManager.findLastCompletelyVisibleItemPosition() < (topsubPlacesAdapter.getItemCount() - 1)) {
                    layoutManager.scrollToPosition(layoutManager.findLastCompletelyVisibleItemPosition() + 1);
                }

            }
        });
        btnClick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (layoutManager.findLastCompletelyVisibleItemPosition() > 0) {
                    layoutManager.scrollToPosition(layoutManager.findLastCompletelyVisibleItemPosition() - 1);
                }
            }
        });
    }
    private void setTopPlacesRecycler(List<TopsubPlacesData> topPlacesDataList) {

        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        layoutManager = new LinearLayoutManager(this ,LinearLayoutManager.HORIZONTAL , false)
        {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

        };
        topPlacesRecycler.setLayoutManager(layoutManager);
        topsubPlacesAdapter = new TopsubPlacesAdapter(this, topPlacesDataList);
        topPlacesRecycler.setAdapter(topsubPlacesAdapter);

    }
}