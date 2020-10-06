package com.example.pendaftaranpasienpuskesmas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.pendaftaranpasienpuskesmas.data.DataPendaftar;
import com.example.pendaftaranpasienpuskesmas.data.DbProvider;
import com.example.pendaftaranpasienpuskesmas.data.PendaftarDao;
import com.example.pendaftaranpasienpuskesmas.models.Form_Pendaftaran;
import com.example.pendaftaranpasienpuskesmas.viewmodel.PasienViewModel;

public class Confirm extends AppCompatActivity {

    TextView tvNik, tvNama, tvJk, tvLahr, tvAlamat, tvBpjs, tvKunjungan;
    public DataPendaftar dp;
    EditText editTextNik, editTextNama, editTextLahir, editTextAlamat, editTextBpjs, editTextKujungan;
    RadioGroup jenisKelamin;
    RadioButton buttonJk;
    private PasienViewModel pasienViewModel;

    public static  final String Key_FormulirPendaftaran = "Key_FormulirPendaftaran";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tvNik = findViewById(R.id.confirmNik);
        tvNama = findViewById(R.id.confirmNama);
        tvJk = findViewById(R.id.confirmJk);
        tvLahr = findViewById(R.id.confirmLahir);
        tvAlamat = findViewById(R.id.confirmAlamat);
        tvBpjs = findViewById(R.id.confirmBpjs);
        tvKunjungan = findViewById(R.id.confirmKunjungan);

        Form_Pendaftaran formulir_pendaftaran = getIntent().getParcelableExtra(Key_FormulirPendaftaran);

        tvNik.setText(formulir_pendaftaran.getNIK());
        tvNama.setText(formulir_pendaftaran.getNama());
        tvJk.setText(formulir_pendaftaran.getJk());
        tvLahr.setText(formulir_pendaftaran.getTglLahir());
        tvAlamat.setText(formulir_pendaftaran.getAlamat());
        tvBpjs.setText(formulir_pendaftaran.getBpjs());
        tvKunjungan.setText(formulir_pendaftaran.getTglKunjungan());
    }
    private DataPendaftar pendaftar(){
        dp.nik = this.editTextNik.getText().toString();
        dp.nama = this.editTextNama.getText().toString();
        dp.jk = this.buttonJk.getText().toString();
        dp.alamat = this.editTextAlamat.getText().toString();
        dp.lahir = this.editTextLahir.getText().toString();
        dp.bpjs = this.editTextBpjs.getText().toString();
        dp.kunjungan = this.editTextKujungan.getText().toString();

        return dp;
    }

    public void confirm(View view) {
        /*PendaftarDao daoPendaftar = DbProvider.getInstance(this.getApplicationContext()).pendaftarDao();
        daoPendaftar.insertALL(this.pendaftar());
        DataPendaftar newPasien = this.pendaftar();
        pasienViewModel.InsertLogPasien(newPasien);*/
        Intent i = new Intent(Confirm.this, Success.class);
        startActivity(i);
    }

    public void reset(View view) {
        Intent i = new Intent(Confirm.this, Formulir_Pendaftaran.class);
        startActivity(i);
    }
}
