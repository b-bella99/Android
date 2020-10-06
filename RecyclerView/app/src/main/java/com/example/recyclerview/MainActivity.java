package com.example.recyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.adapters.ContactAdapte;
import com.example.recyclerview.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ContactAdapte.OnContactClickListener {

    public RecyclerView rv;
    public ContactAdapte contactAdapte;
    public RecyclerView.LayoutManager layoutManager;
    public List<Contact> listContact = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rvContact);

        listContact.add(new Contact("Iron Man", "102018308",
                "https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-14-512.png"));

        listContact.add(new Contact("Bat Man", "102018309",
                "https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-22-512.png"));

        listContact.add(new Contact("Groot", "102018307",
                "https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-21-512.png"));

        listContact.add(new Contact("Sonic", "102018301",
                "https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-26-512.png"));

        contactAdapte = new ContactAdapte(listContact);
        contactAdapte.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(contactAdapte);
        rv.setLayoutManager(layoutManager);

    }

    @Override
    public void onClick(View view, int position) {
        Contact contact = listContact.get(position);
        Toast.makeText(this, contact.getName(), Toast.LENGTH_LONG).show();
    }
}
