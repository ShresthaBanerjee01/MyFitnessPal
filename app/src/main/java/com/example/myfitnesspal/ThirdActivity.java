package com.example.myfitnesspal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    Button startBtn;
    TextView mTextView;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillIS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent= getIntent();
        String number=intent.getStringExtra("Value");

        int intNumber=Integer.parseInt(number);
        Log.i("message",number);
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
            case 6:
                setContentView(R.layout.activity_easypose);
                break;
            case 7:
                setContentView(R.layout.activity_halfpegionpose);
                break;
            case 8:
                setContentView(R.layout.activity_lowlunge);
                break;
            case 9:
                setContentView(R.layout.activity_upwardbow);
                break;
            case 10:
                setContentView(R.layout.activity_warrior);
                break;
            case 11:
                setContentView(R.layout.activity_warrior2);
                break;
        }
        startBtn=findViewById(R.id.startButton);
        mTextView=findViewById(R.id.time);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}