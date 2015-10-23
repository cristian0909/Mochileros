package com.example.cacp.mochileros;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by CACP on 10-09-2015.
 */
public class Moneda extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener{
    RadioGroup rg;
    RadioButton rbdolar;
    RadioButton rbeuro;
    RadioButton rbreal;

    TextView valor;

    int opc = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moneda);

        rg = (RadioGroup) findViewById(R.id.rg);

        rbdolar = (RadioButton) findViewById(R.id.rbdolar);
        rbeuro = (RadioButton) findViewById(R.id.rbeuro);
        rbreal = (RadioButton) findViewById(R.id.rbreal);


        valor = (TextView) findViewById(R.id.txtvalor);


        rg.setOnCheckedChangeListener(this);
    }


    public void calOnClick(View view){
        int v = 0;

      EditText cantidad = (EditText) findViewById(R.id.cantidad);

        String demo = cantidad.getText().toString();


        if(demo.equals("")){
            Toast.makeText(this, "Ingrese un valor", Toast.LENGTH_LONG).show();
            valor.setText("");
        }else{


            int cant = Integer.parseInt(demo);
            switch (opc) {
                case 1:
                    v = 690 * cant;
                    valor.setText("$ " + v);
                    break;
                case 2:
                    v = 750 * cant;
                    valor.setText("$ " + v);
                    break;
                case 3:
                    v = 300 * cant;
                    valor.setText("$ " + v);
                    break;
                default:
                    Toast.makeText(this, "Favor ingrese alguna opcion para la conversion", Toast.LENGTH_LONG).show();
                    break;

        }}

        /*else{

            Toast.makeText(this, "Favor ingrese valor" + demo, Toast.LENGTH_LONG).show();




        }}
 */   }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if(rbdolar.isChecked()){
             opc=1;

        }
        if(rbeuro.isChecked()){
            opc = 2;
        }
        if(rbreal.isChecked()){

             opc = 3;
        }



    }
}

