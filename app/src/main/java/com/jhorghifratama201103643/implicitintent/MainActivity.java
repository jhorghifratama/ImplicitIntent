package com.jhorghifratama201103643.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tampilTelepon(View view) {
        Intent TeleponIntent = new Intent(Intent.ACTION_DIAL);
        startActivity(TeleponIntent);
    }

    public void tampilSms(View view) {
        Intent smsIntent = new Intent(Intent.ACTION_DIAL);
        smsIntent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        startActivity(smsIntent);
    }

    public void tampilKalender (View view) {
        Intent KalenderIntent = new Intent(Intent.ACTION_MAIN);
        KalenderIntent.addCategory(Intent.CATEGORY_APP_CALENDAR);
        startActivity(KalenderIntent);
    }

    public void tampilbrowser (View view) {
        Intent BrowserIntent = new Intent(Intent.ACTION_MAIN);
        BrowserIntent.addCategory(Intent.CATEGORY_APP_BROWSER);
        startActivity(BrowserIntent);
    }

    public void tampilKalkulator (View view)
    {
        ArrayList<HashMap<String,Object>> items = new ArrayList<HashMap<String, Object>>();
        final PackageManager pm = getPackageManager();

        List<PackageInfo> packs = pm.getInstalledPackages(0);
        for (PackageInfo pi : packs)
        {
            String packageName = pi.packageName.toString();

            String packageName_LowerCase = packageName.toLowerCase();

            if (packageName_LowerCase.contains("calcul"))
            {
                HashMap<String, Object> map = new HashMap<String, Object>();

                map.put("appName", pi.applicationInfo.loadLabel(pm));
                map.put("packageName", pi.packageName);

                items.add(map);
            }
        }
        int intem_size = items.size();

        if (intem_size >= 1)
        {
            String packageName = (String)  items.get(0).get("packageName");

            Intent i = pm.getLaunchIntentForPackage(packageName);

            if (i != null)
            {
                startActivity(i);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Tidak ditemukan aplikasi kalkulator", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void tampilGaleri(View view) {
        Intent galeriIntent = new Intent(Intent.ACTION_MAIN);
        galeriIntent.addCategory(Intent.CATEGORY_APP_GALLERY);
        startActivity(galeriIntent);
    }

    public void tampilWifi (View view) {
        Intent WifiIntent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        startActivity(WifiIntent);
    }

    public void tampilSound (View view) {
        Intent SoundIntent = new Intent(Settings.ACTION_SOUND_SETTINGS);
        startActivity(SoundIntent);
    }

    public void tampilAirplane (View view) {
        Intent AirplaneIntent = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
        startActivity(AirplaneIntent);
    }

    public void tampilAplikasi (View view) {
        Intent AplikasiIntent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
        startActivity(AplikasiIntent);
    }

    public void tampilBluetooth (View view) {
        Intent BluetoothIntent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        startActivity(BluetoothIntent);
    }
}