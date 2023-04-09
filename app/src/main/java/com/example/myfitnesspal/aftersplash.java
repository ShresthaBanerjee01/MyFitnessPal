package com.example.myfitnesspal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class aftersplash extends AppCompatActivity {
    private Button bmi;
    private Button yoga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_splash);
        bmi=findViewById(R.id.button1);
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(aftersplash.this,bmi.class);
            }
        });
        yoga=findViewById(R.id.button2);
        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(aftersplash.this,yoga_select_pose.class);
                startActivity(intent);
            }
        });
    }
}