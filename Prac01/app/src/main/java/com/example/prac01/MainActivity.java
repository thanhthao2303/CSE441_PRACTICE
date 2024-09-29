package com.example.prac01;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;  // Define a request code
    Button btnnew;
    TextView txtResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnnew = findViewById(R.id.btnnew);
        txtResult = findViewById(R.id.txtResult);

         btnnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent1 = new Intent(MainActivity.this, MainActivity2.class);
                 startActivityForResult(intent1, REQUEST_CODE);
            }
        });
    }

     @SuppressLint("SetTextI18n")
     @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
             String name = data.getStringExtra("name");
            String gpa = data.getStringExtra("gpa");

             txtResult.setText("Họ và tên: " + name + "\n Điểm GPA: " + gpa);
        }
    }
}
