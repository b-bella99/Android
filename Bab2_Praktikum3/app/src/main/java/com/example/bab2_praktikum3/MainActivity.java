package com.example.bab2_praktikum3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonA;
    private Button buttonB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.buttonA = this.findViewById(R.id.button);
        this.buttonB = this.findViewById(R.id.button2);

        this.buttonB.setOnClickListener(this);
    }

    public void tampilkanPesan(View view) {
        Toast.makeText(this, "Hi kawan", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        if((Button) view == this.buttonB){
            this.buttonA.setBackgroundColor(this.getResources().getColor(R.color.colorAccent));
        }
    }
}
