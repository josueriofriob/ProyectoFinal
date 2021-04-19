package com.josueriofrio.projetz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class PantallaInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent pantallaEspera = new Intent(PantallaInicio.this, MainActivity.class);
                startActivity(pantallaEspera);
            }
        },2000);
    }
}