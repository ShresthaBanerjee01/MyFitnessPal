package com.example.myfitnesspal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
public class wellness extends AppCompatActivity {
    ImageButton pedo;
    ImageButton caloriecounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellness);
        //getSupportActionBar().hide();
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        pedo=(ImageButton)findViewById(R.id.pedometer);
        caloriecounter=(ImageButton)findViewById(R.id.caloriecount);
        pedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(wellness.this,pedometer.class);
                startActivity(intent1);
            }
        });
        caloriecounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(wellness.this,caloriecounter.class);
                startActivity(intent2);
            }
        });
    }
}