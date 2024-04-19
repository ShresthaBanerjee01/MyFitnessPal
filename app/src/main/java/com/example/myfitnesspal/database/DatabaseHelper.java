package com.example.myfitnesspal.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "YourDatabaseName.db";
    private static final int DATABASE_VERSION = 1;

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create user table
        db.execSQL("CREATE TABLE IF NOT EXISTS users (" +
                "userId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "email TEXT, " +
                "password TEXT)");

        // Create steps daily table
        db.execSQL("CREATE TABLE IF NOT EXISTS steps_daily (" +
                "userId INTEGER, " +
                "date TEXT, " +
                "stepsdaily INTEGER, " +
                "FOREIGN KEY(userId) REFERENCES users(userId))");
    }

    // Upgrade database (if needed)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Add upgrade logic here if needed
    }
}
