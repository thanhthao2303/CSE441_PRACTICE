package com.example.ex082;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ImageView myimg;
    ImageButton btncapture;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myimg = findViewById(R.id.myimg);  // Đảm bảo rằng ID này là của ImageView
        btncapture = findViewById(R.id.btncapture);

        btncapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kiểm tra quyền trước khi mở camera
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CAMERA}, 1);
                } else {
                    // Mở camera
                    openCamera();
                }
            }
        });
    }

    @SuppressLint("QueryPermissionsNeeded")
    private void openCamera() {
        Intent cameraIntent = new Intent(ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(cameraIntent, 99);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == Activity.RESULT_OK && data != null) {
            Bitmap photo = (Bitmap) Objects.requireNonNull(data.getExtras()).get("data");
            myimg.setImageBitmap(photo);
        }
    }
}
