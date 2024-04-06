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
import com.example.myfitnesspal.model.Doctors;

import java.util.List;

public class doctorsAdapter extends RecyclerView.Adapter<doctorsAdapter.ViewHolder>{
    private List<Doctors> doctors;

    public doctorsAdapter(List<Doctors> doctors) {
        this.doctors = doctors;
    }

    public void setDoctors(List<Doctors> doctors) {
        this.doctors = doctors;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public doctorsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctor, parent, false);
        return new doctorsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull doctorsAdapter.ViewHolder holder, int position) {
        Doctors doctor = doctors.get(position);

        holder.hotelTextView.setText(doctor.getHotelName());
        holder.addressTextView.setText(doctor.getHotelAddress());
        holder.phoneTextView.setText(doctor.getphone());

        holder.websiteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = doctor.getwebsite();
                if(TextUtils.isEmpty(url))
                {
                    Toast.makeText(v.getContext(), "Website not present", Toast.LENGTH_SHORT).show();
                }else{
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                v.getContext().startActivity(intent);
            }}
        }); }

    @Override
    public int getItemCount() {
        return doctors.size();
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
