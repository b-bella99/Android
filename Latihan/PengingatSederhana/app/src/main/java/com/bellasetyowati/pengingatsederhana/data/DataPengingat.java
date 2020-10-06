package com.bellasetyowati.pengingatsederhana.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class DataPengingat {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "kegiatan")
    private String kegiatan;

    @ColumnInfo(name = "keterangan")
    private String keterangan;
    @ColumnInfo(name = "waktu")
    private String waktu;

    public DataPengingat(@NonNull String kegiatan, String keterangan, String waktu) {
        this.kegiatan = kegiatan;
        this.keterangan = keterangan;
        this.waktu = waktu;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
}
