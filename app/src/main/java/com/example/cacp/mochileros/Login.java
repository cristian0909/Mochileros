package com.example.cacp.mochileros;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends ActionBarActivity {
    EditText user;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



}

    //------------------------------
    public void IngreseOnClick(View v){

       // EditText CajaTextoUser = (EditText) findViewById(R.id.ET_Nombre); //captura lo del texto user
     //   String User = CajaTextoUser.getText().toString(); //captura el texto en una variable
     //   Toast.makeText(this, "hola " + User, Toast.LENGTH_LONG).show();
        EditText user= (EditText) findViewById(R.id.ET_Nombre);
        EditText pass= (EditText) findViewById(R.id.ET_Password);

        String User = user.getText().toString();
        String Pass = pass.getText().toString();

        String clave="admin";


        if(User.equals("Admin")&& Pass.equals(clave)) {
            Intent formhome = new Intent(Login.this, Home.class);
            startActivity(formhome);

            user = (EditText) findViewById(R.id.ET_Nombre);
            pass = (EditText) findViewById(R.id.ET_Password);

            user.setText("");
            pass.setText("");
        }else{ Toast.makeText(this, "Usuario o clave incorrecta", Toast.LENGTH_LONG).show();
            }


    }
    public void RegistrarOnClick(View v){

       //  EditText CajaTextoUser = (EditText) findViewById(R.id.ET_Nombre); //captura lo del texto user
       //    String User = CajaTextoUser.getText().toString(); //captura el texto en una variable
        //  / Toast.makeText(this, "hola " + User, Toast.LENGTH_LONG).show();

        Intent formregistrar = new Intent(Login.this, Registrar.class);
     startActivity(formregistrar);

        user = (EditText) findViewById(R.id.ET_Nombre);
        pass = (EditText) findViewById(R.id.ET_Password);

        user.setText("");
        pass.setText("");
    }

    public void recclaveOnClick(View v){

        //  EditText CajaTextoUser = (EditText) findViewById(R.id.ET_Nombre); //captura lo del texto user
        //    String User = CajaTextoUser.getText().toString(); //captura el texto en una variable
        //  / Toast.makeText(this, "hola " + User, Toast.LENGTH_LONG).show();

        Intent formrecclave = new Intent(Login.this, Rclave.class);
        startActivity(formrecclave);

        user = (EditText) findViewById(R.id.ET_Nombre);
        pass = (EditText) findViewById(R.id.ET_Password);

        user.setText("");
        pass.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
