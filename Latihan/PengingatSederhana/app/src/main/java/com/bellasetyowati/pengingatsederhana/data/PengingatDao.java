package com.bellasetyowati.pengingatsederhana.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PengingatDao {

    @Insert
    public void tambah(DataPengingat... dataPengingat);//edited

    @Query("SELECT * FROM datapengingat")
    public LiveData<List<DataPengingat>> findAll();

    @Query("DELETE FROM DataPengingat")
    public  void removeAll();

    @Query("SELECT * FROM datapengingat limit 1")
    DataPengingat selectOne();

    @Update
    void update(DataPengingat pengingat);

    @Delete
    void delete(DataPengingat pengingat);
}
