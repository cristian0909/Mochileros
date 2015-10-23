package com.example.cacp.mochileros;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by CACP on 29-09-2015.
 */
public class Templo extends ActionBarActivity {
   ImageButton img1, img2, img3, img4, img5;
    Button valorar;
    EditText comentario;
    Button enviar;
    int conteo = 1, valor=0, comen=0;
    TextView lugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.templo);
        comentario = (EditText) findViewById(R.id.edcomentario);
        enviar = (Button) findViewById(R.id.enviarcomentario);
        enviar.setEnabled(false);

        img1 = (ImageButton) findViewById(R.id.start1);
        img2 = (ImageButton) findViewById(R.id.start2);
        img3 = (ImageButton) findViewById(R.id.start3);
        img4 = (ImageButton) findViewById(R.id.start4);
        img5 = (ImageButton) findViewById(R.id.start5);

        img1.setBackgroundResource(R.drawable.estrella0);
        img2.setBackgroundResource(R.drawable.estrella0);
        img3.setBackgroundResource(R.drawable.estrella0);
        img4.setBackgroundResource(R.drawable.estrella0);
        img5.setBackgroundResource(R.drawable.estrella0);


        valorar= (Button) findViewById(R.id.ingvaloracion);
        lugar= (TextView) findViewById(R.id.lugar);

        String titulolugar = getIntent().getStringExtra("titulo");
        lugar.setText(titulolugar);

    }

    public void masOnClick(View v) {

if(valor==0) {
    if (conteo == 1) {

        img1.setBackgroundResource(R.drawable.estrella1);
        conteo++;
    } else if (conteo == 2) {
        img2.setBackgroundResource(R.drawable.estrella1);
        conteo++;
    } else if (conteo == 3) {
        img3.setBackgroundResource(R.drawable.estrella1);
        conteo++;
    } else if (conteo == 4) {
        img4.setBackgroundResource(R.drawable.estrella1);
        conteo++;

    } else if (conteo == 5) {
        img5.setBackgroundResource(R.drawable.estrella1);
        conteo++;
    } else if (conteo > 5) {

        conteo = 1;

        img1.setBackgroundResource(R.drawable.estrella0);
        img2.setBackgroundResource(R.drawable.estrella0);
        img3.setBackgroundResource(R.drawable.estrella0);
        img4.setBackgroundResource(R.drawable.estrella0);
        img5.setBackgroundResource(R.drawable.estrella0);
    }
}else{

    Toast.makeText(this, "Ya se envio la valorizacion", Toast.LENGTH_LONG).show();

}
    }

    public void ingresarvaloracionOnClick(View v){
        if(valor == 0){

            img1 = (ImageButton) findViewById(R.id.start1);
            img2 = (ImageButton) findViewById(R.id.start2);
            img3 = (ImageButton) findViewById(R.id.start3);
            img4 = (ImageButton) findViewById(R.id.start4);
            img5 = (ImageButton) findViewById(R.id.start5);

            img1.setBackgroundResource(R.drawable.estrella0);
            img2.setBackgroundResource(R.drawable.estrella0);
            img3.setBackgroundResource(R.drawable.estrella0);
            img4.setBackgroundResource(R.drawable.estrella0);
            img5.setBackgroundResource(R.drawable.estrella0);


            conteo=0;
            valor=1;
            valorar.setEnabled(false);
            Toast.makeText(this, "Valoracon enviada", Toast.LENGTH_LONG).show();

        }

    }
    public void igresoComentarioOnClick(View v){
       if(comen==0){
        comentario.setVisibility(View.VISIBLE);
        enviar.setEnabled(true);
        comentario.setFocusable(true);
        comentario.setFocusableInTouchMode(true);
        comentario.setBackgroundResource(R.drawable.borde);
       }else{
           Toast.makeText(this, "Favor escriba un comentario ", Toast.LENGTH_LONG).show();
           comentario.setFocusableInTouchMode(true);

       }
        comen=1;
    }
    public void enviarComentarioOnClick(View v){

        if(comentario.getText().toString() != "Comentario" ){

            comentario.setVisibility(View.GONE);
            comentario.setFocusable(false);
            Toast.makeText(this, "Se envio comentario", Toast.LENGTH_LONG).show();
            enviar.setEnabled(false);

            comen = 0;


        }else {
            Toast.makeText(this, "El cuadro de texto esta en blanco, Favor ingrese comentario", Toast.LENGTH_LONG).show();
        }
    }

}
