package polinema.ac.id.dtschapter03_starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Welcome_Back extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__back);
    }

    public void clickForgot(View view) {
        Intent i = new Intent(Welcome_Back.this, ForgotPassword.class);
        startActivity(i);
    }

    public void postLogin(View view) {
        Intent i = new Intent(Welcome_Back.this, Success.class);
        startActivity(i);
    }
}
