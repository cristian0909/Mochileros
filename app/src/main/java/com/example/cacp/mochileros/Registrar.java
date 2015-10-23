package com.example.cacp.mochileros;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by CACP on 13-07-2015.
 */
public class Registrar  extends ActionBarActivity {

    EditText correo;
    EditText nombre;
    EditText apellido;
    EditText edad ;
    EditText ubicacion;
    EditText clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);
    }
    public void enviarOnClick(View v){

        // EditText CajaTextoUser = (EditText) findViewById(R.id.ET_Nombre); //captura lo del texto user
        //   String User = CajaTextoUser.getText().toString(); //captura el texto en una variable
        //   Toast.makeText(this, "hola " + User, Toast.LENGTH_LONG).show();


         correo = (EditText) findViewById(R.id.et_correo);
         nombre = (EditText) findViewById(R.id.et_nombre);
         apellido = (EditText) findViewById(R.id.et_apellido);
         edad = (EditText) findViewById(R.id.et_edad);
         ubicacion = (EditText) findViewById(R.id.et_ubicacion);
         clave= (EditText) findViewById(R.id.et_clave);


        String scorreo, snombre, sapellido, sedad, subicacion,sclave;

        scorreo = correo.getText().toString();
        snombre = nombre.getText().toString();
        sapellido= apellido.getText().toString();
        sedad = edad.getText().toString();
        subicacion= ubicacion.getText().toString();
        sclave= clave.getText().toString();

        String vacio="";


        if (scorreo.equals(vacio)){
            Toast.makeText(this, "Favor ingrese el campo Correo", Toast.LENGTH_LONG).show();
        }else if (snombre.equals(vacio)){
            Toast.makeText(this, "Favor ingrese el campo Nombre", Toast.LENGTH_LONG).show();
        }else if (sapellido.equals(vacio)){
            Toast.makeText(this, "Favor ingrese el campo Apellido", Toast.LENGTH_LONG).show();
        }else if (sedad.equals(vacio)){
            Toast.makeText(this, "Favor ingrese el campo Edad", Toast.LENGTH_LONG).show();
        }else if (subicacion.equals(vacio)){
            Toast.makeText(this, "Favor ingrese el campo Ubicacion", Toast.LENGTH_LONG).show();
        }else if (sclave.equals(vacio)){
            Toast.makeText(this, "Favor ingrese su clave ", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Sus datos fueron enviado exitosamente. ", Toast.LENGTH_LONG).show();


            Intent formregistrar = new Intent(Registrar.this, Login.class);
            startActivity(formregistrar);
        }







    }
   public void BorrarOnClick (View v){
        correo = (EditText) findViewById(R.id.et_correo);
       nombre = (EditText) findViewById(R.id.et_nombre);
        apellido= (EditText) findViewById(R.id.et_apellido);
        edad= (EditText) findViewById(R.id.et_edad);
        ubicacion = (EditText) findViewById(R.id.et_ubicacion);
        clave = (EditText) findViewById(R.id.et_clave);

       correo.setText("");
       nombre.setText("");
       apellido.setText("");
       edad.setText("");
       ubicacion.setText("");
       clave.setText("");
   }

}
