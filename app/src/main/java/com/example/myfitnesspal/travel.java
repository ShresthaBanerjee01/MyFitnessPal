package com.example.myfitnesspal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myfitnesspal.adapter.TopPlacesAdapter;
import com.example.myfitnesspal.model.TopPlacesData;

import java.util.ArrayList;
import java.util.List;

public class travel extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
   // RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

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
        topPlacesDataList.add(new TopPlacesData("Hill Stations", "India", "20K-50K", R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Beaches", "India", "20K-30K", R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Safaris", "India", "20K-30K", R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Landscapes", "India", "30K-40K", R.drawable.topplaces));


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
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this, topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);

    }
}
