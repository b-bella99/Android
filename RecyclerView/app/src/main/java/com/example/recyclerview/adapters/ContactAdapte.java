package com.example.recyclerview.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.models.Contact;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapte extends RecyclerView.Adapter<ContactAdapte.ContactViewHolder> {
    private List<Contact> listContact = new ArrayList<>();

    @NonNull
    @Override
    public ContactAdapte.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vh = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_contact, parent, false);
        ContactViewHolder viewHolder = new ContactViewHolder(vh);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapte.ContactViewHolder holder, int position) {
        Contact item = listContact.get(position);
        holder.txtPhone.setText(item.getPhone());
        holder.txtName.setText(item.getName());
        Picasso.get().load(item.getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageContact);
    }

    @Override
    public int getItemCount() {
        return listContact.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageContact;
        public TextView txtName,txtPhone;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            imageContact = itemView.findViewById(R.id.imageContact2);
            txtName = itemView.findViewById(R.id.txtName);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(view, getAdapterPosition());
                }
            });
        }
    }

    public ContactAdapte(List<Contact> listContact) {
        this.listContact = listContact;
    }

    private OnContactClickListener listener;

    public interface OnContactClickListener {
        public void onClick(View view, int position);
    }

    public void setListener(OnContactClickListener listener) {
        this.listener = listener;
    }
}
