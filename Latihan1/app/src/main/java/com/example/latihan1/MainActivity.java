package com.example.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Ok", Toast.LENGTH_LONG).show();

        Log.d("Tes Log", "Ini Debug");
        Log.e("Tes Log", "Ini Error");
        Log.i("Tes Log", "Ini Info");
        Log.w("Tes Log", "Ini Warning");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "App on Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "App on Pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "App on Resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "App on Stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "App on Restart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "App on Destroy", Toast.LENGTH_SHORT).show();
    }
}
