package com.example.solemne2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import Objetos.Insumos;

public class Home_act extends AppCompatActivity {

    private Insumos in = new Insumos(); //instancia del obj Insumos
    private VideoView videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        videoview = findViewById(R.id.vw);
        //obtengo la ruta del video

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.meme3;
        Uri uri = Uri.parse(ruta); //parseo la ruta
        videoview.setVideoURI(uri); //paso el video a mi video view

        videoview.start();
        videoview.canPause();

    }

    public void Insumos(View view)
    {
        Intent i = new Intent(this, Insumos_act.class);

        //Preparo los extras
        Bundle bun = new Bundle(); //Necesario para enviar arreglos
        bun.putStringArray("insumos", in.getInsumos());
        i.putExtras(bun);
        startActivity(i);
    }

    public void Clases(View view)
    {
        Intent i = new Intent(this, Clases_act.class);
        startActivity(i);
    }


}