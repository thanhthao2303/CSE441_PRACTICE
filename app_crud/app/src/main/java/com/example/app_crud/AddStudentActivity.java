package com.example.app_crud;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudentActivity extends AppCompatActivity {

    private EditText editTextHoten, editTextMSSV, editTextLop, editTextDiem;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        editTextHoten = findViewById(R.id.editTextHoten);
        editTextMSSV = findViewById(R.id.editTextMSSV);
        editTextLop = findViewById(R.id.editTextLop);
        editTextDiem = findViewById(R.id.editTextDiem);

        databaseReference = FirebaseDatabase.getInstance().getReference("sinhvien");

        findViewById(R.id.buttonSave).setOnClickListener(v -> {
            String hoten = editTextHoten.getText().toString();
            String mssv = editTextMSSV.getText().toString();
            String lop = editTextLop.getText().toString();
            double diem = Double.parseDouble(editTextDiem.getText().toString());

            SinhVien sinhVien = new SinhVien(hoten, mssv, lop, diem);
            databaseReference.child(mssv).setValue(sinhVien);
            finish();
        });
    }
}
