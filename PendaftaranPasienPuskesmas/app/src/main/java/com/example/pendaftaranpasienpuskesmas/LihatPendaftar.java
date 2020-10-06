package com.example.pendaftaranpasienpuskesmas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pendaftaranpasienpuskesmas.adapters.PasienListAdapter;
import com.example.pendaftaranpasienpuskesmas.data.DataPendaftar;
import com.example.pendaftaranpasienpuskesmas.data.DbProvider;
import com.example.pendaftaranpasienpuskesmas.data.PendaftarDao;
import com.example.pendaftaranpasienpuskesmas.viewmodel.PasienViewModel;

import java.util.ArrayList;
import java.util.List;

public class LihatPendaftar extends AppCompatActivity {

    private PasienViewModel pasienViewModel;
    private TextView textNama;
    private PasienListAdapter pasienListAdapter;
    private ArrayList<DataPendaftar> listPasien;
    private RecyclerView rv;
    private DataPendaftar pendaftarTerakhhir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pendaftar);
        this.pasienViewModel = ViewModelProviders.of(this).get(PasienViewModel.class);
        this.initData();
        this.initComponents();
    }

    private void initData() {
        this.listPasien = new ArrayList<>();
        this.pasienListAdapter = new PasienListAdapter(this);
    }

    private void initComponents(){
        this.textNama.setText(this.pendaftarTerakhhir.nama);
        this.rv = this.findViewById(R.id.mRecyclerView);
        this.rv.setLayoutManager(new LinearLayoutManager(this));
        this.rv.setAdapter(this.pasienListAdapter);

        this.pasienViewModel.GetListNama().observe(this, new Observer<List<DataPendaftar>>() {
            @Override
            public void onChanged(List<DataPendaftar> dataPendaftars) {
                pasienListAdapter.setPasienList(listPasien);
            }
        });
    }

    public void kembali(View view) {
        Intent i = new Intent(getApplicationContext(), DaftarPuskesmas.class);
        startActivity(i);
    }
}
