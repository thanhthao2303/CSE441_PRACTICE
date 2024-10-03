package com.example.prac02;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private StaffViewModel staffViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        staffViewModel = new ViewModelProvider(this).get(StaffViewModel.class);

        TextView staffListTextView = findViewById(R.id.staffListTextView);
        EditText staffIdEditText = findViewById(R.id.staffIdEditText);
        EditText staffFullNameEditText = findViewById(R.id.staffFullNameEditText);
        EditText birthDateEditText = findViewById(R.id.birthDateEditText);
        EditText salaryEditText = findViewById(R.id.salaryEditText);
        Button addStaffButton = findViewById(R.id.addStaffButton);

        // Quan sát thay đổi của danh sách nhân viên
        staffViewModel.getStaffList().observe(this, staffList -> {
            if (staffList.isEmpty()) {
                staffListTextView.setText("No Result!");
            } else {
                staffListTextView.setText(TextUtils.join("\n", staffList));
            }
        });

        addStaffButton.setOnClickListener(v -> {
            String staffId = staffIdEditText.getText().toString();
            String fullName = staffFullNameEditText.getText().toString();
            String birthDate = birthDateEditText.getText().toString();
            String salary = salaryEditText.getText().toString();

            if (!staffId.isEmpty() && !fullName.isEmpty() && !birthDate.isEmpty() && !salary.isEmpty()) {
                String staffInfo = staffId + " - " + fullName + " - " + birthDate + " - " + salary;
                staffViewModel.addStaff(staffInfo);
                staffIdEditText.setText("");
                staffFullNameEditText.setText("");
                birthDateEditText.setText("");
                salaryEditText.setText("");
            }
        });
    }
}

