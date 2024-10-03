package com.example.prac03;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    private List<Country> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        countryList = new ArrayList<>();
        countryList.add(new Country("India", "New Delhi", 1428600000, 2973190, R.drawable.india));
        countryList.add(new Country("China", "Beijing", 1411800000, 9596961, R.drawable.vn));
        // Thêm nhiều quốc gia khác

        adapter = new CountryAdapter(countryList, country -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("country", country);
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
    }
}


