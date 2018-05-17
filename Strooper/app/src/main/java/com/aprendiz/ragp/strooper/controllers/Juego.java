package com.aprendiz.ragp.strooper.controllers;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aprendiz.ragp.strooper.R;
import com.aprendiz.ragp.strooper.models.ColorJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Juego extends AppCompatActivity {
    TextView txtpalabra, txtcorrectas,txtincorrectas,txtintentos;
    Button btncorrecto, btnincorrecto;
    final Timer timer = new Timer();
    List<String> listpalabra=new ArrayList<>();
    List<Integer> listcolor=new ArrayList<>();
    List<ColorJ> listcolorj=new ArrayList<>();
    int icj=0;
    int ipj=0;
    public static int puntajeC=0;
    public static int puntajeI=0;
    public static int intentos=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        inizialite();
        listar();
        mostrarPuntaje();
        randompalabra();
        mostrarResultados();
        intentos=+1;
        btncorrecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iscorrecto();
                mostrarPuntaje();
                intentos=+1;
                Intent intent = new Intent(Juego.this,Juego.class);
                startActivity(intent);
                finish();
            }
        });

        btnincorrecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isincorrecto();
                mostrarPuntaje();
                intentos=+1;
                Intent intent = new Intent(Juego.this,Juego.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void iscorrecto() {
        if (icj!=0 || ipj!=0) {
            int tmpcolor= txtpalabra.getTextColors().getDefaultColor();
            if (listcolorj.get(ipj).getColor()==tmpcolor){
                puntajeC+=1;
            }
            else {
                puntajeI+=1;
            }
        }
    }
    public void mostrarResultados(){
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Juego.this,Resumen.class);
                startActivity(intent);
                finish();
            }
        };
        final Timer timer = new Timer();
        timer.schedule(timerTask,30000);

    }

    private void isincorrecto() {
        int tmpcolor= txtpalabra.getTextColors().getDefaultColor();
        if (listcolorj.get(ipj).getColor()!=tmpcolor){
            puntajeC+=1;
        }
        else {
            puntajeI+=1;
        }
    }

    private void randompalabra() {
        icj= (int) (Math.random()*6);
        ipj= (int) (Math.random()*6);

        txtpalabra.setText(listpalabra.get(icj));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            txtpalabra.setTextColor(getColor(listcolor.get(ipj)));
        }

    }

    public void listar(){
        ColorJ colorAmarillo = new ColorJ("AMARILLO",R.color.coloramarilloj);
        listcolorj.add(0,colorAmarillo);
        listcolor.add(0,colorAmarillo.getColor());
        listpalabra.add(0,colorAmarillo.getPalabra());

        ColorJ colorAzul = new ColorJ("AZUL",R.color.colorazulj);
        listcolorj.add(1,colorAzul);
        listcolor.add(1,colorAzul.getColor());
        listpalabra.add(1,colorAzul.getPalabra());

        ColorJ colorNaranja = new ColorJ("NARANJA",R.color.colornaranjaj);
        listcolorj.add(2,colorNaranja);
        listcolor.add(2,colorNaranja.getColor());
        listpalabra.add(2,colorNaranja.getPalabra());

        ColorJ colorBlanco = new ColorJ("BLANCO",R.color.colorblancoj);
        listcolorj.add(3,colorBlanco);
        listcolor.add(3,colorBlanco.getColor());
        listpalabra.add(3,colorBlanco.getPalabra());

        ColorJ colorRojo = new ColorJ("ROJO",R.color.colorrojoj);
        listcolorj.add(4,colorRojo);
        listcolor.add(4,colorRojo.getColor());
        listpalabra.add(4,colorRojo.getPalabra());

        ColorJ colorVerde = new ColorJ("VERDE",R.color.colorverdej);
        listcolorj.add(5,colorVerde);
        listcolor.add(5,colorVerde.getColor());
        listpalabra.add(5,colorVerde.getPalabra());

        ColorJ colorPurpura = new ColorJ("PURPURA",R.color.colorpurpuraj);
        listcolorj.add(6,colorPurpura);
        listcolor.add(6,colorPurpura.getColor());
        listpalabra.add(6,colorPurpura.getPalabra());


    }



    public void inizialite(){
        txtpalabra = findViewById(R.id.txtpalabra);
        txtcorrectas = findViewById(R.id.txtcorrectas);
        txtincorrectas = findViewById(R.id.txtincorrectas);
        txtintentos = findViewById(R.id.txtintentos);
        btncorrecto = findViewById(R.id.btncorrecto);
        btnincorrecto = findViewById(R.id.btnincorrecto);
    }

    public void mostrarPuntaje(){
        txtcorrectas.setText("Correctas"+Integer.toString(puntajeC));
        txtincorrectas.setText("Incorrectas"+Integer.toString(puntajeI));
        txtintentos.setText("Intentos"+Integer.toString(intentos));

    }




}
