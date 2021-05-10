package com.example.rutasasturias;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class Repository {

    private WebService webService;
    private MutableLiveData<ArrayList<RutasAsturias>> RutasAsturiasMutableLiveData;

    public Repository(Context c)
    {
        RutasAsturiasMutableLiveData = new MutableLiveData<ArrayList<RutasAsturias>>();
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
            Log.d("REPOOSITORYYY", "era nulllllll");
            RutasAsturiasMutableLiveData = new MutableLiveData<ArrayList<RutasAsturias>>();
            this.RutasAsturiasMutableLiveData = this.webService.getRutasAsturias();
        }
        else
        {
            Log.d("REPOOSITORYYY", "noooooooo era nulllllll" + RutasAsturiasMutableLiveData.getValue().size());

        }
        return this.RutasAsturiasMutableLiveData;
    }

}
