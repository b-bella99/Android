package com.example.pendaftaranpasienpuskesmas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pendaftaranpasienpuskesmas.adapters.DataAdapter;
import com.example.pendaftaranpasienpuskesmas.models.Data;

import java.util.ArrayList;
import java.util.List;

public class DaftarPuskesmas extends AppCompatActivity implements DataAdapter.OnDataClickListener {

    public RecyclerView rv;
    public DataAdapter dataAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<Data> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_puskesmas);
        rv = findViewById(R.id.rvDaftarPuskesmas);

        listData.add(new Data("Puskesmas Kedungkandang"));
        listData.add(new Data("Puskesmas Arjowinangun"));
        listData.add(new Data("Puskesmas Janti"));
        listData.add(new Data("Puskesmas Rampal"));
        listData.add(new Data("Puskesmas Gribig"));

        dataAdapter = new DataAdapter(listData);
        dataAdapter.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(dataAdapter);
        rv.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View view, int position) {
        Data data = listData.get(position);
        Intent i = new Intent(DaftarPuskesmas.this, Formulir_Pendaftaran.class);
        startActivity(i);
    }
}
