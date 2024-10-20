package com.example.ex03;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    EditText edt1, edt2, edt3;
    Button btncong, btntru, btnnhan, btnchia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edta);
        edt2 = findViewById(R.id.edtb);
        edt3 = findViewById(R.id.edtc);
        btncong = findViewById(R.id.btncong);
        btntru = findViewById(R.id.btntru);
        btnchia = findViewById(R.id.btnchia);
        btnnhan = findViewById(R.id.btnnhan);

        // Phép cộng
        btncong.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(edt1.getText().toString());
                    int b = Integer.parseInt(edt2.getText().toString());
                    edt3.setText(String.format(getString(R.string.addition_result), a + b));
                } catch (NumberFormatException e) {
                    edt3.setText(getString(R.string.invalid_input_error));
                }
            }
        });

        // Phép trừ
        btntru.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(edt1.getText().toString());
                    int b = Integer.parseInt(edt2.getText().toString());
                    edt3.setText(String.format(getString(R.string.subtraction_result), a - b));
                } catch (NumberFormatException e) {
                    edt3.setText(getString(R.string.invalid_input_error));
                }
            }
        });

        // Phép nhân
        btnnhan.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(edt1.getText().toString());
                    int b = Integer.parseInt(edt2.getText().toString());
                    edt3.setText(String.format(getString(R.string.multiplication_result), a * b));
                } catch (NumberFormatException e) {
                    edt3.setText(getString(R.string.invalid_input_error));
                }
            }
        });

        // Phép chia
        btnchia.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(edt1.getText().toString());
                    int b = Integer.parseInt(edt2.getText().toString());
                    if (b == 0) {
                        edt3.setText(getString(R.string.division_by_zero_error));
                    } else {
                        edt3.setText(String.format(getString(R.string.division_result), a / b));
                    }
                } catch (NumberFormatException e) {
                    edt3.setText(getString(R.string.invalid_input_error));
                }
            }
        });
    }
}

}
