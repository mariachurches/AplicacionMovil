package com.example.rutasasturias;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;

public class RutasAsturiasViewModel extends AndroidViewModel {

    private Repository repository;
    private LiveData<ArrayList<RutasAsturias>> rutas;

    public RutasAsturiasViewModel(@NonNull Application application)
    {
        super(application);
        Log.d("TAGG2", "Rutas ");
        repository = new Repository(application.getApplicationContext());
        rutas = repository.getRutasAsturiasList();
    }

    public LiveData<ArrayList<RutasAsturias>> getRutas()
    {

        rutas = repository.getRutasAsturiasList();
        return rutas;
    }

    public RutasAsturias getRuta(int pos)
    {

        return (RutasAsturias)rutas.getValue().get(pos);
    }

    public void updateRutasAsturias()
    {
        repository.updateRutasAsturiasData();
    }
}
