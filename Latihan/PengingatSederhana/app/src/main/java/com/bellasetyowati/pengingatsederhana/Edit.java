package com.bellasetyowati.pengingatsederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import com.bellasetyowati.pengingatsederhana.data.DataPengingat;
import com.bellasetyowati.pengingatsederhana.data.PengingatDao;
import com.bellasetyowati.pengingatsederhana.data.Provider;

public class Edit extends AppCompatActivity {

    private EditText kegiatan, keterangan, waktu;
    private Button ubah;
    private DataPengingat pengingat;
    private PengingatDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        this.loadData();
        this.initComponent();
    }

    private void initComponent() {
        this.kegiatan = this.findViewById(R.id.kegiatan);
        this.keterangan = this.findViewById(R.id.ket);
        this.waktu = this.findViewById(R.id.jam);
        this.ubah = this.findViewById(R.id.ubah);

        if (this.pengingat == null){
            this.ubah.setEnabled(false);
            return;
        }
        kegiatan.setText(getIntent().getStringExtra("kegiatan"));
        keterangan.setText(getIntent().getStringExtra("keterangan"));
        waktu.setText(getIntent().getStringExtra("waktu"));
    }

    private void loadData() {
        PengingatDao pengingatDao = Provider.getAppDbInstance(this).pengingatDao();

        this.pengingat = pengingatDao.selectOne();
    }

    private  void dataSyn(){
        this.pengingat.setKegiatan(this.kegiatan.getText().toString());
        this.pengingat.setKeterangan(this.keterangan.getText().toString());
        this.pengingat.setWaktu(this.waktu.getText().toString());
    }
    public void ubah(View view) {
        this.dataSyn();

        PengingatDao dao1 = Provider.getAppDbInstance(this).pengingatDao();
        dao1.update(this.pengingat);

    }

    public void selesai(View view) {
        this.dataSyn();

        PengingatDao dao1 = Provider.getAppDbInstance(this).pengingatDao();
        dao1.removeAll();
    }

    public void kembali(View view) {
        Intent i = new Intent(Edit.this, MainActivity.class);
        startActivity(i);
    }
}
