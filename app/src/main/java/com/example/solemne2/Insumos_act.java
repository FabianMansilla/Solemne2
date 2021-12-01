package com.example.solemne2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Insumos_act extends AppCompatActivity {
    private Spinner insumos;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        insumos = findViewById(R.id.spninsumos);
        result = findViewById(R.id.result);

        Bundle bun = getIntent().getExtras(); //Recibo los extras
        String[] listado = bun.getStringArray("insumos");

        ArrayAdapter adaptInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        insumos.setAdapter(adaptInsumos);
    }

    public void Definir(View view)
    {
        String opcion = insumos.getSelectedItem().toString(); //obtengo los valores del spinner
        {
            for(int i = 0; i < opcion.length(); i++)
            {
                result.setText("Elegiste a: " + opcion);
            }

        }

    }
}