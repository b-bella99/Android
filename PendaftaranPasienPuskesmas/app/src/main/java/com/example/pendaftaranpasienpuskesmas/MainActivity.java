package com.example.pendaftaranpasienpuskesmas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void daftarSekarang(View view) {
        Intent intent = new Intent(MainActivity.this, DaftarPuskesmas.class);
        startActivity(intent);
    }

    public void lihat(View view) {
        Intent i = new Intent(getApplicationContext(), LihatPendaftar.class);
        startActivity(i);
    }
}
