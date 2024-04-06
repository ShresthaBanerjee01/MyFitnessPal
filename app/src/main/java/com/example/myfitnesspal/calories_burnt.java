package com.example.myfitnesspal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
public class calories_burnt extends AppCompatActivity {
    EditText  weightInput, timeInput;
    RadioGroup activityGroup, paceGroup;
    Button calculateButton;
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories_burnt);
        getSupportActionBar().hide();
        weightInput = findViewById(R.id.weightInput);
        timeInput = findViewById(R.id.timeInput);
        activityGroup = findViewById(R.id.activityGroup);
        paceGroup = findViewById(R.id.paceGroup);
        calculateButton = findViewById(R.id.calculateButton);
        resultText = findViewById(R.id.resultText);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                calculateCalories();
            }
        });
    }
    private void calculateCalories() {
        String weightStr = weightInput.getText().toString();
        String timeStr = timeInput.getText().toString();
        if (weightStr.isEmpty() || timeStr.isEmpty() || activityGroup.getCheckedRadioButtonId() == -1 || paceGroup.getCheckedRadioButtonId() == -1) {
            // Show toast message
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show();
            return;
        }
        double weight = Double.parseDouble(weightStr);
        int time = Integer.parseInt(timeStr);

        int activityId = activityGroup.getCheckedRadioButtonId();
        RadioButton activityButton = findViewById(activityId);
        int paceId = paceGroup.getCheckedRadioButtonId();
        RadioButton paceButton = findViewById(paceId);
        double paceMultiplier = getPaceMultiplier(activityButton.getText().toString(), paceButton.getText().toString());

        double caloriesBurnt = (paceMultiplier * 3.5 * weight * time) / 200 ;

        DecimalFormat df = new DecimalFormat("#.##");
        String CaloriesBurnt = df.format(caloriesBurnt);
        resultText.setText(CaloriesBurnt+" calories");

    }
    private double getPaceMultiplier(String activity, String pace) {
        // Implement your pace multiplier lookup logic here
        // Return pace multiplier based on the activity and pace
        // Example:
        switch (activity) {
            case "Walking":
                switch (pace) {
                    case "Slow":
                        return 2.5;
                    case "Moderate":
                        return 3.3;
                    case "Fast":
                        return 3.8;
                    case "Very Fast":
                        return 5.0;
                    default:
                        return 0.0;
                }
            case "Jogging":
                switch (pace) {
                    case "Slow":
                        return 6.0;
                    case "Moderate":
                        return 7.0;
                    case "Fast":
                        return 8.0;
                    case "Very Fast":
                        return 8.8;
                    default:
                        return 0.0;
                }
            case "Running":
                switch (pace) {
                    case "Slow":
                        return 11.0;
                    case "Moderate":
                        return 12.5;
                    case "Fast":
                        return 14.0;
                    case "Very Fast":
                        return 16.0;
                    default:
                        return 0.0;
                }
                // Add more cases for other activities
            default:
                return 0.0;
        }
    }
}