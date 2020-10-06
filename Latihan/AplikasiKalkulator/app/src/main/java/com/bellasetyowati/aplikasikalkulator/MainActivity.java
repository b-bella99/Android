package com.bellasetyowati.aplikasikalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText angka1, angka2;
    private TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angka1 = (EditText) findViewById(R.id.num_1);
        angka2 = (EditText) findViewById(R.id.num_2);
        hasil = (TextView) findViewById(R.id.nilai);
    }

    public void tambah(View view) {
        if (angka1.getText().length() > 0 && angka2.getText().length() > 0) {
            Double angka_1 = Double.parseDouble(angka1.getText().toString());
            Double angka_2 = Double.parseDouble(angka2.getText().toString());
            Double hasilnya = angka_1 + angka_2;
            hasil.setText(Double.toString(hasilnya));
        }else {
            Toast.makeText(MainActivity.this, "Masukkan angka 1 dan angka 2", Toast.LENGTH_LONG).show();
        }
    }

    public void kurang(View view) {
        if (angka1.getText().length() > 0 && angka2.getText().length() > 0) {
            Double angka_1 = Double.parseDouble(angka1.getText().toString());
            Double angka_2 = Double.parseDouble(angka2.getText().toString());
            Double hasilnya = angka_1 - angka_2;
            hasil.setText(Double.toString(hasilnya));
        }else {
            Toast.makeText(MainActivity.this, "Masukkan angka 1 dan angka 2", Toast.LENGTH_LONG).show();
        }
    }

    public void kali(View view) {
        if (angka1.getText().length() > 0 && angka2.getText().length() > 0) {
            Double angka_1 = Double.parseDouble(angka1.getText().toString());
            Double angka_2 = Double.parseDouble(angka2.getText().toString());
            Double hasilnya = angka_1 * angka_2;
            hasil.setText(Double.toString(hasilnya));
        }else {
            Toast.makeText(MainActivity.this, "Masukkan angka 1 dan angka 2", Toast.LENGTH_LONG).show();
        }
    }

    public void bagi(View view) {
        if (angka1.getText().length() > 0 && angka2.getText().length() > 0) {
            Double angka_1 = Double.parseDouble(angka1.getText().toString());
            Double angka_2 = Double.parseDouble(angka2.getText().toString());
            Double hasilnya = angka_1 / angka_2;
            hasil.setText(Double.toString(hasilnya));
        }else {
            Toast.makeText(MainActivity.this, "Masukkan angka 1 dan angka 2", Toast.LENGTH_LONG).show();
        }
    }

    public void clear(View view) {
        angka1.setText("");
        angka2.setText("");
        hasil.setText("0");
        angka1.requestFocus();
    }
}
