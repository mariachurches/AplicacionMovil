package com.example.rutasasturias;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.rutasasturias.AsymcClasses.allRutaAsync;
import com.example.rutasasturias.AsymcClasses.deleteAllAsync;
import com.example.rutasasturias.AsymcClasses.deleteRutaAsync;
import com.example.rutasasturias.AsymcClasses.insertRutaAsync;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private WebService webService;
    private MutableLiveData<ArrayList<RutasAsturias>> RutasAsturiasMutableLiveData;
    private RutasAsturiasFavDAO favsDAO;
    private List<Ruta> rutasfavs;

    public Repository(Context c)
    {
        if(RutasAsturiasMutableLiveData == null)
        {
            Log.d("contsMaria","null");
            RutasAsturiasMutableLiveData = new MutableLiveData<ArrayList<RutasAsturias>>();
        }
        favsDAO = RoomDatabaseAsturias.getDatabase(c).rutasDAO();
        this.webService = new WebService(c);
    }

    public void updateRutasAsturiasData()
    {
        this.RutasAsturiasMutableLiveData = this.webService.getRutasAsturias();
    }

    public synchronized MutableLiveData<ArrayList<RutasAsturias>> getRutasAsturiasList()
    {
        if(RutasAsturiasMutableLiveData.getValue() == null)
        {
            RutasAsturiasMutableLiveData = new MutableLiveData<ArrayList<RutasAsturias>>();
            this.RutasAsturiasMutableLiveData = this.webService.getRutasAsturias();
        }
        else
        {
        }
        return this.RutasAsturiasMutableLiveData;
    }

    public void meterRutaEnFavoritos(Ruta ruta)
    {
        new insertRutaAsync(favsDAO).execute(ruta);
    }
    public void borrarRutadeFavoritos(Ruta ruta)
    {
        new deleteRutaAsync(favsDAO).execute(ruta);
    }
    public void rutasFavoritos()
    {
        new allRutaAsync(favsDAO, this).execute();
    }
    public void setRutasFav(List<Ruta> result)
    {
        rutasfavs = result;
    }
    public void deleleteAll()
    {
        new deleteAllAsync(favsDAO).execute();
    }

    public List<Ruta> getRutasFav()
    {
        if(rutasfavs == null)
        {
            rutasFavoritos();
        }
        return rutasfavs;
    }

}
