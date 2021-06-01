package com.example.rutasasturias;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class RutasAsturiasViewModel extends AndroidViewModel {

    private List<Ruta> rf;
    private Repository repository;
    private MutableLiveData<ArrayList<RutasAsturias>> rutas;
    private MutableLiveData<ArrayList<RutasAsturias>> rutasCopy;
    private MutableLiveData<ArrayList<RutasAsturias>> rutasFavoritas;
    private static RutasAsturiasViewModel ViewModel;



    public RutasAsturiasViewModel(@NonNull Application application)
    {
        super(application);
        repository = new Repository(application.getApplicationContext());
        rutas = repository.getRutasAsturiasList();
        rutasCopy = repository.getRutasAsturiasList();
        rutasFavoritas = new MutableLiveData<ArrayList<RutasAsturias>>();
        putRutasFavs();
        //repository.deleleteAll();
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

    public void updateRutasAsturias(boolean fav)
    {
        if(fav==false)
        {
            repository.updateRutasAsturiasData();
        }
    }

    public LiveData<ArrayList<RutasAsturias>> find(String name, String type, String dif)
    {
        ArrayList<RutasAsturias> prueba = new ArrayList<RutasAsturias>();
        prueba = rutas.getValue();
        rutasCopy.setValue(rutas.getValue());
        rutas.setValue(new ArrayList<RutasAsturias>());

        for(int i =0; i < prueba.size(); i++)
        {
            RutasAsturias RA = prueba.get(i);
            if(RA.getNombre().contains(name) &&
                    RA.getTipoDeRecorrido().contains(type) &&
                    ( dif.contains(RA.getDificultad().toString()) || dif=="" )) rutas.getValue().add(RA);
        }
        return rutas;
    }

    public LiveData<ArrayList<RutasAsturias>> filter(String name, String type, String dif)
    {
        rutas.setValue(rutasCopy.getValue());
        for (RutasAsturias RA : rutas.getValue())
        {
            if(!(RA.getNombre().contains(name) &&
                    RA.getTipoDeRecorrido().contains(type) &&
                    ( dif.contains(RA.getDificultad().toString()) || dif=="" ))) rutas.getValue().remove(RA);
        }

        return rutas;
    }

    public void ponerFavoritos()
    {
        rf = repository.getRutasFav();
        parseRutaToRutasAsturias(rf);
        rutas.setValue(rutasFavoritas.getValue());
    }

    private void putRutasFavs()
    {
        repository.rutasFavoritos();
    }

    private void parseRutaToRutasAsturias(List<Ruta> rf)
    {
        ArrayList<RutasAsturias> moment = new ArrayList<RutasAsturias>();


        for(int i =0; i < rf.size(); i++)
        {
            for(int j =0; j < rutas.getValue().size(); j++) {
                if (rutas.getValue().get(j).getNombre().equals(rf.get(i).getNombre())) {
                   moment.add(rutas.getValue().get(j));
                   break;
                }
            }
        }

        rutasFavoritas.setValue(moment);
    }
}
