package com.example.pendaftaranpasienpuskesmas.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Form_Pendaftaran implements Parcelable {
    String NIK;
    String nama;
    String jk;
    String tglLahir;
    String alamat;
    String bpjs;
    String tglKunjungan;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.NIK);
        dest.writeString(this.nama);
        dest.writeString(this.jk);
        dest.writeString(this.tglLahir);
        dest.writeString(this.alamat);
        dest.writeString(this.bpjs);
        dest.writeString(this.tglKunjungan);
    }

    protected Form_Pendaftaran(Parcel in) {
        this.NIK = in.readString();
        this.nama = in.readString();
        this.jk = in.readString();
        this.tglLahir = in.readString();
        this.alamat = in.readString();
        this.bpjs = in.readString();
        this.tglKunjungan = in.readString();
    }

    public static final Parcelable.Creator<Form_Pendaftaran> CREATOR = new Parcelable.Creator<Form_Pendaftaran>() {
        @Override
        public Form_Pendaftaran createFromParcel(Parcel source) {
            return new Form_Pendaftaran(source);
        }

        @Override
        public Form_Pendaftaran[] newArray(int size) {
            return new Form_Pendaftaran[size];
        }
    };

    public Form_Pendaftaran(String NIK, String nama, String jk, String tglLahir, String alamat, String bpjs, String tglKunjungan) {
        this.NIK = NIK;
        this.nama = nama;
        this.jk = jk;
        this.tglLahir = tglLahir;
        this.alamat = alamat;
        this.bpjs = bpjs;
        this.tglKunjungan = tglKunjungan;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
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

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
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

    public String getTglKunjungan() {
        return tglKunjungan;
    }

    public void setTglKunjungan(String tglKunjungan) {
        this.tglKunjungan = tglKunjungan;
    }

    public static Creator<Form_Pendaftaran> getCREATOR() {
        return CREATOR;
    }
}
