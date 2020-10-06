package com.example.pendaftaranpasienpuskesmas.data;

import android.content.Context;

import androidx.room.Room;

public class DbProvider {
    private static PuskesmasDatabase instance;

    public static PuskesmasDatabase getInstance(Context context){
        if (DbProvider.instance == null){
            DbProvider.instance = Room.databaseBuilder(
                    context, PuskesmasDatabase.class, "puskesmasapp.db"
            ).allowMainThreadQueries().build();
        }
        return DbProvider.instance;
    }
}
