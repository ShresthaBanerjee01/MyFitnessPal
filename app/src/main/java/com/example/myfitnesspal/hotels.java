package com.example.myfitnesspal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

public class hotels extends AppCompatActivity {
    private EditText placeEditText;
    private Button showMapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        placeEditText = findViewById(R.id.placeEditText);
        showMapButton = findViewById(R.id.search_hotels);

        showMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMap();
            }
        });
    }

    private void showMap() {
        String placeName = placeEditText.getText().toString();

        // Check if the place name is not empty
        if (!placeName.isEmpty()) {
            // Create a Uri with the place name
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(" hotels near by " + placeName ));

            // Create an Intent to open Google Maps
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");

            // Check if there's an app to handle this Intent

                startActivity(mapIntent);

        }
    }
}
