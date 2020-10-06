package com.bellasetyowati.pengingatsederhana.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {DataPengingat.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{
    public abstract PengingatDao pengingatDao();
}
