
package com.example.myfitnesspal;

import android.Manifest;
import android.annotation.SuppressLint;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.myfitnesspal.database.StepsDailyDataSource;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


public class pedometer extends AppCompatActivity implements SensorEventListener{
    private static final int PERMISSION_REQUEST_ACTIVITY_RECOGNITION = 1;
    private SharedPreferences sharedPreferences;
    private TextView selectedGenderTextView;
    // private ArrayList<Integer> arr = new ArrayList<>();
    private static final String PREFS_NAME = "StepPrefs";

    private static final String STEP_COUNT_KEY = "stepCount";
    private static final String STEP_TOGO_KEY = "stepToGo";
    private static final String STEP_TARGET_KEY = "stepTarget";
    private static final String STEP_DISTANCE_KEY = "stepdistance";
    private static final String STEP_DISTANCE_TO_GO_KEY = "stepdistancetogo";
    private static final String LAST_TIMESTAMP_KEY = "lastTimestamp";
    private Spinner genderSpinner;
    private SensorManager sensorDetect;// private SensorManager stepsensor;
    private Sensor stepSensor , StepDetector;
    private String target , distance ,distancetogo ;int inttarget ; double intdistance , intdistancetogo ;
    private TextView stepdailyTextView , textViewStepDetector , textviewstepstogo , textviewdistance , textviewdistancetogo;
    EditText targetset; ImageButton save;
    private int  stepDetect = 0 ,stepsdaily=0 , stepstogo =0;private double d;
    /*i=0*/;
    private Calendar lastTimestamp;
    ImageButton calorieburnt,table; BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntriesArrayList;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer);
        //getSupportActionBar().hide();
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        calorieburnt=(ImageButton) findViewById(R.id.calBurnt);
        table=(ImageButton) findViewById(R.id.table);
        save=findViewById(R.id.targetid);
        genderSpinner = findViewById(R.id.genderSpinner);
        selectedGenderTextView = findViewById(R.id.selectedGenderTextView);
        /*barChart = findViewById(R.id.idBarChart);
        barEntriesArrayList = new ArrayList<>();
        barDataSet = new BarDataSet(barEntriesArrayList, "Pedometer");
        barData = new BarData(barDataSet);

        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(false);barChart.invalidate();*/
        // Check if the permission has been granted
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);


        stepsdaily = sharedPreferences.getInt(STEP_COUNT_KEY, 0);
        stepstogo= sharedPreferences.getInt(STEP_TOGO_KEY,1000);
        target=sharedPreferences.getString(STEP_TARGET_KEY,"1000");
        distance=sharedPreferences.getString(STEP_DISTANCE_KEY,"0");
        distancetogo=sharedPreferences.getString(STEP_DISTANCE_TO_GO_KEY,"0");
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
        textviewdistance=findViewById(R.id.distance);
        textviewdistancetogo=findViewById(R.id.distancetogo);
        targetset = findViewById(R.id.targetset);
        targetset.setEnabled(true);
        updateStepCountText();
        updateStepstogoText();
        updateDistanceText();
        updateDistancetogoText();
        //loadStepCounts();
        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pedometer.this,pedometertable.class);
                startActivity(intent);
            }
        });
        calorieburnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pedometer.this,calories_burnt.class);
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
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter);
        int savedGenderPosition = sharedPreferences.getInt("genderPosition", 0);
        genderSpinner.setSelection(savedGenderPosition);
        if (savedGenderPosition == 0) {
            d = 0.00076; // Male
        } else {
            d = 0.00067; // Female
        }
        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, android.view.View view, int position, long id) {
                // Save selected gender position
                sharedPreferences.edit().putInt("genderPosition", position).apply();
                // Update d based on selected gender
                if (position == 0) {
                    d = 0.00076; // Male
                } else {
                    d = 0.00067; // Female
                }
                // Handle selection
                String selectedGender = parent.getItemAtPosition(position).toString();
                selectedGenderTextView.setText("" + selectedGender);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
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
            if (stepstogo < 0) {
                stepstogo = 0; // Reset stepstogo to zero if it's negative //changes
            }
        intdistance=d*stepsdaily;
            intdistancetogo=stepstogo*d;
            distance=String.format("%.2f", intdistance);
            distancetogo=String.format("%.2f", intdistancetogo);
            updateStepCountText();
            updateStepstogoText();
            updateDistanceText();
            updateDistancetogoText();
            updatesteptarget();

            textViewStepDetector.setText(String.valueOf(stepDetect));
           // textviewdistance.setText(distance);
            //textviewdistancetogo.setText(distancetogo);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(STEP_COUNT_KEY, stepsdaily);
            editor.putInt(STEP_TOGO_KEY, stepstogo);
            editor.putString(STEP_DISTANCE_KEY, distance);
            editor.putString(STEP_DISTANCE_TO_GO_KEY,distancetogo);
            editor.putLong(LAST_TIMESTAMP_KEY, Calendar.getInstance().getTimeInMillis());
            editor.apply();// Update your UI or perform any other step-related logic here
        }
    }
    protected void onResume() {
        super.onResume();
        updateStepCountText();
        updateStepstogoText();
        updateDistanceText();
        updateDistancetogoText();
        updatesteptarget();
        targetset.setEnabled(true);
        if (sensorDetect != null) {
            sensorDetect.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (lastTimestamp != null && hasNewDayStarted(lastTimestamp)) {
            int userId = sharedPreferences.getInt("userId", -1);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, -1);
            String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(calendar.getTime());
            StepsDailyDataSource stepsDailyDataSource = new StepsDailyDataSource(this);
            stepsDailyDataSource.open();

            boolean recordExists = stepsDailyDataSource.doesRecordExistForDate(userId, currentDate);
            if (!recordExists) {

                stepsDailyDataSource.insertStepsDaily(userId, currentDate, stepsdaily);//last changes

            }
            stepsDailyDataSource.close();
            stepsdaily = 0;
            distance="0"; //Log.d("StepCounterService", "Day changed. Step count reset to 0.");
            stepstogo = inttarget;
            distancetogo=String.format("%.2f", (d*stepstogo));//i++;
            updateStepCountText();
            updateStepstogoText();
            updateDistanceText();
            updateDistancetogoText();
            SharedPreferences.Editor editor = sharedPreferences.edit();//last changes
            editor.putInt(STEP_COUNT_KEY, stepsdaily);
            editor.apply();
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
    private void updateDistanceText() {
        textviewdistance.setText(distance);
    }
    private void updateDistancetogoText() {
        textviewdistancetogo.setText(distancetogo);}
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
