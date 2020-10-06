package com.bellasetyowati.pengingatsederhana.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.bellasetyowati.pengingatsederhana.data.AppDatabase;
import com.bellasetyowati.pengingatsederhana.data.DataPengingat;
import com.bellasetyowati.pengingatsederhana.data.PengingatDao;
import com.bellasetyowati.pengingatsederhana.data.Provider;

import java.util.List;

public class PengingatRepository {
    private AppDatabase database;

    private LiveData<List<DataPengingat>> data;

    public PengingatRepository(Context context){
        this.database = Provider.getAppDbInstance(context);
    }

    public LiveData<List<DataPengingat>> listData(){
        this.getData();
        return this.data;
    }

    private void getData() {
        PengingatDao dao = this.database.pengingatDao();
        this.data = dao.findAll();
    }

    public void saveData(DataPengingat pengingat){
        this.savePengingat(pengingat);
    }
    private void savePengingat(DataPengingat pengingat){
        new SaveDataTask().execute(pengingat);
    }

    private class SaveDataTask extends AsyncTask<DataPengingat, Void, Void> {

        @Override
        protected Void doInBackground(DataPengingat... dataPengingats) {
            PengingatDao pengingatDao = database.pengingatDao();
            for (int i = 0; i <dataPengingats.length; i++) {
                DataPengingat dp = dataPengingats[i];
                pengingatDao.tambah(dp);
            }
            return null;
        }
    }

    private class DeleteDataTask extends AsyncTask<DataPengingat, Void, Void>{

        @Override
        protected Void doInBackground(DataPengingat... dataPengingats) {
            database.pengingatDao().removeAll();
            return null;
        }
    }
}
