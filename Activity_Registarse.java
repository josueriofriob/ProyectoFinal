package com.josueriofrio.projetz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_Registarse extends AppCompatActivity {

    Button btnRegistarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__registarse);

        btnRegistarse = findViewById(R.id.btnRegistarse);

    }

}