package com.example.pendaftaranpasienpuskesmas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pendaftaranpasienpuskesmas.R;
import com.example.pendaftaranpasienpuskesmas.data.DataPendaftar;
import com.example.pendaftaranpasienpuskesmas.models.Data;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private List<Data> listData = new ArrayList<>();
    private Context context;
    private List<DataPendaftar> pasienList;


    public DataAdapter(List<Data> listData){
        this.listData = listData;
        this.notifyDataSetChanged();
    }

    private OnDataClickListener listener;

    public interface OnDataClickListener{
        public void onClick(View view, int position);
    }

    public void setListener(OnDataClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vh = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daftar_perpus, parent, false);
        DataViewHolder viewHolder = new DataViewHolder(vh);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Data item = listData.get(position);
        holder.txtName.setText(item.getNamaPuskesmas());
        //holder.txtName.setText();
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(view, getAdapterPosition());
                }
            });
        }
    }
}
