package com.example.cacp.mochileros;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/**
 * Created by CACP on 01-10-2015.
 */
public class MiPosicion  implements LocationListener {


    public static double lat, log;
    public static boolean statusGPS;
    public static Location coordenadas;


    @Override
    public void onLocationChanged(Location loc) {
        loc.getLatitude();
        loc.getLongitude();
        lat =loc.getLatitude();
        log =loc.getLongitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
    statusGPS=true;
    }

    @Override
    public void onProviderDisabled(String provider) {
        statusGPS=false;
    }
}
