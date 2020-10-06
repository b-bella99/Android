package com.bellasetyowati.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView nama;
    private EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.editText);
        nama = (TextView) findViewById(R.id.textView);
    }

    public void tampil(View view) {
        nama.setText("Nama Anda " + input.getText());
    }
}
