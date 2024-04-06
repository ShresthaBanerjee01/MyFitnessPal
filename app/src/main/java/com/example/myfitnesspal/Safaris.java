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

public class Safaris extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    Button btnClick , btnClick1; LinearLayoutManager layoutManager;
    TopsubPlacesAdapter topsubPlacesAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safaris);
        getSupportActionBar().hide();
        List<TopsubPlacesData> topsubPlacesDataList = new ArrayList<>();
        topsubPlacesDataList.add(new TopsubPlacesData("Ranthambore National Park, Rajasthan",R.drawable.hillstation_tp,"Known for its thriving population of Bengal tigers, Ranthambore offers exhilarating safaris amidst ancient ruins and diverse wildlife. Best visited from October to March.\n" +
                "Tourist spots: Ranthambore Fort, Padam Talao, Trinetra Ganesh Temple.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Kaziranga National Park, Assam",R.drawable.hillstation_tp,"Kaziranga is renowned for its population of one-horned rhinoceroses and diverse birdlife, offering unique safaris amidst marshlands and grasslands. Best visited from November to April.\n" +
                "Tourist spots: Kaziranga Orchid and Biodiversity Park, Kaziranga National Orchid and Bio-diversity Park.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Jim Corbett National Park, Uttarakhand",R.drawable.hillstation_tp,"India's oldest national park, Jim Corbett, offers a chance to spot the majestic Bengal tiger along with diverse flora and fauna amidst Himalayan foothills. Best visited from November to June.\n" +
                "Tourist spots: Corbett Museum, Garjia Temple, Corbett Waterfall.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Bandhavgarh National Park, Madhya Pradesh",R.drawable.hillstation_tp,"Bandhavgarh boasts a high density of tigers and picturesque landscapes, providing thrilling safaris amidst dense forests and historic landmarks. Best visited from October to March.\n" +
                "Tourist spots: Bandhavgarh Fort, Shesh Shaiya, Baghel Museum.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Gir National Park, Gujarat",R.drawable.hillstation_tp,"Gir is the last abode of the Asiatic lion, offering safaris amidst dry deciduous forests and rugged terrain, along with rare bird species. Best visited from December to March.\n" +
                "Tourist spots: Devalia Safari Park, Gir Interpretation Zone, Kamleshwar Dam.","November"));
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