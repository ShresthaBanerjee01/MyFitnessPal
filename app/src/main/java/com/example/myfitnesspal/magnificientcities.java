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
        getSupportActionBar().hide();
        List<TopsubPlacesData> topsubPlacesDataList = new ArrayList<>();
        topsubPlacesDataList.add(new TopsubPlacesData("Jaipur, Rajasthan",R.drawable.hillstation_tp,"Known as the Pink City, Jaipur is famous for its majestic forts, vibrant bazaars, and rich cultural heritage, offering a glimpse into Rajasthan's royal past. Best visited from October to March.\n" +
                "Tourist spots: Amber Fort, City Palace, Hawa Mahal, Jantar Mantar, Nahargarh Fort.\n","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Varanasi, Uttar Pradesh",R.drawable.hillstation_tp,"Varanasi, one of the oldest continuously inhabited cities in the world, is a spiritual hub on the banks of the sacred Ganges River, known for its ghats, temples, and vibrant cultural traditions. Best visited from October to March.\n" +
                "Tourist spots: Dashashwamedh Ghat, Kashi Vishwanath Temple, Sarnath, Manikarnika Ghat, Assi Ghat.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Udaipur, Rajasthan",R.drawable.hillstation_tp,"Udaipur, often referred to as the Venice of the East, is famed for its enchanting lakes, palaces, and romantic ambiance, offering a picturesque setting for a royal experience. Best visited from September to March.\n" +
                "Tourist spots: City Palace, Lake Pichola, Jag Mandir, Fateh Sagar Lake, Saheliyon ki Bari.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Mumbai, Maharashtra",R.drawable.hillstation_tp,"Mumbai, the bustling metropolis and financial capital of India, is a melting pot of cultures, offering a vibrant nightlife, colonial architecture, and iconic landmarks along the Arabian Sea coast. Best visited from October to March.\n" +
                "Tourist spots: Gateway of India, Marine Drive, Elephanta Caves, Chhatrapati Shivaji Maharaj Terminus, Juhu Beach.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Kolkata, West Bengal",R.drawable.hillstation_tp,"Kolkata, the cultural capital of India, exudes colonial charm with its grand architecture, literary heritage, and artistic fervor, offering a glimpse into the city's rich history and vibrant culture. Best visited from October to March.\n" +
                "Tourist spots: Victoria Memorial, Howrah Bridge, Belur Math, Dakshineswar Kali Temple, Indian Museum.","November"));
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