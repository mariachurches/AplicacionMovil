package com.example.rutasasturias.AsymcClasses;

import android.os.AsyncTask;

import com.example.rutasasturias.Ruta;
import com.example.rutasasturias.RutasAsturiasFavDAO;

public class deleteAllAsync extends AsyncTask<Ruta, Void, Void> {

    private final RutasAsturiasFavDAO mDAO;

    public deleteAllAsync(RutasAsturiasFavDAO dao) {
        this.mDAO = dao;
    }

    @Override
    protected Void doInBackground(Ruta... rutas) {
        mDAO.deleteAll();
        return null;
    }
}