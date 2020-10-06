package com.example.pendaftaranpasienpuskesmas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.pendaftaranpasienpuskesmas.data.DataPendaftar;
import com.example.pendaftaranpasienpuskesmas.data.DbProvider;
import com.example.pendaftaranpasienpuskesmas.data.PendaftarDao;
import com.example.pendaftaranpasienpuskesmas.models.Form_Pendaftaran;
import com.example.pendaftaranpasienpuskesmas.viewmodel.PasienViewModel;

public class Formulir_Pendaftaran extends AppCompatActivity {

    private final String Tag = Formulir_Pendaftaran.class.getName();
    public static final String Key_FormulirPendaftaran = "Key_FormulirPendaftaran";

    EditText editTextNik, editTextNama, editTextLahir, editTextAlamat, editTextBpjs, editTextKujungan;
    RadioGroup jenisKelamin;
    RadioButton buttonJk;

    private PasienViewModel pasienViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulir__pendaftaran);

        editTextNik= findViewById(R.id.inputNik);
        editTextNama = findViewById(R.id.inputNama);
        jenisKelamin = findViewById(R.id.pilihJk);
        editTextLahir = findViewById(R.id.inputTanggalLahir);
        editTextAlamat = findViewById(R.id.inputAlamat);
        editTextBpjs = findViewById(R.id.inputBPJS);
        editTextKujungan = findViewById(R.id.inputTglKunjungan);
    }



    public void daftar(View view) {

        String nik = editTextNik.getText().toString();
        String nama = editTextNama.getText().toString();
        String lahir = editTextLahir.getText().toString();
        String alamat = editTextAlamat.getText().toString();
        String kunjungan = editTextKujungan.getText().toString();
        String bpjs = editTextBpjs.getText().toString();

        int selectedJk = jenisKelamin.getCheckedRadioButtonId();
        buttonJk = findViewById(selectedJk);

        String jk = buttonJk.getText().toString();

        Form_Pendaftaran form_pendaftaran = new Form_Pendaftaran(nik, nama, jk, lahir, alamat, bpjs, kunjungan);

        if(TextUtils.isEmpty(nik.trim()) && TextUtils.isEmpty(nama.trim()) &&
        TextUtils.isEmpty(lahir.trim()) && TextUtils.isEmpty(alamat.trim()) && TextUtils.isEmpty(kunjungan.trim())){
            Toast.makeText(view.getContext(), "Tanda bintang (*) wajib diisi", Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(nik.trim())){
            Toast.makeText(view.getContext(), "NIK wajib diisi!", Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(nama.trim())){
            Toast.makeText(view.getContext(), "Nama wajib diisi!", Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(lahir.trim())){
            Toast.makeText(view.getContext(), "Tanggal lahir wajib diisi!", Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(alamat.trim())){
            Toast.makeText(view.getContext(), "Alamat wajib diisi!", Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(kunjungan.trim())){
            Toast.makeText(view.getContext(), "Tanggal kunjngan wajib diisi!", Toast.LENGTH_LONG).show();
        }else{
            Intent i = new Intent(Formulir_Pendaftaran.this, Confirm.class);
            i.putExtra(Key_FormulirPendaftaran, form_pendaftaran);
            startActivity(i);
        }

        /*PendaftarDao daoPendaftar = DbProvider.getInstance(this.getApplicationContext()).pendaftarDao();
        daoPendaftar.insertALL(this.pendaftar());
        Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();*/
    }
}
