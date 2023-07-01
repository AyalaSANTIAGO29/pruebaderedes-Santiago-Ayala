package com.example.myapplicationbeawwg;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private EditText input1EditText, input2EditText;
    private Button checkButton;
    private ImageView resultImageView;
    private TextView resultTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        input1EditText = findViewById(R.id.input1EditText);
        input2EditText = findViewById(R.id.input2EditText);
        checkButton = findViewById(R.id.checkButton);
        resultImageView = findViewById(R.id.resultImageView);
        resultTextView = findViewById(R.id.welcomeResultTextView);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = input1EditText.getText().toString().trim();
                String input2 = input2EditText.getText().toString().trim();

                if (input1.equals(input2)) {
                    resultImageView.setImageResource(R.drawable.imagen1);
                    resultTextView.setText("Los inputs son iguales");
                } else {
                    resultImageView.setImageResource(R.drawable.imagen2);
                    resultTextView.setText("Los inputs son diferentes");
                }
            }
        });

    }
}
