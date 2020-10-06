package polinema.ac.id.dtschapter03_starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeSlideCalendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_slide_calendar);
    }

    public void onClickGetStarted(View view){
        Intent i = new Intent(WelcomeSlideCalendar.this, Welcome_Slide_Superhero.class);
        startActivity(i);
        finish();
    }

    public void clikLogin(View view) {
        Intent i = new Intent(WelcomeSlideCalendar.this, Welcome_Back.class);
        startActivity(i);
    }
}
