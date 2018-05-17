package com.aprendiz.ragp.strooper.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aprendiz.ragp.strooper.R;

public class Menu extends AppCompatActivity implements View.OnClickListener{

    Button btnjugar,btnpuntaje,btnconfiguracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        inizialite();
        btnjugar.setOnClickListener(this);
        btnpuntaje.setOnClickListener(this);
        btnconfiguracion.setOnClickListener(this);
    }

    public void inizialite(){
        btnjugar = findViewById(R.id.btnjuego);
        btnpuntaje = findViewById(R.id.btnpuntaje);
        btnconfiguracion = findViewById(R.id.btnconfiguracion);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.btnjuego:
                intent = new Intent(Menu.this,Juego.class);
                startActivity(intent);
                break;

            case R.id.btnpuntaje:
                intent = new Intent(Menu.this,Puntaje.class);
                startActivity(intent);
                break;

            case R.id.btnconfiguracion:
                intent = new Intent(Menu.this,Configuracion.class);
                startActivity(intent);
                break;

        }


    }
}
