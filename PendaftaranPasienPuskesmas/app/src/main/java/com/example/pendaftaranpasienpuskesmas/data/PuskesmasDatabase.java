package com.example.pendaftaranpasienpuskesmas.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DataPendaftar.class}, version = 1, exportSchema = false)
public abstract class PuskesmasDatabase extends RoomDatabase {
    public abstract PendaftarDao pendaftarDao();

    private static  PuskesmasDatabase instance;
    public static PuskesmasDatabase getDatabase(Context context){
        if (instance == null){
            synchronized (PuskesmasDatabase.class){
                if (instance == null){
                    instance = Room.databaseBuilder(
                            context, PuskesmasDatabase.class, "puskesmas.db"
                    ).build();
                }
            }
        }
        return instance;
    }
}
