package com.rvlb.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_checkbox);
        setContentView(R.layout.activity_login);

        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etLogin, etPassword;
                etLogin = (EditText) findViewById(R.id.etLogin);
                etPassword = (EditText) findViewById(R.id.etPassword);
                if(etLogin.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")) {
                    startActivity(new Intent(LoginActivity.this, LoggedInActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, R.string.wrong_user_msg, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
