package com.sertif.menucafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuCafe extends AppCompatActivity {
    private ListView lv;
    //kode:... (minuman) ssss Rp

    String[] menu = new String[]{
            "Kode: B01 (Minumman)= Kopi Hitam, Harga: 10000",
            "Kode: B02 (Minumman)= Cappuccino, Harga: 20000",
            "Kode: M03 (Minumman)= Sparkling Tea, Harga: 15000",
            "Kode: F01 (Makanan)= Batagor, Harga: 25000",
            "Kode: F02 (Makanan)= Cireng, Harga: 10000",
            "Kode: F03 (Makanan)= Nasi Goreng, Harga: 50000",
            "Kode: D01 (Dessert)= Cheese Cake, Harga: 40000",
            "Kode: D02 (Dessert)= Black Salad, Harga: 30000"
    };

    String[] penjelasan = new String[]{
            "Kopi Hitam dengan dibuat dengan teknik ekspreso, dimana biji kopi yang digunakan yaitu" +
                    "berasal dari Aceh Gayo jenis Arabika, disajikan dengan gula terpisah",
            "Paduan kopi dengan buih susu kentalserta menggunakan sirup karamel, dimana biji kopi" +
                    "yang digunakan berasal dari Gunung Puntang Jawa Barat jenis Robusta",
            "Baso dan Tahu Goreng dengan sajian bu,bu kacang dan kecap khas Bandung",
            "Makanan ringan berupa tepung kanji....",
            "Nasi Goreng ....",
            "Kue tart 1 slice...",
            "Potongan buah-buah...",
            "yayay...."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cafe);

        lv = (ListView) findViewById(R.id.lvMenu);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MenuCafe.this, android.R.layout.simple_list_item_1,android.R.id.text1, menu);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MenuCafe.this, penjelasan[i], Toast.LENGTH_LONG).show();
            }
        });
    }
    /*public class ViewModel{
        private String
    }*/
}
