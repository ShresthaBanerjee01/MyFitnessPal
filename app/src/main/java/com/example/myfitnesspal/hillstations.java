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
        List<TopsubPlacesData> topsubPlacesDataList = new ArrayList<>();
        topsubPlacesDataList.add(new TopsubPlacesData("Leh Ladakh – Land of the High Passes",R.drawable.hillstation_tp,"Counted among the highest hill stations in India, a trip to Leh Ladakh is also one of the most famous. From driving in the world’s highest passes to soaking in the scenic beauty, there are a lot of reasons why Leh Ladakh is counted among the most famous hill stations in India. You can opt for a simple tour package that takes care of your travel and accommodation or you can plan an adventurous bike ride to the destination. Some of the popular places you can check out include Pangong Lake, Royal Leh Palace, Tso Moriri, the Magnetic Hill, Zanskar Valley, and much more.","October"));
        topsubPlacesDataList.add(new TopsubPlacesData("Nainital, Uttarakhand – The Hill Station of Lakes",R.drawable.hillstation_tp,"A small town in Uttarakhand’s Kumaon range, Nainital is one of the most popular honeymoon destinations in India. It is also known as the ‘Lake District of India’ and has something to offer for everyone, from families and couples to solo travellers. Some of the activities that may be enjoyed at this famous hill station in India include rock-climbing, canoeing, kayaking, horse riding and parasailing. The tourist spots in Nainital include Naini Peak, Snow View, Tiffin Top, and Naini Lake. The place also has small markets that are always buzzing with activity and streets that lead to beautiful forest patches.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Manali, Himachal Pradesh – Valley of the Gods",R.drawable.hillstation_tp,"The Kullu Valley offers mesmerizing views of scenic snow-clad peaks and lush forests as well as a number of activities to enjoy. On the list of hill stations in India that are most popular, Manali has a touristy vibe to it right from the moment you enter. Heli-skiing, camping, trekking, rock-climbing, and trekking are some of the adventure sports you can partake in here; and a number of Tibetan monasteries, Rohtang Pass, and Solang Valley are the tourist destinations that you can visit in Manali.","October"));
        topsubPlacesDataList.add(new TopsubPlacesData("Mussoorie, Uttarakhand – The Queen of the Hill Stations",R.drawable.hillstation_tp,"Mussoorie is one of the most-visited hill stations in India, and is famous for being the home of Ruskin Bond. Located at a distance of about 34 kilometres from Dehradun, the hill station offers amazing views of the Himalayas to the north, and of the Doon valley towards the south. Mussoorie has been specially developed for tourism and is full of places to visit and things to do. You could take a cable car ride to Gun Hill, walk along Mall road, or head towards the highest point, Lal Tibba, for some beautiful views of the place.","November"));
        topsubPlacesDataList.add(new TopsubPlacesData("Gulmarg, Jammu and Kashmir – Skiing Destination",R.drawable.hillstation_tp,"Gulmarg is home to the highest gondola in the world, which runs up to an astounding height of 4000 metres above ground. In the summers, this hill station becomes a paradise for trekkers, and the main tourist activities at Gulmarg include skiing and snowboarding, while the main market is full of jewellery, pashmina, and many other unique souvenirs that you can take home with you.","January"));
        topsubPlacesDataList.add(new TopsubPlacesData("Darjeeling, West Bengal – The Hill Station of Tea Plantations",R.drawable.hillstation_tp,"Darjeeling offers magnificent views of the Kanchenjunga and several other hills. This is one of the hill stations in India that’s famous for its large tea estates. In fact, most tour packages available for Darjeeling include tours of tea plantations as well. Home to several waterfalls, another very famous feature of Darjeeling is its Toy Train which makes for a very memorable ride. Other than that, the popular tourist attractions at the hill station include Observatory Hill, Ghoom Monastery, and Senchal Lake.","March"));
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