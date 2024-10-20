package com.example.btth04;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private FirebaseRecyclerAdapter<SinhVien, SinhVienViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseReference = FirebaseDatabase.getInstance().getReference("sinhvien");

        FirebaseRecyclerOptions<SinhVien> options =
                new FirebaseRecyclerOptions.Builder<SinhVien>()
                        .setQuery(databaseReference, SinhVien.class)
                        .build();

        adapter = new FirebaseRecyclerAdapter<SinhVien, SinhVienViewHolder>(options) {
            @NonNull
            @Override
            public SinhVienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sinhvien_item, parent, false);
                return new SinhVienViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull SinhVienViewHolder holder, int position, @NonNull SinhVien model) {
                holder.setSinhVienDetails(model);
            }
        };

        recyclerView.setAdapter(adapter);

        findViewById(R.id.buttonAdd).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddStudentActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    public static class SinhVienViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public SinhVienViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setSinhVienDetails(SinhVien sinhVien) {
            TextView hoten = mView.findViewById(R.id.textViewHoten);
            TextView lop = mView.findViewById(R.id.textViewLop);
            TextView diem = mView.findViewById(R.id.textViewDiem);

            hoten.setText(sinhVien.hoten);
            lop.setText(sinhVien.lop);
            diem.setText(String.valueOf(sinhVien.diem));
        }
    }
}
