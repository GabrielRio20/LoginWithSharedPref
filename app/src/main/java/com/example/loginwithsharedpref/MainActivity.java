package com.example.loginwithsharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button login;

    private SharedPreferences sharedPreferences;
    private final String sharedPrefFile = "com.example.sharedPreferenceApp";
    private final String LOGIN_KEY = "login";
    public static final String KEY_EMAIL = "EMAIL";
    private boolean isLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        login = findViewById(R.id.btn_login);

        sharedPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        isLogin = sharedPreferences.getBoolean(LOGIN_KEY, false);

        final Intent intent = new Intent(this, MainActivity2.class);
        if (isLogin){
            String message = email.getText().toString();
            intent.putExtra(KEY_EMAIL, message);
            startActivityForResult(intent,1 );
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals("rio") && password.getText().toString().equals("rio")){
                    Intent intent = new Intent(v.getContext(), MainActivity2.class);
                    String message = email.getText().toString();
                    intent.putExtra(KEY_EMAIL, message);
                    startActivityForResult(intent, 1);
                    saveEmail();
                }

            }
        });
    }
    private void saveEmail(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(LOGIN_KEY, true);
        editor.apply();
    }
}
