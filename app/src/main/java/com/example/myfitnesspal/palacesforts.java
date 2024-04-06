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

public class palacesforts extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    Button btnClick , btnClick1; LinearLayoutManager layoutManager;
    TopsubPlacesAdapter topsubPlacesAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palacesforts);
        getSupportActionBar().hide();
        List<TopsubPlacesData> topsubPlacesDataList = new ArrayList<>();
        topsubPlacesDataList.add(new TopsubPlacesData("Red Fort, Delhi",R.drawable.hillstation_tp,"Red Fort is an iconic UNESCO World Heritage Site, showcasing Mughal architecture with red sandstone walls, marble palaces, and intricate ornamentation, serving as the backdrop for India's Independence Day celebrations, offering a glimpse into Delhi's rich history. Best visited from October to March.\n" +
                "Tourist spots: Jama Masjid, Chandni Chowk, Raj Ghat, Qutub Minar.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Amber Fort, Rajasthan",R.drawable.hillstation_tp,"Amber Fort is a majestic hilltop fort and palace complex, showcasing Rajput architecture, intricate carvings, and stunning views of Maota Lake, offering a glimpse into Rajasthan's royal heritage. Best visited from October to March.\n" +
                "Tourist spots: Sheesh Mahal (Mirror Palace), Jaigarh Fort, Jal Mahal, Nahargarh Fort.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Mysore Palace, Karnataka",R.drawable.hillstation_tp,"Mysore Palace is a magnificent Indo-Saracenic architectural marvel, adorned with intricate carvings, ornate ceilings, and stained glass windows, showcasing the opulence of the Wadiyar dynasty, especially during the grand Dasara celebrations. Best visited from October to March.\n" +
                "Tourist spots: Brindavan Gardens, Chamundi Hill, St. Philomena's Cathedral, Mysore Zoo.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Junagarh Fort, Rajasthan",R.drawable.hillstation_tp,"Junagarh Fort is an imposing fortress showcasing a blend of Rajput, Gujarati, and Mughal architectural styles, featuring palaces, temples, and museums, offering a fascinating journey through Bikaner's history and culture. Best visited from October to March.\n" +
                "Tourist spots: Lalgarh Palace, Karni Mata Temple (Rat Temple), National Research Centre on Camel.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Jaisalmer Fort, Rajasthan",R.drawable.hillstation_tp,"Jaisalmer Fort is a massive sandstone fort rising majestically from the Thar Desert, housing palaces, temples, and havelis adorned with intricate carvings and balconies, offering a surreal experience of living history amidst golden sands. Best visited from October to March.\n" +
                "Tourist spots: Patwon ki Haveli, Gadisar Lake, Desert Safari, Sam Sand Dunes.","November"));
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