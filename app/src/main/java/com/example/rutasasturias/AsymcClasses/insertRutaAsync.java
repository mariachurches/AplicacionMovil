package com.example.rutasasturias.AsymcClasses;

import android.os.AsyncTask;
import android.util.Log;

import com.example.rutasasturias.Ruta;
import com.example.rutasasturias.RutasAsturiasFavDAO;

public class insertRutaAsync extends AsyncTask<Ruta, Void, Void> {

    private final RutasAsturiasFavDAO mDAO;

    public insertRutaAsync(RutasAsturiasFavDAO dao) {
        this.mDAO = dao;
    }

    @Override
    protected Void doInBackground(Ruta... rutas) {
        try {
            mDAO.insertRuta(rutas[0]);
        }catch(Exception e)
        {
            Log.d("MariaDatoYaExistia","Ruta repetida");
        }
        return null;
    }
}

