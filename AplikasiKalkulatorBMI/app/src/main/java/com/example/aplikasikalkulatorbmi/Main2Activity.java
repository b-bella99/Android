package com.example.aplikasikalkulatorbmi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main2Activity extends AppCompatActivity {

    private EditText tinggi;
    private EditText bobot;
    private EditText umur;
    private EditText goal;
    private RadioGroup rgGender;
    private RadioButton rdGender;

    int tampilBerat;
    int tampilTinggi;
    int tampilUmur;
    int tampilGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tinggi = (EditText) findViewById(R.id.inputTinggi);
        bobot = (EditText) findViewById(R.id.inputBerat);
        umur = (EditText) findViewById(R.id.inputUmur);
        goal = (EditText) findViewById(R.id.inputGoal);
        rgGender = (RadioGroup) findViewById(R.id.pilihGender);
    }

    public void tmbBerat(View view) {
        tampilBerat = tampilBerat + 1;
        displayBerat(tampilBerat);
    }

    private void displayBerat(int tampilBerat) {
        EditText inputBerat = (EditText) findViewById(R.id.inputBerat);
        inputBerat.setText("" + tampilBerat);
    }

    public void krgBerat(View view) {
        tampilBerat = tampilBerat - 1;
        displayBerat(tampilBerat);
    }

    public void tmbTinggi(View view) {
        tampilTinggi = tampilTinggi + 1;
        displayTinggi(tampilTinggi);
    }

    private void displayTinggi(int tampilTinggi) {
        EditText inputTinggi = (EditText) findViewById(R.id.inputTinggi);
        inputTinggi.setText("" + tampilTinggi);
    }

    public void krgTinggi(View view) {
        tampilTinggi = tampilTinggi - 1;
        displayTinggi(tampilTinggi);
    }

    public void tmbUmur(View view) {
        tampilUmur = tampilUmur + 1;
        displayUmur(tampilUmur);
    }

    private void displayUmur(int tampilUmur) {
        EditText inputUmur = (EditText) findViewById(R.id.inputUmur);
        inputUmur.setText("" + tampilUmur);
    }

    public void krgUmur(View view) {
        tampilUmur = tampilUmur - 1;
        displayUmur(tampilUmur);
    }

    public void tmbGoal(View view) {
        tampilGoal = tampilGoal + 1;
        displayGoal(tampilGoal);
    }

    private void displayGoal(int tampilGoal) {
        EditText inputGoal = (EditText) findViewById(R.id.inputGoal);
        inputGoal.setText("" + tampilGoal);
    }

    public void krgGoal(View view) {
        tampilGoal = tampilGoal - 1;
        displayGoal(tampilGoal);
    }

    public void calculateBMI(View view) {
        String tinggiStr = tinggi.getText().toString();
        String bobotStr = bobot.getText().toString();
        
        if(tinggiStr != null && !"".equals(tinggiStr)
        && bobotStr != null && !"".equals(bobotStr)){
            float tinggiValue = Float.parseFloat(tinggiStr) / 100;
            float bobotValue = Float.parseFloat(bobotStr);
            
            float bmi = bobotValue / (tinggiValue * tinggiValue);
            
            displayBMI(bmi);
        }
    }

    private void displayBMI(float bmi) {
        String bmiLabel = "";
        String infoUmur = umur.getText().toString();
        Integer pilihGender = rgGender.getCheckedRadioButtonId();
        rdGender = (RadioButton) findViewById(pilihGender);

        if(Float.compare(bmi, 15f) <= 0){
            bmiLabel = getString(R.string.terlalu_sangat_kurus);
        }else  if(Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0){
            bmiLabel = getString(R.string.sangat_kurus);
        }else  if(Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.f) <= 0){
            bmiLabel = getString(R.string.kurus);
        }else  if(Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0){
            bmiLabel = getString(R.string.normal);
        }else  if(Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0){
            bmiLabel = getString(R.string.gemuk);
        }else  if(Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0){
            bmiLabel = getString(R.string.cukup_gemuk);
        }else  if(Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0){
            bmiLabel = getString(R.string.sangat_gemuk);
        }else {
            bmiLabel = getString(R.string.terlalu_sangat_gemuk);
        }

        bmiLabel = "Jenis Kelamin: " + rdGender.getText() + "\n\n" + "Hasil penghitungan BMI"
                + bmi + " --- " + "Kategori: " + "(" + bmiLabel + ")" + "\n\n" + "Umur" + infoUmur;

        AlertDialog.Builder tampilBMI = new AlertDialog.Builder(this);

        tampilBMI.setTitle("Hasil Penghitugan BMI");

        tampilBMI.setMessage(bmiLabel).setNeutralButton("Tutup", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alertDialog = tampilBMI.create();
        alertDialog.show();
    }
}
