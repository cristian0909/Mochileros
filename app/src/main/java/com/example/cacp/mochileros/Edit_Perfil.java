package com.example.cacp.mochileros;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by CACP on 20-08-2015.
 */
public class Edit_Perfil extends ActionBarActivity {
    EditText ednom , edape , edubica;
    boolean block;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_perfil);

        ednom = (EditText) findViewById(R.id.ednombre);
        edape = (EditText) findViewById(R.id.edapellido);
        edubica = (EditText) findViewById(R.id.edubicacion);

        ednom.setEnabled(false);
        edape.setEnabled(false);
        edubica.setEnabled(false);

        block=false;
    }

    public void modificarnomOnclick(View v){
        ednom = (EditText) findViewById(R.id.ednombre);

        ednom.setTextColor(Color.parseColor("#31B404"));
        ednom.setClickable(true);
        ednom.setFocusable(true);
        ednom.setEnabled(true);


        block=true;

    }
    public void modificarnapeOnclick(View v){


        edape = (EditText) findViewById(R.id.edapellido);
        edape.setTextColor(Color.parseColor("#31B404"));
        edape.setClickable(true);
        edape.setFocusable(true);
        edape.setEnabled(true);
        block=true;
    }
    public void modificarnubicaOnclick(View v){

        edubica = (EditText) findViewById(R.id.edubicacion);
        edubica.setTextColor(Color.parseColor("#31B404"));
        edubica.setClickable(true);
        edubica.setFocusable(true);
        edubica.setEnabled(true);
        block=true;
    }
    public void ok1Onclick(View v){

        ednom = (EditText) findViewById(R.id.ednombre);
        ednom.setTextColor(Color.parseColor("#FFFFFF"));

        ednom.setEnabled(false);

       if(block){
           Toast.makeText(this, "Se guardo nombre", Toast.LENGTH_LONG).show();

        }else{
           Toast.makeText(this, "Debe editar nombre", Toast.LENGTH_LONG).show();
       }
        block=false;
    }
    public void ok2Onclick(View v){


        edape = (EditText) findViewById(R.id.edapellido);
        edape.setTextColor(Color.parseColor("#FFFFFF"));
        edape.setEnabled(false);
        if(block){
            Toast.makeText(this, "Se guardo apellido", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "Debe editar apellido", Toast.LENGTH_LONG).show();
        }
        block=false;


    }
    public void ok3Onclick(View v){

        edubica = (EditText) findViewById(R.id.edubicacion);
        edubica.setTextColor(Color.parseColor("#FFFFFF"));
        edubica.setEnabled(false);
        if(block){
            Toast.makeText(this, "Se guardo ubicacion", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "Debe editar ubicacion", Toast.LENGTH_LONG).show();
        }
        block=false;
    }
}
