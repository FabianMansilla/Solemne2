package com.example.solemne2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.solemne2.database.AdminSQLiteOpenHelper;

public class Clases_act extends AppCompatActivity {

    private EditText code, clase, intensi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clases);

        code = findViewById(R.id.code);
        clase = findViewById(R.id.clase);
        intensi = findViewById(R.id.intensi);
    }



    //mketodo para añadir clases
    public void guardarClases(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "tarot", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //permisos de sobreescritura

        String codigo = code.getText().toString();
        String clas = clase.getText().toString();
        String intensidad = intensi.getText().toString();

        if(!codigo.isEmpty() && !clas.isEmpty() && !intensidad.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("codigo", codigo);
            cont.put("clase", clas);
            cont.put("intensidad", intensidad);

            db.insert("tarot", null, cont);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "has guardado una clase", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getBaseContext(), "Los campos estan vacios...", Toast.LENGTH_SHORT).show();
        }

    }

    public void mostrarClases(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "tarot", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //permisos de sobreescritura

        String codigo = code.getText().toString();
        if(!codigo.isEmpty())
        {
            Cursor file = db.rawQuery("SELECT clase, intensidadFROM tarot WHERE codigo ="+codigo, null);

            if(file.moveToFirst()) //verifica si hay clases
            {
                clase.setText(file.getString(0));//??muestra int en vez de columnindex
                intensi.setText(file.getString(1));
            }
            else
            {
                Toast.makeText(getBaseContext(), "No hay clases asociada a la consulta", Toast.LENGTH_LONG).show();
            }

        }
        else
        {
            Toast.makeText(getBaseContext(), "El codigo viene vacio...", Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminarClases(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "tarot", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();

        if(!codigo.isEmpty())
        {
            db.delete("clases", "codigo="+codigo, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Eliminaste una clase", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getBaseContext(), "El codigo viene vacio...", Toast.LENGTH_SHORT).show();
        }

    }

    public void actualizarClases(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "tarot", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //permisos de sobreescritura

        String codigo = code.getText().toString();
        String clas = clase.getText().toString();
        String intensidad = intensi.getText().toString();

        if(!codigo.isEmpty() && !clas.isEmpty() && !intensidad.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("clase", clas);
            cont.put("intensidad", intensidad);

            db.update("tarot", cont, "codigo="+codigo, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "has actualizado una clase", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getBaseContext(), "Los campos estan vacios...", Toast.LENGTH_SHORT).show();
        }
    }

    public void Clean()
    {
        code.setText("");
        clase.setText("");
        intensi.setText("");
    }

}