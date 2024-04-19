package com.example.myfitnesspal.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class StepsDailyDataSource {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public StepsDailyDataSource(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Open database connection
    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    // Close database connection
    public void close() {
        dbHelper.close();
    }

    // Insert steps count for a specific user and date
    public long insertStepsDaily(int userId, String date, int stepsdaily) {
        ContentValues values = new ContentValues();
        values.put("userId", userId);
        values.put("date", date);
        values.put("stepsdaily", stepsdaily);
        return database.insert("steps_daily", null, values);
    }
    @SuppressLint("Range")
    public int getStepsCountForDate(int userId, String date) {
        int stepsCount = 0;
        Cursor cursor = null;
        try {
            cursor = database.query("steps_daily",
                    new String[]{"stepsdaily"},
                    "userId = ? AND date = ?",
                    new String[]{String.valueOf(userId), date},
                    null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                stepsCount = cursor.getInt(cursor.getColumnIndexOrThrow("stepsdaily"));
                // Use getColumnIndexOrThrow to avoid potential NullPointerException
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return stepsCount;
    }
    @SuppressLint("Range")
    public String getEarliestDate(int userId) {
        String earliestDate = null;
        Cursor cursor = null;
        try {
            cursor = database.query(
                    "steps_daily",
                    new String[]{"date"},
                    "userId = ?",
                    new String[]{String.valueOf(userId)},
                    null,
                    null,
                    "date ASC",
                    "1" // Limit to 1 result
            );
            if (cursor != null && cursor.moveToFirst()) {
                earliestDate = cursor.getString(cursor.getColumnIndex("date"));
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return earliestDate;
    }
    public int getDatabaseSize() {
        int size = 0;
        Cursor cursor = null;
        try {
            cursor = database.rawQuery("SELECT COUNT(*) FROM steps_daily", null);
            if (cursor != null && cursor.moveToFirst()) {
                size = cursor.getInt(0);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return size;
    }
}
