package com.example.cacp.mochileros;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

/**
 * Created by CACP on 09-09-2015.
 */
public class Splash extends Activity {

    // Duración en milisegundos que se mostrará el splash
    private final int DURACION_SPLASH = 2000; // 2 segundos

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
          // Set portrait orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
          // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

           // Tenemos una plantilla llamada splash.xml donde mostraremos la información que queramos (logotipo, etc.)
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                // Cuando pasen los 2 segundos, pasamos a la actividad principal de la aplicación
                Intent intent = new Intent(Splash.this,Login.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
    }
}