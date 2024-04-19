package com.example.myfitnesspal;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfitnesspal.database.StepsDailyDataSource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class pedometertable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometertable);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        Calendar calendar = Calendar.getInstance();
        String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        SharedPreferences sharedPreferences = getSharedPreferences("StepPrefs", Context.MODE_PRIVATE);
        int userId = sharedPreferences.getInt("userId", -1);
        StepsDailyDataSource stepsDailyDataSource = new StepsDailyDataSource(this);
        stepsDailyDataSource.open();
        String earliestDate = stepsDailyDataSource.getEarliestDate(userId);
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        int size=stepsDailyDataSource.getDatabaseSize();
        if(size!=0){
        while (!earliestDate.equals(currentDate)) {

            int stepsCount = stepsDailyDataSource.getStepsCountForDate(userId, earliestDate);
            Date earliestDateParsed = null;
            try {
                earliestDateParsed = originalFormat.parse(earliestDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

// Format the parsed date to "dd-MM-yyyy" format
            String formattedDate = targetFormat.format(earliestDateParsed);
            // Create a new TableRow
            TableRow row = new TableRow(this);
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
            // Create a new TextView for date
            row.setBackgroundResource(R.drawable.row_border);
            TextView dateTextView = new TextView(this);
            dateTextView.setText(formattedDate);
            dateTextView.setTextColor(Color.BLACK);
            dateTextView.setPadding(8, 8, 8, 8);
            dateTextView.setGravity(Gravity.CENTER);
            dateTextView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));
            dateTextView.setBackgroundResource(R.drawable.column_border);
            row.addView(dateTextView);

            // Create a new TextView for steps count
            TextView stepsTextView = new TextView(this);
            stepsTextView.setText(String.valueOf(stepsCount));
            stepsTextView.setTextColor(Color.BLACK);
            stepsTextView.setPadding(8, 8, 8, 8);
            stepsTextView.setGravity(Gravity.CENTER);
            stepsTextView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1)); // Set layout weight
            stepsTextView.setBackgroundResource(R.drawable.column_border);
            row.addView(stepsTextView);

            // Add the TableRow to the TableLayout
            tableLayout.addView(row,layoutParams);
            try {
                calendar.setTime(dateFormat.parse(earliestDate));
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                earliestDate = dateFormat.format(calendar.getTime());
            } catch (ParseException e) {
                Log.e("ParseException", "Error parsing date: " + e.getMessage());
            }


        } stepsDailyDataSource.close();}
        else {
            Toast.makeText(this, "No data stored", Toast.LENGTH_SHORT).show();
        }
    }
}