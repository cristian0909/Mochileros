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
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by CACP on 29-09-2015.
 */
public class Templo extends ActionBarActivity {
    Button valorar;
    EditText comentario;
    Button enviar;
    int comen=0;
    long l=4;
    TextView lugar;
    private RatingBar rb, rb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.templo);
        comentario = (EditText) findViewById(R.id.edcomentario);
        enviar = (Button) findViewById(R.id.enviarcomentario);
        enviar.setEnabled(false);
        rb= (RatingBar) findViewById(R.id.ratingBar);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingBar.setFocusableInTouchMode(true);
                ratingBar.setClickable(true);
                ratingBar.setRating(4);

            }
        });

        valorar= (Button) findViewById(R.id.ingvaloracion);
        lugar= (TextView) findViewById(R.id.lugar);

        String titulolugar = getIntent().getStringExtra("titulo");
        lugar.setText(titulolugar);

    }

    public void ingresarvaloracionOnClick(View v){

            valorar.setEnabled(false);
            Toast.makeText(this, "Valoracon enviada", Toast.LENGTH_LONG).show();



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
