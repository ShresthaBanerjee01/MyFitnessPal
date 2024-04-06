package com.example.myfitnesspal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfitnesspal.R;
import com.example.myfitnesspal.model.TopsubPlacesData;

import java.util.List;

public class TopsubPlacesAdapter extends RecyclerView.Adapter<TopsubPlacesAdapter.TopPlacesViewHolder>{
    Context context;
    List<TopsubPlacesData> topsubPlacesDataList;
    public TopsubPlacesAdapter(Context context, List<TopsubPlacesData> topsubPlacesDataList) {
        this.context = context;
        this.topsubPlacesDataList = topsubPlacesDataList;

    }
    @NonNull
    @Override
    public TopsubPlacesAdapter.TopPlacesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.top_subplaces_row_item, parent, false);

        // here we create a recyclerview row item layout file
        return new TopsubPlacesAdapter.TopPlacesViewHolder(view);
    }
    public void onBindViewHolder(@NonNull TopsubPlacesAdapter.TopPlacesViewHolder holder, int position) {
        final TopsubPlacesData temp = topsubPlacesDataList.get(position);

        holder.placeName.setText(topsubPlacesDataList.get(position).getPlaceName());
        holder.placeDes.setText(topsubPlacesDataList.get(position).getPlaceDes());
       // holder.placeImage.setImageResource(topsubPlacesDataList.get(position).getImageUrl());
        //holder.bestseason.setText(topsubPlacesDataList.get(position).getBestSeason());
        }
    @Override
    public int getItemCount() {
            return topsubPlacesDataList != null ? topsubPlacesDataList.size() : 0;

    }

    public static final class TopPlacesViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName, placeDes, bestseason;


        public TopPlacesViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.placename);
            placeDes=itemView.findViewById(R.id.place_des);
            bestseason=itemView.findViewById(R.id.bestseason);

        }
    }
}
