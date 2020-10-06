package com.example.pendaftaranpasienpuskesmas.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pendaftaranpasienpuskesmas.R;

public class PasienViewHolder extends RecyclerView.ViewHolder {
    private TextView tvNama;

    public PasienViewHolder(@NonNull View itemView) {
        super(itemView);
        this.tvNama = itemView.findViewById(R.id.txtName);
    }

    public TextView getTvNama() {
        return tvNama;
    }
}
