package com.example.myfitnesspal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class yoga_select_pose extends AppCompatActivity
{
    int[] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_select_pose);

        newArray=new int[]{
                R.id.boat_pose, R.id.bow_pose, R.id.cobra_pose, R.id.crescent_lunge, R.id.downward_facing_dog, R.id.easy_pose,
                R.id.half_pegion_pose, R.id.low_lunge, R.id.upward_bow, R.id.warrior_pose, R.id.warrior_pose2
        };
    }

    public void ImageButtonClicked(View view)
    {
        int i=0;
        for(i=0;i<newArray.length;i++)
        {
            int value=i+1;
            Intent intent =new Intent(yoga_select_pose.this,ThirdActivity.class);
            intent.putExtra("Value",String.valueOf(value));
            startActivity(intent);
        }
    }
}