package com.example.myfitnesspal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfitnesspal.database.UserDataSource;
public class LoginActivity extends AppCompatActivity {
    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin;
    private UserDataSource userDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        // Initialize views
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Initialize database
        userDataSource = new UserDataSource(this);
        userDataSource.open();

        // Handle login button click
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Authenticate user against database
                if (userDataSource.authenticateUser(email, password)) {
                    int userId = userDataSource.getUserId(email, password);
                    if (userId != -1) {
                    SharedPreferences sharedPreferences = getSharedPreferences("StepPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("userId", userId); // Assuming userId is the user's ID
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();}// Login successful, navigate to main activity
                    Intent intent = new Intent(LoginActivity.this, aftersplash.class);
                    startActivity(intent);
                    finish(); // Finish this activity to prevent going back to it
                } else {
                    // Login failed, display error message
                    Toast.makeText(LoginActivity.this, "Invalid email/password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close database connection
        userDataSource.close();
    }
}