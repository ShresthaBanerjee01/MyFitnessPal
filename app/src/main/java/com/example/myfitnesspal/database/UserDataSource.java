package com.example.myfitnesspal.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDataSource {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public UserDataSource(Context context) {
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

    // Insert user data into users table
    public long createUser(String name, String email, String password) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("password", password);
        return database.insert("users", null, values);
    }
    public boolean authenticateUser(String email, String password) {
        Cursor cursor = null;
        try {
            // Query the database to check if the provided email and password match an existing user record
            cursor = database.query("users",
                    new String[]{"email"},
                    "email = ? AND password = ?",
                    new String[]{email, password},
                    null, null, null);

            // If cursor has at least one row, it means user is authenticated
            return cursor != null && cursor.getCount() > 0;
        } finally {
            // Close the cursor to release its resources
            if (cursor != null) {
                cursor.close();
            }
        }
    }
    @SuppressLint("Range")
    public int getUserId(String email, String password) {
        Cursor cursor = null;
        int userId = -1; // Default value if user not found
        try {
            cursor = database.query("users",
                    new String[]{"userId"},
                    "email = ? AND password = ?",
                    new String[]{email, password},
                    null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                userId = cursor.getInt(cursor.getColumnIndex("userId"));
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return userId;
    }
}
