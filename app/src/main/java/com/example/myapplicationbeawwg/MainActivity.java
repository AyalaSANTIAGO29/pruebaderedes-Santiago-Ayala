package com.example.myapplicationbeawwg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private TextView resultTextView, attemptsTextView;
    private Button loginButton;

    private String validUsername = "usuario";
    private String validPassword = "contrasena";
    private int remainingAttempts = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        resultTextView = findViewById(R.id.resultTextView);
        attemptsTextView = findViewById(R.id.attemptsTextView);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (validateCredentials(username, password)) {
                    irAWelcomeActivity(username);
                } else {
                    remainingAttempts--;
                    resultTextView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                    resultTextView.setText("Credenciales incorrectas");
                    attemptsTextView.setText("Intentos restantes: " + remainingAttempts);

                    if (remainingAttempts == 0) {
                        loginButton.setEnabled(false);
                    }
                }
            }
        });
    }

    private boolean validateCredentials(String username, String password) {
        return username.equals(validUsername) && password.equals(validPassword);
    }


    public void irAWelcomeActivity(String view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }




}
