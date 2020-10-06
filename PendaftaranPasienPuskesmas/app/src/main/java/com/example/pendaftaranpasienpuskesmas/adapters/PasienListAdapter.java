package com.example.pendaftaranpasienpuskesmas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pendaftaranpasienpuskesmas.R;
import com.example.pendaftaranpasienpuskesmas.data.DataPendaftar;

import java.util.List;

public class PasienListAdapter extends RecyclerView.Adapter<PasienViewHolder> {
    private Context context;
    private List<DataPendaftar> pasienList;

    public PasienListAdapter(Context context)
    {
        this.context = context;
    }

    public List<DataPendaftar> getContactList()
    {
        return pasienList;
    }

    public void setPasienList(List<DataPendaftar> pasienList)
    {
        this.pasienList = pasienList;

        // Biar nge-refresh
        this.notifyDataSetChanged();
    }
    @NonNull
    @Override
    public PasienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View pasienView = inflater.inflate(R.layout.pasien_view, parent, false);
        PasienViewHolder ph = new PasienViewHolder(pasienView);
        return ph;
    }

    @Override
    public void onBindViewHolder(@NonNull PasienViewHolder holder, int position) {
        DataPendaftar currentPasien = this.pasienList.get(position);
        String nama = currentPasien.getNama();
        holder.getTvNama().setText(nama);
    }

    @Override
    public int getItemCount() {
        if (this.pasienList==null) {
            return 0;
        }else {
            return this.pasienList.size();
        }
    }
}
