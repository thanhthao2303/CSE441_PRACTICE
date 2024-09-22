package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
Button btnopen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
//         btnopen = findViewById(R.id.btnopen);
//         btnopen.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View view) {
//                 Intent myintent = new Intent(MainA)
//             }
//         });

        Button btn1 =(Button) findViewById(R.id.btnopen);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                Intent intent1 = new
                        Intent(MainActivity.this,child_activity.class);
                startActivity(intent1);
            }
        });

        };
    }




