package com.example.myfitnesspal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bmiactivity extends AppCompatActivity {

yoga_select_pose b = new yoga_select_pose();

    TextView mbmidisplay,magedisplay,mweightdisplay,mheightdisplay,mbmicategory,mgender;
    Button mgotomain;
    Button mgotocontents;
    Button mgotoyoga;
    Button mgotocalorie;
    Intent intent;

    ImageView mimageview;
    String mbmi;
    String cateogory;
    float intbmi;

    String height;
    String weight;
    String age,gender;

    float intheight,intweight;int intage;

    RelativeLayout mbackground;

    @SuppressLint({"ResourceAsColor", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        /*getSupportActionBar().setElevation(0);
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        ///   ColorDrawable colorDrawable2=new ColorDrawable(Color.parseColor("#1E1D1D"));
        //      getSupportActionBar().setBackgroundDrawable(colorDrawable);


        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");*/
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        intent=getIntent();
        mbmidisplay=findViewById(R.id.bmidisplay);
        //    magedisplay=findViewById(R.id.agedisplay);
        //    mweightdisplay=findViewById(R.id.weightdisplay);
        mbmicategory = findViewById(R.id.bmicategorydispaly);
        mgotomain=findViewById(R.id.gotomain);
       mgotocontents=findViewById(R.id.gotopedo);
       mgotoyoga=findViewById(R.id.gotoyoga);
       mgotocalorie=findViewById(R.id.gotocalorie);

        mimageview=findViewById(R.id.imageview);

        //   mheightdisplay=findViewById(R.id.heightdisplay);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentlayout);


        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");
        age=intent.getStringExtra("age");
        gender=intent.getStringExtra("gender");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);
        intage=Integer.parseInt(age);

        intheight=intheight/100;
        intbmi=intweight/(intheight*intheight);


        mbmi=Float.toString(intbmi);
        System.out.println(mbmi);
if(intage>18){
        if(intbmi<16)
        {
            mbmicategory.setText("Severe Thinness");
            //   mbackground.setBackgroundColor(Color.GRAY);
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
            //  mimageview.setBackground(colorDrawable2);

        }
        else if(intbmi<16.9 && intbmi>16)
        {
            mbmicategory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(R.color.halfwarn);
            mimageview.setImageResource(R.drawable.warning);
            //   mimageview.setBackground(colorDrawable2);

        }
        else if(intbmi<18.4 && intbmi>17)
        {
            mbmicategory.setText("Mild Thinness");
            mbackground.setBackgroundColor(R.color.halfwarn);
            mimageview.setImageResource(R.drawable.warning);
            //   mimageview.setBackground(colorDrawable2);
        }
        else if(intbmi<24.9 && intbmi>18.5 )
        {
            mbmicategory.setText("Normal");
            mimageview.setImageResource(R.drawable.ok);
            // mbackground.setBackgroundColor(Color.YELLOW);
            //  mimageview.setBackground(colorDrawable2);
        }
        else if(intbmi <29.9 && intbmi>25)
        {
            mbmicategory.setText("Overweight");
            mbackground.setBackgroundColor(R.color.halfwarn);
            mimageview.setImageResource(R.drawable.warning);
            //mimageview.setBackground(colorDrawable2);
        }
        else if(intbmi<34.9 && intbmi>30)
        {
            mbmicategory.setText("Obese Class I");
            mbackground.setBackgroundColor(R.color.halfwarn);
            mimageview.setImageResource(R.drawable.warning);
            //  mimageview.setBackground(colorDrawable2);
        }
        else
        {
            mbmicategory.setText("Obese Class II");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
            //  mimageview.setBackground(colorDrawable2);
        }
}
else
{
    String bmiInterpretation = interpretBMI(intage, gender, intbmi);
    if(bmiInterpretation.equals("Uw"))
    {
        mbmicategory.setText("Underweight");

        mbackground.setBackgroundColor(Color.RED);
        mimageview.setImageResource(R.drawable.crosss);
    }
    else if(bmiInterpretation.equals("Nw"))
    {
        mbmicategory.setText("Normal");
        mimageview.setImageResource(R.drawable.ok);
    }
    else if (bmiInterpretation.equals("Ow"))
    {
        mbmicategory.setText("Overweight");
        mbackground.setBackgroundColor(R.color.halfwarn);
        mimageview.setImageResource(R.drawable.warning);
    }
    else
    {
        mbmicategory.setText("Obesity");
        mbackground.setBackgroundColor(Color.RED);
        mimageview.setImageResource(R.drawable.crosss);

    }
}



        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);


        mgotomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),aftersplash.class);
                startActivity(intent1);
            }
        });
      mgotocontents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getApplicationContext(),pedometer.class);
                startActivity(intent2);
            }
        });

        mgotoyoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(),yoga_select_pose.class);
                startActivity(intent1);
            }
        });

      mgotocalorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(),caloriecounter.class);
                startActivity(intent1);
            }
        });

    }
    private static String interpretBMI(int age, String sex, float bmi) {


        // BMI percentiles based on age and sex
        double[][] bmiPercentilesmale = {
                // Age in years: 2-18
                // Boys: 5th,85th,95th percentiles for 2 to 4
                {14.2, 17.4, 18.3}, // Age 2
                {13.7,17.0,17.8}, // Age 3
                {13.4,16.7,17.6},// Age 4
                {12.4,15.7,17.5},// Age 5
                {12.5,16.0,	17.8},// Age 6
                {12.6,16.3,18.2},// Age 7
                {12.8,16.7,18.8},// Age 8
                {13.0,17.3,	19.6},// Age 9
                {13.2,18.0,	20.5},// Age 10
                {13.5,18.7,21.5},// Age 11
                {13.8,19.5,22.6},// Age 12
                {14.0,20.2,23.4},// Age 13
                {14.3,20.8,24.2},// Age 14
                {14.7,21.4,24.9},// Age 15
                {15.1,22.0,25.5},// Age 16
                {15.6,22.6,26.0},// Age 17
                {16.2,23.2,26.6}// Age 18
        };
        double[][] bmiPercentilesfemale = {
                // Age in years: 2-18
                // Girls: 5th,85th,95th percentiles for 2-4 and 5th ,
                {13.7, 17.2, 18.1}, // Age 2
                {13.5,16.9,17.8}, // Age 3
                {13.2,16.8,17.9},//Age 4
                {12.1,15.5,18.0},// Age 5
                {12.2,15.9,18.6},// Age 6
                {12.4,16.4,19.3},// Age 7
                {12.6,16.9,20.1},// Age 8
                {12.8,17.6,21.0},// Age 9
                {13.1,18.4,21.9},// Age 10
                {13.4,19.3,23.0},// Age 11
                {13.9,20.2,24.1},// Age 12
                {14.4,21.1,25.2},// Age 13
                {14.9,21.8,25.9},// Age 14
                {15.2,22.3,26.3},// Age 15
                {15.6,22.6,26.5},// Age 16
                {16.0,22.9,26.7},// Age 17
                {16.3,23.2,26.8}// Age 18

        };

        int ageIndexmale = Math.min(Math.max(age - 2, 0), bmiPercentilesmale.length - 1);
        int ageIndexfemale = Math.min(Math.max(age - 2, 0), bmiPercentilesfemale.length - 1);// Adjust for array indexing
        String cate;

        if (sex.equals("Male")) {
            // Boys
            cate = getPercentileIndex(bmi, bmiPercentilesmale[ageIndexmale]);
        } else  {
            // Girls
            cate = getPercentileIndex(bmi, bmiPercentilesfemale[ageIndexfemale]);
        }
return cate;
        // Interpretation based on BMI percentiles

    }

    private static String getPercentileIndex(double bmi, double[] percentiles) {
        String r;
        if(bmi<percentiles[0])
        {
            r="Uw";
        }
        else if(bmi>=percentiles[0]&&bmi<percentiles[1])
        {
            r="Nw";
        }
        else if (bmi>=percentiles[1]&&bmi<percentiles[2]) {
           r ="Ow";
        }
        else {
            r="Ob";
        }
        return r;
    }
}