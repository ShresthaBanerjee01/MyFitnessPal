package com.example.myfitnesspal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class doctors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);
        getSupportActionBar().hide();
        ImageView nutritionistText = findViewById(R.id.nutritionistImage);
        ImageView psychiatristText = findViewById(R.id.psychiatristImage);
        ImageView physiotherapistText = findViewById(R.id.physiotherapistImage);

        nutritionistText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(doctors.this, nutritionist.class));
            }
        });

        psychiatristText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(doctors.this, psychiatrist.class));
            }
        });

        physiotherapistText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(doctors.this, physiotherapist.class));
            }
        });
    }
}