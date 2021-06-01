package com.example.rutasasturias.AsymcClasses;

import android.os.AsyncTask;
import android.util.Log;

import com.example.rutasasturias.Repository;
import com.example.rutasasturias.RoomDatabaseAsturias;
import com.example.rutasasturias.Ruta;
import com.example.rutasasturias.RutasAsturias;
import com.example.rutasasturias.RutasAsturiasFavDAO;

import java.util.List;

public class allRutaAsync extends AsyncTask<Void, Void, List<Ruta>> {

    private final RutasAsturiasFavDAO mDAO;
    private final Repository r;

    public allRutaAsync(RutasAsturiasFavDAO db, Repository instance) {
        this.mDAO = db;
        r=instance;
    }

    @Override
    protected List<Ruta> doInBackground(Void... voids) {
        return mDAO.getAllRutasFav();
    }

    protected void onPostExecute(List<Ruta> result) {
        // Actualiza los datos del adaptador
        r.setRutasFav(result);
    }
}