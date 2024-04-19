package com.example.myfitnesspal;

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

public class hillstations extends AppCompatActivity {
    RecyclerView recentRecycler, topPlacesRecycler;
    Button btnClick , btnClick1; LinearLayoutManager layoutManager;
    TopsubPlacesAdapter topsubPlacesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hillstations);
        //getSupportActionBar().hide();
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        List<TopsubPlacesData> topsubPlacesDataList = new ArrayList<>();
        topsubPlacesDataList.add(new TopsubPlacesData("Manali, Himachal Pradesh",R.drawable.hillstation_tp,"Manali is a popular destination nestled in the Himalayas, offering stunning landscapes, adventure sports, and vibrant culture. Best visited from March to June and September to October.\n" + "Tourist spots: Solang Valley, Rohtang Pass, Hadimba Temple, Old Manali, Manu Temple.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Darjeeling, West Bengal",R.drawable.hillstation_tp,"Famous for its tea plantations and panoramic views of the Himalayas, Darjeeling offers a serene retreat amidst nature. Best visited from March to May and September to November.\n" +
                "Tourist spots: Tiger Hill, Batasia Loop, Darjeeling Himalayan Railway, Peace Pagoda, Padmaja Naidu Himalayan Zoological Park.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Shimla, Himachal Pradesh",R.drawable.hillstation_tp,"Known as the \"Queen of Hill Stations,\" Shimla offers colonial charm with snow-capped mountains and lush greenery. Best visited from March to June and September to November.\n" +
                "Tourist spots: The Ridge, Mall Road, Jakhu Temple, Kufri, Chail Palace.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Ooty, Tamil Nadu",R.drawable.hillstation_tp,"Nestled in the Nilgiri Hills, Ooty is known for its pleasant weather, lush greenery, and charming colonial architecture, making it a popular hill station getaway. Best visited from March to June and September to November.\n" +
                "Tourist spots: Botanical Gardens, Ooty Lake, Doddabetta Peak, Rose Garden, Nilgiri Mountain Railway.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Munnar, Kerala",R.drawable.hillstation_tp,"Munnar is renowned for its sprawling tea gardens, misty mountains, and diverse wildlife, providing a tranquil escape in God's Own Country. Best visited from September to May.\n" +
                "Tourist spots: Eravikulam National Park, Mattupetty Dam, Tea Museum, Anamudi Peak, Kundala Lake.","November"));
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