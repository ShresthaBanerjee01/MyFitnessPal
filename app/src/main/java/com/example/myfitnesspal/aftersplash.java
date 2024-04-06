package com.example.myfitnesspal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class aftersplash extends AppCompatActivity {
    ImageButton bmi;
    ImageButton yoga;
    ImageButton travel;
    ImageButton wellness;
    ImageButton doctors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_splash);
        getSupportActionBar().hide();
        bmi=(ImageButton) findViewById(R.id.Button1);
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(aftersplash.this, bmi.class);
                startActivity(intent1);
            }
        });
        yoga=(ImageButton) findViewById(R.id.Button2);
        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(aftersplash.this,yoga_select_pose.class);
                startActivity(intent3);
            }
        });
        travel=findViewById(R.id.Button3);
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(aftersplash.this,travel.class);
                startActivity(intent2);
            }
        });
        wellness=findViewById(R.id.Button4);
        wellness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(aftersplash.this,wellness.class);
                startActivity(intent4);
            }
        });
        doctors=findViewById(R.id.Button5);
        doctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(aftersplash.this,doctors.class);
                startActivity(intent5);
            }
        });
    }
}