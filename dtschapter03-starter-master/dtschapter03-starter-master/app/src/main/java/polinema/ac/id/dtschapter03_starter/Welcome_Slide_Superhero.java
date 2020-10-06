package polinema.ac.id.dtschapter03_starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Welcome_Slide_Superhero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__slide__superhero);
    }

    public void clickLogin(View view) {
        Intent i = new Intent(Welcome_Slide_Superhero.this, SlideAssign.class);
        startActivity(i);
    }

    public void clickGetStarted(View view) {
        Intent i = new Intent(Welcome_Slide_Superhero.this, Welcome_Back.class);
        startActivity(i);
    }
}
