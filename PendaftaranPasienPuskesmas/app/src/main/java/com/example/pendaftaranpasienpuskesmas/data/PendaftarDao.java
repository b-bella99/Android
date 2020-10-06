package com.example.pendaftaranpasienpuskesmas.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PendaftarDao {
    @Insert
    public void addNew(DataPendaftar dataPendaftar);

    @Query("SELECT nik, nama FROM pasien")
    public LiveData<List<DataPendaftar>> getNama();

    @Insert
    public void insertALL(DataPendaftar... dataPendaftars);

}
