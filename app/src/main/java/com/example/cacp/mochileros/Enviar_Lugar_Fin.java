package com.example.cacp.mochileros;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by CACP on 26-10-2015.
 */
public class Enviar_Lugar_Fin extends ActionBarActivity {

    double lat=0.0, log=0.0;
    private RatingBar ratingBar;
    private TextView txtRatingValue;
    private Button btnSubmit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enviar_lugar_fin);

        lat = getIntent().getDoubleExtra("la", 0.000000000);
        log = getIntent().getDoubleExtra("lo", 0.000000000);

        addListenerOnRatingBar();
        addListenerOnButton();
    }
    public void addListenerOnRatingBar() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        txtRatingValue = (TextView) findViewById(R.id.txtratingvalor);

        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {

            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {

                txtRatingValue.setText(String.valueOf(rating));

            }
        });
    }

    public void addListenerOnButton() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        //if click on me, then display the current rating value.
        btnSubmit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(Enviar_Lugar_Fin.this,
                        String.valueOf(ratingBar.getRating()),
                        Toast.LENGTH_SHORT).show();

            }

        });

    }
}
