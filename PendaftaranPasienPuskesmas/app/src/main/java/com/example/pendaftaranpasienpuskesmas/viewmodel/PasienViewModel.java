package com.example.pendaftaranpasienpuskesmas.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pendaftaranpasienpuskesmas.data.DataPendaftar;
import com.example.pendaftaranpasienpuskesmas.repository.PendaftarRepository;

import java.util.List;

public class PasienViewModel extends AndroidViewModel {
    private PendaftarRepository mPendaftarRepository;


    public PasienViewModel(@NonNull Application application) {
        super(application);
        this.mPendaftarRepository = new PendaftarRepository(application);
    }

    public LiveData<List<DataPendaftar>> GetListNama(){
        return this.mPendaftarRepository.getDataList();
    }

    public void InsertLogPasien(DataPendaftar mlogPasien){
       this.mPendaftarRepository.savePasien(mlogPasien);
    }
}
