package com.bellasetyowati.pengingatsederhana.modelView;

import android.app.Application;
import android.app.DatePickerDialog;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bellasetyowati.pengingatsederhana.data.DataPengingat;
import com.bellasetyowati.pengingatsederhana.repository.PengingatRepository;

import java.util.List;

public class Main extends AndroidViewModel {
    private PengingatRepository pengingatRepository;
    public Main(@NonNull Application application) {
        super(application);
        this.pengingatRepository = new PengingatRepository(application);
    }

    public LiveData<List<DataPengingat>> getData(){
        return this.pengingatRepository.listData();
    }

    public void saveData(DataPengingat pengingat){
        this.pengingatRepository.saveData(pengingat);
    }
}
