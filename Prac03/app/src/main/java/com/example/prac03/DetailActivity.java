package com.example.prac03;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    private ImageView flagImageViewDetail;
    private TextView nameTextViewDetail, capitalTextViewDetail, populationTextViewDetail, areaTextViewDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        flagImageViewDetail = findViewById(R.id.flagImageViewDetail);
        nameTextViewDetail = findViewById(R.id.nameTextViewDetail);
        capitalTextViewDetail = findViewById(R.id.capitalTextViewDetail);
        populationTextViewDetail = findViewById(R.id.populationTextViewDetail);
        areaTextViewDetail = findViewById(R.id.areaTextViewDetail);

        Country country = getIntent().getParcelableExtra("country");

        if (country != null) {
            flagImageViewDetail.setImageResource(country.getFlagResourceId());
            nameTextViewDetail.setText(country.getName());
            capitalTextViewDetail.setText("Capital: " + country.getCapital());
            populationTextViewDetail.setText("Population: " + country.getPopulation());
            areaTextViewDetail.setText("Area: " + country.getArea() + " km²");
        }
    }
}
