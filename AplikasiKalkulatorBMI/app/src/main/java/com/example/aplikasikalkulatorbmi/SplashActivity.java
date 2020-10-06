package com.example.aplikasikalkulatorbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashbmi);

          handler = new Handler();
          handler.postDelayed(new Runnable() {
              @Override
              public void run() {
                  Intent intent = new Intent(SplashActivity.this, Main2Activity.class);
                  startActivity(intent);
                  finish();
              }
          }, 3000);
    }
}
