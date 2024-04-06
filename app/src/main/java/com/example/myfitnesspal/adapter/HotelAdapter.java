package com.example.myfitnesspal.adapter;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfitnesspal.R;
import com.example.myfitnesspal.model.Hotel;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {

    private List<Hotel> hotels;

    public HotelAdapter(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hotel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hotel hotel = hotels.get(position);

        holder.hotelTextView.setText(hotel.getHotelName());
        holder.addressTextView.setText(hotel.getHotelAddress());
        holder.phoneTextView.setText(hotel.getphone());

        holder.websiteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = hotel.getwebsite();
                if(TextUtils.isEmpty(url))
                {
                    Toast.makeText(v.getContext(), "Website not present", Toast.LENGTH_SHORT).show();
                }else{
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                v.getContext().startActivity(intent);}
            }
        }); }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView placeTextView, hotelTextView, addressTextView , phoneTextView, websiteTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            placeTextView = itemView.findViewById(R.id.placeTextView);
            hotelTextView = itemView.findViewById(R.id.hotelTextView);
            addressTextView = itemView.findViewById(R.id.addressTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
            websiteTextView = itemView.findViewById(R.id.websiteTextView);        }
    }
}
