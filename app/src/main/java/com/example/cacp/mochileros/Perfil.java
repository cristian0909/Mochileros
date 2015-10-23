package com.example.cacp.mochileros;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by CACP on 20-08-2015.
 */
public class Perfil extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);
    }

    public void editperfilOnClick(View v){


        Intent formeditperfil = new Intent(Perfil.this, Edit_Perfil.class);
        startActivity(formeditperfil);
    }


    public void cambclaveOnClick(View v){


        Intent formcambclave = new Intent(Perfil.this, Cambio_Clave.class );
        startActivity(formcambclave);

    }

    //  EditText CajaTextoUser = (EditText) findViewById(R.id.ET_Nombre); //captura lo del texto user
    //    String User = CajaTextoUser.getText().toString(); //captura el texto en una variable
    //  / Toast.makeText(this, "hola " + User, Toast.LENGTH_LONG).show();

    public void EliminacionCuenta(View v){

        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Importante");
        dialogo1.setMessage("¿ Realente quiere eliminar completamente la cuenta ?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                aceptar();
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                cancelar();
            }
        });
        dialogo1.show();
    }

    public void aceptar() {
        Toast t=Toast.makeText(this,"Bienvenido a probar el programa.", Toast.LENGTH_SHORT);
        t.show();
    }

    public void cancelar() {
        finish();
    }


}
