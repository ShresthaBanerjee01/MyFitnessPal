package com.example.myfitnesspal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfitnesspal.adapter.doctorsAdapter;
import com.example.myfitnesspal.model.Doctors;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class nutritionist extends AppCompatActivity {
    private EditText placeEditText;
    private Button searchButton;
    private RecyclerView recyclerView;
    private doctorsAdapter adapter;
    // Sample data for testing
    private List<Doctors> doctors = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutritionist);
        getSupportActionBar().hide();
        readExcelFileFromAssets();
        placeEditText = findViewById(R.id.placeEditText);
        searchButton = findViewById(R.id.searchButton);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new doctorsAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String placeName = placeEditText.getText().toString().trim();
                if (!placeName.isEmpty()) {
                    filterHotels(placeName);
                } else {
                    Toast.makeText(nutritionist.this, "Please enter your pincode", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void readExcelFileFromAssets() {
        try {
            InputStream inputStream = getAssets().open("nutritionists.xls");
            Workbook workbook = Workbook.getWorkbook(inputStream);

            // Assuming the first sheet is used
            Sheet sheet = workbook.getSheet(0);
            int rows = sheet.getRows();

            for (int i = 1; i < rows; i++) { // Skip header row
                Cell[] row = sheet.getRow(i);
                String placeName = row[0].getContents();
                String hotelName = row[1].getContents();
                String hotelAddress = row[2].getContents();
                String phone = row[3].getContents();
                String website = row[4].getContents();

                doctors.add(new Doctors(placeName, hotelName, hotelAddress, phone, website));
            }

            workbook.close();
            inputStream.close();
        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }
    }
    private void filterHotels(String placeName) {
        List<Doctors> filteredHotels = new ArrayList<>();
        for (Doctors doctor : doctors) {
            if (doctor.getPlaceName().equalsIgnoreCase(placeName)) {
                filteredHotels.add(doctor);
            }
        }
        if (filteredHotels.isEmpty()) {
            Toast.makeText(nutritionist.this, "Pincode not avalaible", Toast.LENGTH_SHORT).show();
        }
        adapter.setDoctors(filteredHotels);
    }
}