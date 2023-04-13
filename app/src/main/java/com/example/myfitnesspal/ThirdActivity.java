package com.example.myfitnesspal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent= getIntent();
        String number=intent.getStringExtra("Value");

        int intNumber=Integer.parseInt(number);
        switch (intNumber)
        {
            case 1:
                setContentView(R.layout.activity_boat);
                break;
            case 2:
                setContentView(R.layout.activity_bow);
                break;
            case 3:
                setContentView(R.layout.activity_cobra);
                break;
            case 4:
                setContentView(R.layout.activity_crescent);
                break;
            case 5:
                setContentView(R.layout.activity_downwardfacingdog);
                break;
        }


        setContentView(R.layout.activity_boat);
    }
}