package com.example.cacp.mochileros;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
Button map, fav, perfil, consejo, clima, moneda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        map = (Button) findViewById(R.id.btmaps);
        fav = (Button) findViewById(R.id.btfavorito);
        perfil = (Button) findViewById(R.id.btperfil);
        consejo = (Button) findViewById(R.id.btconsejo);
        clima = (Button) findViewById(R.id.btclima);
        moneda = (Button) findViewById(R.id.btmoneda);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formmap = new Intent(Home.this, MapsActivity.class);
                startActivity(formmap);
            }
        });
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forfav = new Intent(Home.this, Favoritos.class);
                startActivity(forfav);
            }
        });
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forperf = new Intent(Home.this, Perfil.class);
                startActivity(forperf);
            }
        });
        consejo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forconsejo = new Intent(Home.this, Consejos.class);
                startActivity(forconsejo);
            }
        });
        clima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forclima = new Intent(Home.this, Clima.class);
                startActivity(forclima);
            }
        });
        moneda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formoneda = new Intent(Home.this, Moneda.class);
                startActivity(formoneda);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_map) {
            Intent formmap = new Intent(Home.this, MapsActivity.class);
            startActivity(formmap);

        } else if (id == R.id.nav_favorito) {
            Intent forfav = new Intent(Home.this, Favoritos.class);
            startActivity(forfav);
        }else if (id == R.id.nav_perfil) {
            Intent forperf = new Intent(Home.this, Perfil.class);
            startActivity(forperf);
        }else if (id == R.id.nav_consejos) {
            Intent forconsejos = new Intent(Home.this, Consejos.class);
            startActivity(forconsejos);
        }
        else if (id == R.id.nav_moneda) {
            Intent formonedas = new Intent(Home.this, Moneda.class);
            startActivity(formonedas);
        }

        else if (id == R.id.nav_clima) {
            Intent forclima = new Intent(Home.this, Clima.class);
            startActivity(forclima);
        }
        else if (id == R.id.nav_acercade) {
            Intent foracerca = new Intent(Home.this, Acerca_De.class);
            startActivity(foracerca);
        }
        else if (id == R.id.nav_descarga) {
            Toast.makeText(this, "Se iniciado descarga ... mentira", Toast.LENGTH_LONG).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
