package com.example.cacp.mochileros;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

/**
 * Created by CACP on 19-08-2015.
 */
public class Favoritos extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoritos);
    }

    public void IrAMapaOnClick(View v){

        //  EditText CajaTextoUser = (EditText) findViewById(R.id.ET_Nombre); //captura lo del texto user
        //    String User = CajaTextoUser.getText().toString(); //captura el texto en una variable
        //  / Toast.makeText(this, "hola " + User, Toast.LENGTH_LONG).show();

        Intent formregistrar = new Intent(Favoritos.this,MapsActivity.class);
        startActivity(formregistrar);

    }
}


