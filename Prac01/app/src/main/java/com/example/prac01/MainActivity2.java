package com.example.prac01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Button btnsub;
    EditText edtten, edtdtb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edtten = findViewById(R.id.edtten);
        edtdtb = findViewById(R.id.edtdtb);
        btnsub = findViewById(R.id.btnsub);

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String name = edtten.getText().toString();
                String gpa = edtdtb.getText().toString();

                 Intent resultIntent = new Intent();
                resultIntent.putExtra("name", name);
                resultIntent.putExtra("gpa", gpa);

                 setResult(RESULT_OK, resultIntent);
                finish();  
            }
        });
    }
}
