package com.example.cacp.mochileros;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by CACP on 26-08-2015.
 */
public class Cambio_Clave  extends ActionBarActivity {

    EditText edactual;
    EditText ednueva;
    EditText edrep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cambio_clave);
    }
public void cambclavOnClick(View v){

    edactual= (EditText) findViewById(R.id.clave_actual);
    ednueva= (EditText) findViewById(R.id.clave_nueva);
    edrep= (EditText) findViewById(R.id.rep_clave);

    String a= edactual.getText().toString();
    String n= ednueva.getText().toString();
    String r= edrep.getText().toString();


    if(a.equals("")){
        Toast.makeText(this, "Favor ingrese clave actual", Toast.LENGTH_LONG).show();
    }else if(n.equals("")){
        Toast.makeText(this, "Favor ingrese clave nueva", Toast.LENGTH_LONG).show();
    }else if(r.equals("")){
        Toast.makeText(this, "Favor ingrese la repeticion de la clave nueva", Toast.LENGTH_LONG).show();
    }else{
        Toast.makeText(this, "Se ha actualizado correctamente", Toast.LENGTH_LONG).show();

    }


    }
}
