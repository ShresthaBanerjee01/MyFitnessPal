package com.example.myfitnesspal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class aftersplash extends AppCompatActivity {
     Button bmi;
     Button yoga;
     Button travel;
    Button wellness;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_splash);
        bmi=findViewById(R.id.button1);
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(aftersplash.this, bmi.class);
                startActivity(intent1);
            }
        });
        yoga=findViewById(R.id.button2);
        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(aftersplash.this,yoga_select_pose.class);
                startActivity(intent3);
            }
        });
        travel=findViewById(R.id.button3);
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(aftersplash.this,travel.class);
                startActivity(intent2);
            }
        });
        wellness=findViewById(R.id.button4);
        wellness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(aftersplash.this,wellness.class);
                startActivity(intent4);
            }
        });
    }
}