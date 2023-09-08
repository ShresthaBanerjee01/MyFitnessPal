package com.example.myfitnesspal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
public class wellness extends AppCompatActivity {
    ImageButton pedo;
    ImageButton caloriecounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellness);

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