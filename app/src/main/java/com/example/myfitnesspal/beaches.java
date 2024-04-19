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

public class beaches extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    Button btnClick , btnClick1; LinearLayoutManager layoutManager;
    TopsubPlacesAdapter topsubPlacesAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beaches);
      //  getSupportActionBar().hide();
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        List<TopsubPlacesData> topsubPlacesDataList = new ArrayList<>();
        topsubPlacesDataList.add(new TopsubPlacesData("Radhanagar Beach, Andaman and Nicobar Islands",R.drawable.hillstation_tp,"Radhanagar Beach is known for its powdery white sand, crystal-clear waters, and stunning sunset views, offering a serene escape amidst nature's splendor. Best visited from November to April.\n" +
                "Tourist spots: Elephant Beach, Cellular Jail, Ross Island, Neil Island, Mahatma Gandhi Marine National Park.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Palolem Beach, Goa",R.drawable.hillstation_tp,"Palolem Beach is famous for its crescent-shaped coastline, turquoise waters, and laid-back atmosphere, offering a perfect escape for beach lovers and backpackers. Best visited from November to February.\n" +
                "Tourist spots: Butterfly Beach, Agonda Beach, Cabo de Rama Fort, Cotigao Wildlife Sanctuary, Dudhsagar Waterfalls.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Varkala Beach, Kerala",R.drawable.hillstation_tp,"Varkala Beach is famous for its dramatic cliffs, golden sands, and natural spring waters, providing a tranquil setting for relaxation and spiritual rejuvenation. Best visited from September to March.\n" +
                "Tourist spots: Varkala Cliff, Sivagiri Mutt, Janardanaswamy Temple, Kappil Lake, Anjengo Fort.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Agonda Beach, Goa",R.drawable.hillstation_tp,"Agonda Beach in Goa is known for its pristine shoreline, tranquil ambiance, and abundant palm trees, offering a serene escape amidst nature's beauty. Best visited from November to February, it's perfect for unwinding and enjoying breathtaking sunsets over the Arabian Sea.\n" +
                "Near Agonda Beach in Goa, tourists can explore Butterfly Beach, Cabo de Rama Fort, Cotigao Wildlife Sanctuary, and Dudhsagar Waterfalls.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Marari Beach, Kerala",R.drawable.hillstation_tp,"Marari Beach offers serene backwaters, coconut palm groves, and pristine sands, providing a secluded retreat away from the hustle and bustle of city life. Best visited from November to March.\n" +
                "Tourist spots: Mararikulam Shiva Temple, Alappuzha Beach, Alleppey Backwaters, St. Andrew's Basilica Arthunkal.","November"));
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