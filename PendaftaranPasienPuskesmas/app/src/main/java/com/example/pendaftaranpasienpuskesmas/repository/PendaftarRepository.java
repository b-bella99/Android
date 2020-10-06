package com.example.pendaftaranpasienpuskesmas.repository;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;

import com.example.pendaftaranpasienpuskesmas.data.DataPendaftar;
import com.example.pendaftaranpasienpuskesmas.data.DbProvider;
import com.example.pendaftaranpasienpuskesmas.data.PendaftarDao;
import com.example.pendaftaranpasienpuskesmas.data.PuskesmasDatabase;

import java.util.List;

public class PendaftarRepository {
    private LiveData<List<DataPendaftar>> dataPasienList;
    private PuskesmasDatabase puskesmasDatabase;
    private static PendaftarDao pendaftarDao;

    public PendaftarRepository(Context context){
        this.puskesmasDatabase = DbProvider.getInstance(context);
    }

    public LiveData<List<DataPendaftar>> getDataList(){
        this.getDataFromDb();
        return this.dataPasienList;
    }

    private void getDataFromDb() {
        PendaftarDao dao = this.puskesmasDatabase.pendaftarDao();
        this.dataPasienList = dao.getNama();
    }

    public void InsertPasien(DataPendaftar dataPendaftar){
        new InsertPasienAsynTask().execute(dataPendaftar);
    }

    private class InsertPasienAsynTask extends AsyncTask<DataPendaftar, Void, Void> {
        @Override
        protected Void doInBackground(DataPendaftar... dataPendaftars) {
            pendaftarDao = puskesmasDatabase.pendaftarDao();
            for (int i = 0; i < dataPendaftars.length; i++){
                DataPendaftar dp = dataPendaftars[i];
                pendaftarDao.addNew(dp);
            }
            return null;
        }
    }

    public void savePasien(DataPendaftar dataPendaftar){
        this.saveDatatoDb(dataPendaftar);
    }

    private void saveDatatoDb(DataPendaftar dataPendaftar) {
        new InsertPasienAsynTask().execute(dataPendaftar);
    }

    public LiveData<List<DataPendaftar>> GetAllName(String name){
        return pendaftarDao.getNama();
    }
}
