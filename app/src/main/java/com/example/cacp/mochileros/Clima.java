package com.example.cacp.mochileros;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;

public class Clima extends Activity {

    private ListView lvregion;
    private WebView wvclima;
    private ProgressDialog prgdclima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // Display a indeterminate progress bar on title bar
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

        this.setContentView(R.layout.clima);

        this.lvregion = (ListView) findViewById(R.id.listView);
        this.wvclima = (WebView) findViewById(R.id.webView);
        wvclima.setBackgroundColor(0x00000000);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Arica","http://www.meteored.cl/tiempo-en_Arica-America+Sur-Chile-Tarapaca-SCAR-1-18563.html"));
        items.add(new Item("Iquique","http://www.meteored.cl/tiempo-en_Iquique-America+Sur-Chile-Tarapaca-SCDA-1-18257.html"));
        items.add(new Item("Antofagasta","http://www.meteored.cl/tiempo-en_Antofagasta-America+Sur-Chile-Antofagasta--1-135102.html"));
        items.add(new Item("Copiapo","http://www.meteored.cl/tiempo-en_Copiapo-America+Sur-Chile-Atacama-SCAT-1-18566.html"));
        items.add(new Item("La Serena","http://www.meteored.cl/tiempo-en_La+Serena-America+Sur-Chile-Coquimbo-SCSE-1-18575.html"));
        items.add(new Item("Valparaíso","http://www.meteored.cl/tiempo-en_Valparaiso-America+Sur-Chile-Valparaiso--1-18577.html"));
        items.add(new Item("RM","http://www.meteored.cl/tiempo-en_Santiago+de+Chile-America+Sur-Chile-Region+Metropolitana+de+Santiago-SCEL-1-18578.html"));
        items.add(new Item("Rancagua","http://www.meteored.cl/tiempo-en_Talca-America+Sur-Chile-Maule--1-18263.html"));
        items.add(new Item("Talca", "http://www.meteored.cl/tiempo-en_Talca-America+Sur-Chile-Maule--1-18263.html"));
        items.add(new Item("Concepcion", "http://www.meteored.cl/tiempo-en_Concepcion-America+Sur-Chile-Biobio-SCIE-1-18576.html"));
        items.add(new Item("Temuco", "http://www.meteored.cl/tiempo-en_Temuco-America+Sur-Chile-Araucania-SCTC-1-18267.html"));
        items.add(new Item("Valdivia", "http://www.meteored.cl/tiempo-en_Valdivia-America+Sur-Chile-Los+Lagos--1-18266.html"));
        items.add(new Item("Pto Montt", "http://www.meteored.cl/tiempo-en_Puerto+Montt-America+Sur-Chile-Los+Lagos-SCTE-1-18567.html"));
        items.add(new Item("Coyhaique", "http://www.meteored.cl/tiempo-en_Coyhaique-America+Sur-Chile-Aisen+del+General+Carlos+Ibanez+del+Campo-SCBA-1-18188.html"));
        items.add(new Item("Pta Arenas", "http://www.meteored.cl/tiempo-en_Punta+Arenas-America+Sur-Chile-Magallanes+y+de+la+Antartica+Chilena-SCCI-1-18570.html"));


        // Sets the data behind this ListView
        this.lvregion.setAdapter(new ItemAdapter(this, items));

        // Register a callback to be invoked when an item in this AdapterView
        // has been clicked
        lvregion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int position, long arg) {
                // Sets the visibility of the indeterminate progress bar in the
                // title


                setProgressBarIndeterminateVisibility(true);
                // Show progress dialog
                prgdclima = ProgressDialog.show(Clima.this,
                        "Cargando Clima", "Espere un momento!");

                // Tells JavaScript to open windows automatically.

                wvclima.getSettings().setJavaScriptEnabled(true);
                // Sets our custom WebViewClient.
                wvclima.setWebViewClient(new myWebClient());
                // Loads the given URL
                Item item = (Item) lvregion.getAdapter().getItem(position);
                wvclima.loadUrl(item.getUrl());
            }
        });

    }

    private class myWebClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // Load the given URL on our WebView.
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // Cuando la pagina se finaliza
            super.onPageFinished(view, url);
            setProgressBarIndeterminateVisibility(false);
            prgdclima.dismiss();
        }
    }
}

/*
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Clima extends Activity {
    ListView listView ;
int opc=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clima);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] values = new String[] {
                "XV     Arica y Parinacota",
                "I      Tarapaca",
                "II     Antofagasta",
                "III    Atacama",
                "IV     Coquimbo",
                "V      Valparaiso",
                "RM     Metropolitana",
                "VI     O´higgins",
                "VII    Maule",
                "VIII   Bio-Bio",
                "IX     La Araucania",
                "XIV    Los Rios",
                "X      Los Lagos",
                "XI     Aysén",
                "XII    Magallanes",

        };


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                opc = itemPosition;


            }


        });
    }
    public void irweb(String d){
        Uri uri = Uri.parse(d);
        Intent intentNav = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intentNav);

    }


}*/