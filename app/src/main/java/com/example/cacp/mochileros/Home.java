package com.example.cacp.mochileros;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

public class Home extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    public void mapaOnClick(View v){

        Intent formmap = new Intent(Home.this, MapsActivity.class);
        startActivity(formmap);


    }
    public void favOnClick(View v){


        Intent formfav = new Intent(Home.this, Favoritos.class);
        startActivity(formfav);
    }
    public void perfilOnClick(View v){


        Intent formperfil = new Intent(Home.this, Perfil.class);
        startActivity(formperfil);
    }
    public void consejosOnClick(View v){
        Intent formconsejos = new Intent(Home.this, Consejos.class);
        startActivity(formconsejos);

    }
    public void climaOnClick(View v){


        Intent formfavCLIMA = new Intent(Home.this, Clima.class);
        startActivity(formfavCLIMA);
    }
    public void monedaOnClick(View v){


        Intent formfavCLIMA = new Intent(Home.this, Moneda.class);
        startActivity(formfavCLIMA);
    }






    ///////////////////////////////////////////////
    public void aceptar() {
        Intent in = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(in);
    }

    public void cancelar() {
        finish();
    }


}



