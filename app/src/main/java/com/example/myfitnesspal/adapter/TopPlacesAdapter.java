package com.example.myfitnesspal.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfitnesspal.R;
import com.example.myfitnesspal.Safaris;
import com.example.myfitnesspal.beaches;
import com.example.myfitnesspal.hillstations;
import com.example.myfitnesspal.magnificientcities;
import com.example.myfitnesspal.model.TopPlacesData;
import com.example.myfitnesspal.palacesforts;
import com.example.myfitnesspal.temples;

import java.util.List;

public class TopPlacesAdapter extends RecyclerView.Adapter<TopPlacesAdapter.TopPlacesViewHolder> {

    Context context;
    List<TopPlacesData> topPlacesDataList;

    public TopPlacesAdapter(Context context, List<TopPlacesData> topPlacesDataList) {
        this.context = context;
        this.topPlacesDataList = topPlacesDataList;

    }

    @NonNull
    @Override
    public TopPlacesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.top_places_row_item, parent, false);

        // here we create a recyclerview row item layout file
        return new TopPlacesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopPlacesViewHolder holder, int position) {
        final TopPlacesData temp = topPlacesDataList.get(position);

        holder.placeName.setText(topPlacesDataList.get(position).getPlaceName());

        holder.placeImage.setImageResource(topPlacesDataList.get(position).getImageUrl());

        holder.placeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
if(holder.getAdapterPosition()==0){
                Intent hill = new Intent(context, hillstations.class);
                context.startActivity(hill);}
                if(holder.getAdapterPosition()==1){
                Intent beach = new Intent(context, beaches.class);
                context.startActivity(beach);}
                if(holder.getAdapterPosition()==2){
                    Intent hill = new Intent(context, Safaris.class);
                    context.startActivity(hill);}
                if(holder.getAdapterPosition()==3){
                    Intent beach = new Intent(context, magnificientcities.class);
                    context.startActivity(beach);}
                if(holder.getAdapterPosition()==4){
                    Intent hill = new Intent(context, palacesforts.class);
                    context.startActivity(hill);}
                if(holder.getAdapterPosition()==5){
                    Intent beach = new Intent(context, temples.class);
                    context.startActivity(beach);}
            }
        });
    }

    @Override
    public int getItemCount() {
        return topPlacesDataList.size();
    }

    public static final class TopPlacesViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName, countryName, price;

        public TopPlacesViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.place_name);


        }
    }
}
