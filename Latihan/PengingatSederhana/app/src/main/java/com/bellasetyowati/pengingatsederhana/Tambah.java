package com.bellasetyowati.pengingatsederhana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bellasetyowati.pengingatsederhana.adapters.RecyclerPengingat;
import com.bellasetyowati.pengingatsederhana.data.DataPengingat;
import com.bellasetyowati.pengingatsederhana.modelView.Main;

import java.util.ArrayList;
import java.util.List;

public class Tambah extends AppCompatActivity {

    public Main mainModel;
    private ArrayList<DataPengingat> dataList;
    private EditText kegiatan, ket, waktu;
    private RecyclerPengingat recyclerPengingat;
    private RecyclerView rvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        kegiatan = (EditText) findViewById(R.id.kegiatan);
        ket = (EditText) findViewById(R.id.ket);
        waktu =(EditText) findViewById(R.id.jam);
        this.mainModel = ViewModelProviders.of(this).get(Main.class);
        this.iniData();
        //this.initComponent();
    }

    private void iniData() {
        this.dataList = new ArrayList<>();
        this.recyclerPengingat = new RecyclerPengingat(this);
    }

    /*private void initComponent(){
        this.rvv = this.findViewById(R.id.rv);
        this.rvv.setLayoutManager(new LinearLayoutManager(this));
        this.rvv.setAdapter(this.recyclerPengingat);

        this.mainModel.getData().observe(this, new Observer<List<DataPengingat>>() {
            @Override
            public void onChanged(List<DataPengingat> dataPengingats) {
                recyclerPengingat.setDataList(dataPengingats);
            }
        });
    }*/

    public void tambah(View view) {
        DataPengingat dataPengingat = this.buat();
        Log.e("tess", "error");
        mainModel.saveData(dataPengingat);
        Toast.makeText(this, "Data Tersimpan! Silahkan tekan tombol kembali", Toast.LENGTH_LONG).show();
    }

    private DataPengingat buat() {
        String kegia = kegiatan.getText().toString();
        String keterangan = ket.getText().toString();
        String waktuu = waktu.getText().toString();
        DataPengingat dp = new DataPengingat(kegia,keterangan,waktuu);
        return dp;
    }

    public void back(View view) {
        Intent i = new Intent(Tambah.this, MainActivity.class);
        startActivity(i);
    }
}
