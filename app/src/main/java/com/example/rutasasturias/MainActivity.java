package com.example.rutasasturias;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferencias = getSharedPreferences("favoritos",Context.MODE_PRIVATE);
        Toast.makeText(getApplicationContext(), "Bienvenido a la aplicacion de rutas de asturias ", Toast.LENGTH_LONG).show();
    }


}