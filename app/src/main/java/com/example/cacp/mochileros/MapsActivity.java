package com.example.cacp.mochileros;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends android.support.v4.app.FragmentActivity {

    GoogleMap mMap,Map =null; // Might be null if Google Play services APK is not available.
    Location location=null;
    GPSTracker gps;
    Button btn_Abrir_Popup;
    Button  remover;
    LayoutInflater layoutInflater;
    View popupView;
    PopupWindow popupWindow;
    public String lugar;
    public String p;
     Marker punto;
    int c=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        Map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

        mMap.setOnMapClickListener(new OnMapClickListener() {
            public void onMapClick(LatLng point) {

                Projection proj = mMap.getProjection();
                Point coord = proj.toScreenLocation(point);

                Toast.makeText(
                        MapsActivity.this,
                        "Lugar Escogido\n" +
                                "Lat: " + point.latitude + "\n" +
                                "Lng: " + point.longitude + "\n",
                        Toast.LENGTH_SHORT).show();

            }
        });

        mMap.setOnMapLongClickListener(new OnMapLongClickListener() {
            public void onMapLongClick(LatLng point) {
                Projection proj = mMap.getProjection();
                Point coord = proj.toScreenLocation(point);

                if(c==1){
                    punto.remove();
                }

                punto = mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(point.latitude, point.longitude))
                                .title("Lugar pulsado")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))

                );
                mMap.setOnCameraChangeListener(new OnCameraChangeListener() {
                    public void onCameraChange(CameraPosition position) {
                    }
                });

                if(c==0){
                    c++;

                }

                mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

                    @Override
                    public void onInfoWindowClick(Marker marker) {

                        Intent i = new Intent(MapsActivity.this, Enviar_Lugar_Fin.class);
                        i.putExtra("titulo", marker.getTitle() + "");

                        startActivity(i);


                        Toast.makeText(MapsActivity.this, "Detalle de marcador:\n" + marker.getSnippet(), Toast.LENGTH_SHORT).show();

                    }
                });
            }


        });



        Map.setOnMarkerClickListener(new OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(
                        MapsActivity.this,
                        "Marcador pulsado:\n" +
                                marker.getTitle(),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        Map.addMarker(new MarkerOptions()

                .position(new LatLng(-33.508659, -70.771587))
                .title("Hospital Maipu")
                .snippet("CRC Maipu")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));


        Map.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.508659, -70.771587))
                        .title("Hospital Maipu")
                        .snippet("CRC Maipu")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))

        );

        Map.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.525279, -70.763234))
                        .title("Tia Lucy")
                        .snippet("Fuente de Soda")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))


        );

        Map.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.523079, -70.755816))
                        .title("Aereotel")
                        .snippet("Motel Aereotel")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))


        );

        Map.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.513025, -70.756545))
                        .title("Unimarc")
                        .snippet("Supermercado Unimarc")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))

        );
        Map.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.418493, -70.601307))
                        .title("McDonald")
                        .snippet("Restaurant comida Rapida")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))

        );




// GPS??

        LocationManager objloc = null;
        LocationListener objlist;
        String titulo;

        objloc = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        objlist = new MiPosicion();

        objloc.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, objlist);

                if(objloc.isProviderEnabled(LocationManager.GPS_PROVIDER)){

                    Toast t=Toast.makeText(this,"GPS Activado", Toast.LENGTH_SHORT);
                    t.show();
                }else{


                    AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
                    dialogo1.setTitle("Importante");
                    dialogo1.setMessage("¿Desea activar el GPS ?");
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

/////////////// finaliza gps

        LocationManager locman = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        location = locman.getLastKnownLocation(LocationManager.GPS_PROVIDER);



        GoogleMap mapa = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        mapa.setMyLocationEnabled(true);


                gps = new GPSTracker(MapsActivity.this);

                if(gps.canGetLocation()) {
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    LatLng actual = new LatLng(latitude,longitude);
                    CameraPosition camPos = new CameraPosition.Builder()
                            .target(actual)  	  //Centramos el mapa en DF
                            .zoom(15)         //Establecemos el zoom en 18
                            .bearing(45)      //Establecemos la orientación con el noreste arriba
                            .tilt(0)         //Bajamos el punto de vista de la cámara 70 grados
                            .build();

                    CameraUpdate camUpd3 =
                            CameraUpdateFactory.newCameraPosition(camPos);

                    mapa.animateCamera(camUpd3);

                } else {
                    gps.showSettingsAlert();
                }

            mapa.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    Toast.makeText(
                            MapsActivity.this,
                            "Marcador presionado:\n" +
                                    marker.getTitle(),
                            Toast.LENGTH_SHORT).show();

                    return false;
                }
            });

        mapa.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

            @Override
            public void onInfoWindowClick(Marker marker) {

                Intent i = new Intent(MapsActivity.this, Templo.class);
               i.putExtra("titulo", marker.getTitle() + "");

                startActivity(i);


                Toast.makeText(MapsActivity.this, "Detalle de marcador:\n" + marker.getSnippet(), Toast.LENGTH_SHORT).show();

            }
        });
    }
///////////////////punto mapa

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.menu_marcadores:
                mostrarMarcador(40.5, -3.5);
                break;
            case R.id.menu_lineas:
                mostrarLineas();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void mostrarMarcador(double lat, double lng)
    {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(lat, lng))
                .title("Pais: España"));
    }

    private void mostrarLineas()
    {
        //Dibujo con Lineas

     /*   PolylineOptions lineas = new PolylineOptions()
                .add(new LatLng(45.0, -12.0))
                .add(new LatLng(45.0, 5.0))
                .add(new LatLng(34.5, 5.0))
                .add(new LatLng(34.5, -12.0))
                .add(new LatLng(45.0, -12.0));

        lineas.width(8);
        lineas.color(Color.RED);

        mMap.addPolyline(lineas);*/


    }
   ///////////////////////////////////////////////////////////////////////////////////////////

    public void setLocation(Location loc) {
        //Obtener la direcci—n de la calle a partir de la latitud y la longitud
        if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
                if (!list.isEmpty()) {
                    Address address = list.get(0);
                    Toast.makeText(this, "Mi direccion es:" +address.getAddressLine(0), Toast.LENGTH_LONG).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

        @Override
        protected void onResume () {
            super.onResume();
            setUpMapIfNeeded();
        }


    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {

        onMapReady(mMap);


    }
    //  @Override
    public void onMapReady(GoogleMap map) {

        map.setMyLocationEnabled(true);
        map.getCameraPosition();

        map.setBuildingsEnabled(true);
        map.setTrafficEnabled(true);


        LatLng templo = new LatLng(-33.511564, -70.765183);
        map.addMarker(new MarkerOptions()
                .title("Templo")
                .snippet("Centro de Sacrificios y oscuridad.")
                .position(templo)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.templo))
                .flat(false) //imagen seca

        );
    }

    public void marcadoresOnclick(View v){

        //////////// pop up /////////////////////

     //  Intent formmap = new Intent(MapsActivity.this, Popup.class);
    //   startActivity(formmap);
mMap.clear();


//////////// fin pop up /////////////////////

    }
    public void aceptar() {
        Intent in = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(in);

    }

    public void cancelar() {

    }

}

