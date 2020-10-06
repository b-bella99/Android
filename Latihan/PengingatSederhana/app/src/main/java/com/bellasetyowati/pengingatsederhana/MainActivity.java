package com.bellasetyowati.pengingatsederhana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.bellasetyowati.pengingatsederhana.adapters.RecyclerPengingat;
import com.bellasetyowati.pengingatsederhana.data.DataPengingat;
import com.bellasetyowati.pengingatsederhana.modelView.Main;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Main mainModel;
    private RecyclerPengingat recyclerPengingat;
    private ArrayList<DataPengingat> listData;
    private RecyclerView recyclerView;
    private static final String KEY_REQUEST_UPDATE = "2";
    private EditText kegiatan, ket, waktu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mainModel = ViewModelProviders.of(this).get(Main.class);
        this.initData();
        this.initComponent();

        recyclerPengingat.setOnItemClickListener(new RecyclerPengingat.onItemClickListener() {
            @Override
            public void onItemListener(DataPengingat pengingat) {
                Intent i = new Intent(getApplicationContext(), Edit.class);
                i.putExtra("kegiatan", pengingat.getKegiatan());
                i.putExtra("keterangan", pengingat.getKeterangan());
                i.putExtra("waktu", pengingat.getWaktu());
                startActivity(i);
            }
        });
    }

    private void initData() {
        this.listData = new ArrayList<>();

        this.recyclerPengingat = new RecyclerPengingat(this);
    }

    private void initComponent() {
        this.recyclerView = this.findViewById(R.id.rv);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(this.recyclerPengingat);

        this.recyclerPengingat.setDataList(this.listData);

        this.mainModel.getData().observe(this, new Observer<List<DataPengingat>>() {
            @Override
            public void onChanged(List<DataPengingat> dataPengingats) {
                recyclerPengingat.setDataList(dataPengingats);
            }
        });
    }

    public void baru(View view) {
        Intent i = new Intent(MainActivity.this, Tambah.class);
        startActivity(i);
    }
}
