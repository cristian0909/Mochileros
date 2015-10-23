package com.example.cacp.mochileros;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

import java.net.URL;

/**
 * Created by CACP on 26-08-2015.
 */
public class Consejos extends ActionBarActivity implements OnClickListener {
    private TextView doite;
    private TextView lippi;
    private String direccion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consejos);

        doite = (TextView) findViewById(R.id.doite1);
        lippi = (TextView) findViewById(R.id.lippi1);
        direccion="";
        doite.setOnClickListener(this);
        lippi.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.doite1:
                direccion="http://www.doite.cl/";
                irweb(direccion);
                break;
            case R.id.lippi1:
                direccion="http://lippioutdoor.com/";
                irweb(direccion);

            default:

                break;

        }
    }
    public void irweb(String d){
        Uri uri = Uri.parse(d);
        Intent intentNav = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intentNav);

    }
}
