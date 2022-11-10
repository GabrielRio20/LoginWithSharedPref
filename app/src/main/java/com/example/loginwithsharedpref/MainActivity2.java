package com.example.loginwithsharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView email;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        email = findViewById(R.id.tv_email);
        logout = findViewById(R.id.btn_logout);

        Intent intent = getIntent();
        String message1 = intent.getStringExtra(MainActivity.KEY_EMAIL);
        email.setText("Welcome, " + message1 + "!");

//        Intent intent_lo = new Intent(this, MainActivity.class);
//        startActivity(intent_lo);







    }
}
