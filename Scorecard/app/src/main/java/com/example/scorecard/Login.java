package com.example.scorecard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {


    Button signUpButton;
    TextInputEditText username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signUpButton = findViewById(R.id.tvSignUp);
        username = findViewById(R.id.tvUsernameField);
        password = findViewById(R.id.tvPasswordField);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG1", username.getText().toString());
                Log.d("TAG3", password.getText().toString());
                loginButton();
            }
        });
    }

    public void loginButton(){
        String usr = username.getText().toString();
        String psw = password.getText().toString();

        background bg = new background(this);
        bg.execute(usr, psw);
    }
}