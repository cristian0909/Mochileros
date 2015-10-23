package com.example.cacp.mochileros;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

/**
 * Created by CACP on 06-10-2015.
 */
public class Popup extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);


    }
    public void cerraronclic(View v){
        finish();
    }

}