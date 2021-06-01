package com.example.rutasasturias.AsymcClasses;

import android.os.AsyncTask;

import com.example.rutasasturias.Ruta;
import com.example.rutasasturias.RutasAsturiasFavDAO;

public class deleteRutaAsync extends AsyncTask<Ruta, Void, Void> {

    private final RutasAsturiasFavDAO mDAO;

    public deleteRutaAsync(RutasAsturiasFavDAO dao) {
        this.mDAO = dao;
    }

    @Override
    protected Void doInBackground(Ruta... rutas) {
        mDAO.deleteRuta(rutas[0].getNombre());
        return null;
    }
}
