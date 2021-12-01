package com.example.solemne2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import Objetos.Administrador;
import Objetos.Insumos;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private ProgressBar barra;
    private Button btn;
    private Administrador adm = new Administrador(); //La instancia del obj Administrador

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.etuser);
        pass = findViewById(R.id.etpass);
        msj = findViewById(R.id.msj);
        barra = (ProgressBar)findViewById(R.id.pb);
        btn = (Button)findViewById(R.id.btn);

        msj.setVisibility(View.INVISIBLE);
        barra.setVisibility(View.INVISIBLE);//Barra invisible

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Aqui corremos nuestra tarea Asincrona

                new Task().execute();
            }
        });
    }

    //tarea asincrona
    class Task extends AsyncTask<String, Void, String>
    {
        //Configuracion inicial de la tarea asincrona
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
        }

        // es quien se encarga de llevar el proceso en segundo plano
        @Override
        protected String doInBackground(String... strings) {

            try
            {
                for(int i = 0; i <=10; i++)
                {
                    Thread.sleep(500);
                }
            }
                catch (InterruptedException e)
                {
                   e.printStackTrace();
                }
            return null;

        }

        // si la tarea asincrona se realizo o no con exito
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            barra.setVisibility(View.INVISIBLE);


            String usuario = user.getText().toString().trim();
            String contrasena = pass.getText().toString().trim();
            String userObj = adm.getUser().trim();
            String passObj = adm.getPass().trim();

            switch (usuario)
            {
                case "Fabian":
                    if(usuario.equals(userObj) && contrasena.equals(passObj))
                    {
                        msj.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(getBaseContext(), Home_act.class);
                        startActivity(i);
                    }
                    break;
                case "":
                    if(usuario.equals("") && contrasena.equals(""))
                    {
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos vacios. Por favor ingrese nuevamente");
                    }
                    break;
                default:
                    if (!usuario.equals(userObj) && !contrasena.equals(passObj))
                    {
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos incorrectos. Por favor ingrese nuevamente");
                    }
                    break;
            }
        }
    }

    public void Info (View view)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }



    public void Facebook(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); //Sitio web
        i.setData(Uri.parse("https://www.facebook.com/"));
        startActivity(i);
    }
    public void Twitter(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); //Sitio web
        i.setData(Uri.parse("https://www.twitter.com/"));
        startActivity(i);
    }
    public void Youtube(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); //Sitio web
        i.setData(Uri.parse("https://www.youtube.com/"));
        startActivity(i);
    }
}