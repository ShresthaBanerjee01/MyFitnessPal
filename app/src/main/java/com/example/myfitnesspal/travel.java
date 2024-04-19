package com.example.myfitnesspal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfitnesspal.adapter.TopPlacesAdapter;
import com.example.myfitnesspal.model.TopPlacesData;

import java.util.ArrayList;
import java.util.List;

public class travel extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    // RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;
ImageView hotels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        //getSupportActionBar().hide();
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        hotels = findViewById(R.id.hotels);
hotels.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(travel.this, hotels.class);
        startActivity(intent);
    }
});
        // Now here we will add some dummy data in our model class

       /* List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("AM Lake", "India", "From $200", R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Nilgiri Hills", "India", "From $300", R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("AM Lake", "India", "From $200", R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Nilgiri Hills", "India", "From $300", R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("AM Lake", "India", "From $200", R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Nilgiri Hills", "India", "From $300", R.drawable.recentimage2));*/

        // setRecentRecycler(recentsDataList);

        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Hill Stations", R.drawable.mountain));
        topPlacesDataList.add(new TopPlacesData("Beaches", R.drawable.beach));
        topPlacesDataList.add(new TopPlacesData("Safaris",  R.drawable.safari));
        topPlacesDataList.add(new TopPlacesData("Magnificent Cities", R.drawable.skyscraper));
        topPlacesDataList.add(new TopPlacesData("Palaces & Forts", R.drawable.palace));
        topPlacesDataList.add(new TopPlacesData("Temples", R.drawable.temple));



        setTopPlacesRecycler(topPlacesDataList);
    }

    /*private void setRecentRecycler(List<RecentsData> recentsDataList) {

        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }*/

    private void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList) {

        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this, topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);

    }
}