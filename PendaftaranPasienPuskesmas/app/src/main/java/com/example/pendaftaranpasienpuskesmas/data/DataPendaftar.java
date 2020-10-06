package com.example.pendaftaranpasienpuskesmas.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "pasien")
public class DataPendaftar {

    @PrimaryKey
    @NonNull
    public String nik;

    @ColumnInfo(name = "nama")
    @Expose
    @SerializedName("nama")
    public String nama;

    @ColumnInfo(name = "jk")
    @Ignore
    @SerializedName("jk")
    public String jk;

    @ColumnInfo(name = "tanggalLahir")
    @Ignore
    @SerializedName("tanggalLahir")
    public String lahir;

    @ColumnInfo(name = "alamat")
    @Ignore
    @SerializedName("alamat")
    public String alamat;

    @ColumnInfo(name = "noBPJS")
    @Ignore
    @SerializedName("noBPJS")
    public String bpjs;

    @ColumnInfo(name = "tglKunjungan")
    @Ignore
    @SerializedName("tglKunjungan")
    public String kunjungan;

    public DataPendaftar(String nama) {
        this.nama = nama;
    }

    /*public DataPendaftar(@NonNull String nik, String nama, String jk, String lahir, String alamat, String bpjs, String kunjungan) {
        this.nik = nik;
        this.nama = nama;
        this.jk = jk;
        this.lahir = lahir;
        this.alamat = alamat;
        this.bpjs = bpjs;
        this.kunjungan = kunjungan;
    }*/

    @NonNull
    public String getNik() {
        return nik;
    }

    public void setNik(@NonNull String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getLahir() {
        return lahir;
    }

    public void setLahir(String lahir) {
        this.lahir = lahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getBpjs() {
        return bpjs;
    }

    public void setBpjs(String bpjs) {
        this.bpjs = bpjs;
    }

    public String getKunjungan() {
        return kunjungan;
    }

    public void setKunjungan(String kunjungan) {
        this.kunjungan = kunjungan;
    }
}
