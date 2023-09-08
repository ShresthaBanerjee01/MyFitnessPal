
package com.example.myfitnesspal;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.Calendar;



public class pedometer extends AppCompatActivity implements SensorEventListener{
    private static final int PERMISSION_REQUEST_ACTIVITY_RECOGNITION = 1;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "StepPrefs";
    private static final String STEP_COUNT_KEY = "stepCount";
    private static final String STEP_TOGO_KEY = "stepToGo";
    private static final String STEP_TARGET_KEY = "stepTarget";
    private static final String LAST_TIMESTAMP_KEY = "lastTimestamp";
    private SensorManager sensorDetect;// private SensorManager stepsensor;
    private Sensor stepSensor , StepDetector;
    private String target;int inttarget;
    private TextView stepdailyTextView , textViewStepDetector , textviewstepstogo;
   EditText targetset; ImageButton save;
    private int  stepDetect = 0 ,stepsdaily=0 , stepstogo =0;private Calendar lastTimestamp;
    Button calorieburnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer);

        calorieburnt=findViewById(R.id.calBurnt);
        save=findViewById(R.id.targetid);


        // Check if the permission has been granted
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);


        stepsdaily = sharedPreferences.getInt(STEP_COUNT_KEY, 0);
        stepstogo= sharedPreferences.getInt(STEP_TOGO_KEY,0);
        target=sharedPreferences.getString(STEP_TARGET_KEY,"1000");

        long timestampInMillis = sharedPreferences.getLong(LAST_TIMESTAMP_KEY, 0);
        if (timestampInMillis != 0) {
            lastTimestamp = Calendar.getInstance();
            lastTimestamp.setTimeInMillis(timestampInMillis);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACTIVITY_RECOGNITION)
                == PackageManager.PERMISSION_GRANTED) {
            // Permission already granted, start step detection
            startStepDetection();

        } else {
            // Permission not granted, request it
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACTIVITY_RECOGNITION},
                    PERMISSION_REQUEST_ACTIVITY_RECOGNITION);
        }
        stepdailyTextView = findViewById(R.id.stepsdaily);
        textviewstepstogo=findViewById(R.id.stepstogo);
        targetset = findViewById(R.id.targetset);
        targetset.setEnabled(true);
        updateStepCountText();
        updateStepstogoText();

        calorieburnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pedometer.this,caloriecounter.class);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from the EditText
                target = targetset.getText().toString();
                updatesteptarget();
                saveText(target);

            }
        });

    }



    private void startStepDetection() {
        textViewStepDetector = findViewById(R.id.stepsTaken);
        sensorDetect = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorDetect != null) {

            StepDetector = sensorDetect.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
            if (StepDetector != null) {
                sensorDetect.registerListener((SensorEventListener) this, StepDetector, SensorManager.SENSOR_DELAY_NORMAL);
            } else {
                // Step counter sensor is not available on this device
                Toast.makeText(this, "Step counter sensor not available", Toast.LENGTH_SHORT).show();
            }
        }  // Code to start step detection
    }
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            // Get the number of steps from the sensor event
            stepDetect = (int) (stepDetect+event.values[0]);
stepsdaily++;
stepstogo=inttarget-stepsdaily ;
            updateStepCountText();
            updateStepstogoText();
            updatesteptarget();

            textViewStepDetector.setText(String.valueOf(stepDetect));
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(STEP_COUNT_KEY, stepsdaily);
            editor.putInt(STEP_TOGO_KEY, stepstogo);
            editor.putLong(LAST_TIMESTAMP_KEY, Calendar.getInstance().getTimeInMillis());
            editor.apply();// Update your UI or perform any other step-related logic here
        }
    }
    protected void onResume() {
        super.onResume();
        updateStepCountText();
        updateStepstogoText();
        updatesteptarget();
        targetset.setEnabled(true);
        if (sensorDetect != null) {
            sensorDetect.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (lastTimestamp != null && hasNewDayStarted(lastTimestamp)) {
            stepsdaily = 0;
            stepstogo = inttarget;
            updateStepCountText();
            updateStepstogoText();
        }

    }
    protected void onPause() {
        super.onPause();
        if (sensorDetect != null) {
            sensorDetect.unregisterListener((SensorEventListener) this,stepSensor);
        }
    }

    private void updateStepCountText() {
        stepdailyTextView.setText(String.valueOf(stepsdaily));
    }
    private void updateStepstogoText() {
        textviewstepstogo.setText(String.valueOf(stepstogo));
    }
    public void updatesteptarget()
    {
        inttarget= Integer.parseInt(target);
        targetset.setText(target);
        targetset.setEnabled(false);
    }
    private boolean hasNewDayStarted(Calendar lastTimestamp) {
        Calendar now = Calendar.getInstance();
        int lastDay = lastTimestamp.get(Calendar.DAY_OF_YEAR);
        int currentDay = now.get(Calendar.DAY_OF_YEAR);
        return currentDay != lastDay;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_ACTIVITY_RECOGNITION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, start step detection
                startStepDetection();
            } else {
                // Permission denied
                Toast.makeText(this, "Permission denied. Step detection will not work.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    private void saveText(String text) {
        // Save the text to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(STEP_TARGET_KEY, text);
        editor.apply();
    }
}
