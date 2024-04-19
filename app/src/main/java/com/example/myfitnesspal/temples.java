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

public class temples extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    Button btnClick , btnClick1; LinearLayoutManager layoutManager;
    TopsubPlacesAdapter topsubPlacesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temples);
       // getSupportActionBar().hide();
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        List<TopsubPlacesData> topsubPlacesDataList = new ArrayList<>();
        topsubPlacesDataList.add(new TopsubPlacesData("Golden Temple, Punjab",R.drawable.hillstation_tp,"The Golden Temple is the holiest shrine of Sikhism, known for its stunning architecture, sacred pond, and spiritual ambiance, attracting millions of devotees and visitors every year. Best visited throughout the year, but especially during religious festivals.\n" +
                "Tourist spots: Jallianwala Bagh, Wagah Border, Partition Museum.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Tirupati Balaji Temple, Andhra Pradesh",R.drawable.hillstation_tp,"Tirupati Balaji Temple is one of the richest and most visited temples in the world, dedicated to Lord Venkateswara, attracting devotees seeking blessings and spiritual solace. Best visited during the Brahmotsavam festival in September.\n" +
                "Tourist spots: Sri Venkateswara Museum, Talakona Waterfalls, Sri Vari Museum.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Vaishno Devi Temple, Jammu and Kashmir",R.drawable.hillstation_tp,"Vaishno Devi Temple is a sacred Hindu shrine dedicated to Goddess Vaishno Devi, nestled in the Trikuta Mountains, offering a strenuous trek and divine blessings to millions of pilgrims annually. Best visited during Navratri and winter months from October to March.\n" +
                "Tourist spots: Bhairavnath Temple, Ardhkuwari Cave, Banganga Temple.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Kashi Vishwanath Temple, Uttar Pradesh",R.drawable.hillstation_tp,"Kashi Vishwanath Temple is one of the holiest Hindu temples dedicated to Lord Shiva, situated on the banks of the Ganges River in Varanasi, offering spiritual enlightenment and cultural heritage. Best visited during Mahashivratri and winter months from October to March.\n" +
                "Tourist spots: Dashashwamedh Ghat, Sarnath, Assi Ghat.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Meenakshi Temple, Tamil Nadu",R.drawable.hillstation_tp,"Meenakshi Temple is a magnificent example of Dravidian architecture, dedicated to Goddess Meenakshi and Lord Sundareswarar, adorned with vibrant sculptures and intricate carvings, attracting devotees and art lovers alike. Best visited during Chithirai Festival in April-May.\n" +
                "Tourist spots: Thirumalai Nayakkar Palace, Gandhi Memorial Museum, Vandiyur Mariamman Teppakulam.","November"));
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