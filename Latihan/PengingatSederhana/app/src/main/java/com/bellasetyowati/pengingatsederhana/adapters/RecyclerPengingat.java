package com.bellasetyowati.pengingatsederhana.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bellasetyowati.pengingatsederhana.R;
import com.bellasetyowati.pengingatsederhana.data.DataPengingat;

import java.util.List;

public class RecyclerPengingat extends RecyclerView.Adapter<PengingatItem> {
    private Context context;
    private List<DataPengingat> dataList;
    onItemClickListener listener;

    public RecyclerPengingat(Context context){
        this.context = context;
    }

    public List<DataPengingat> getDataList(){
        return dataList;
    }

    public void setDataList(List<DataPengingat> dataPengingat){
        this.dataList = dataPengingat;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PengingatItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View pengingatView = inflater.inflate(R.layout.item_pengingat, parent, false);
        PengingatItem pi = new PengingatItem(pengingatView);
        return pi;
    }

    @Override
    public void onBindViewHolder(@NonNull PengingatItem holder, int position) {
        DataPengingat data = this.dataList.get(position);

        String kegiatan = data.getKegiatan();
        String ket = data.getKeterangan();
        String waktu = data.getWaktu();

        holder.getKegiatan().setText(kegiatan);
        holder.getKeterangan().setText(ket);
        holder.getWaktu().setText(waktu);
    }

    @Override
    public int getItemCount() {
        if(this.dataList == null)
            return 0;
        else
            return this.dataList.size();
    }

    public interface onItemClickListener{
        void onItemListener(DataPengingat pengingat);
    }

    public void setOnItemClickListener(onItemClickListener listener){
        this.listener = listener;
    }
}
