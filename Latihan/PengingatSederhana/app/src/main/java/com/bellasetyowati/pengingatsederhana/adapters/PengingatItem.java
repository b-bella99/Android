package com.bellasetyowati.pengingatsederhana.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bellasetyowati.pengingatsederhana.R;
import com.bellasetyowati.pengingatsederhana.data.DataPengingat;

import java.util.List;

public class PengingatItem extends RecyclerView.ViewHolder {
    private TextView kegiatan, keterangan, waktu;

    RecyclerPengingat.onItemClickListener listener;
    public List<DataPengingat> pengingatList;

    public PengingatItem(@NonNull View itemView) {
        super(itemView);

        this.kegiatan = itemView.findViewById(R.id.kegiatan);
        this.keterangan = itemView.findViewById(R.id.ket);
        this.waktu = itemView.findViewById(R.id.jadwal);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                listener.onItemListener(pengingatList.get(position));
            }
        });
    }

    public TextView getKegiatan() {
        return kegiatan;
    }

    public TextView getKeterangan() {
        return keterangan;
    }

    public TextView getWaktu() {
        return waktu;
    }
}
