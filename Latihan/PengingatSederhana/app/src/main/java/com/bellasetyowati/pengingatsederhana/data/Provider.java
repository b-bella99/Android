package com.bellasetyowati.pengingatsederhana.data;

import android.content.Context;

import androidx.room.Room;

public class Provider{
    private static AppDatabase appDatabase;
    private static AppDatabase asyncronousInstance;
    public static AppDatabase getAppDbInstance(Context context){
        if(Provider.appDatabase == null){
            Provider.appDatabase = Room.
                    databaseBuilder(context, AppDatabase.class, "pengingat.db")
                    .allowMainThreadQueries().build();
        }
        return Provider.appDatabase;
    }

    public static AppDatabase getAsyncronousInstance(Context context){
        if(Provider.asyncronousInstance == null){
            Provider.asyncronousInstance = Room.databaseBuilder(
                    context, AppDatabase.class, "dtsapp.db").build();
        }
        return Provider.asyncronousInstance;
    }
}
