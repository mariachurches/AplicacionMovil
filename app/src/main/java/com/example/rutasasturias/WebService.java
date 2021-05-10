package com.example.rutasasturias;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebService {

    private RestService restService;
    private ArrayList<RutasAsturias> rutas;
    private MutableLiveData<ArrayList<RutasAsturias>> RutasAsturiasMutableLiveData;

    //private update

    public WebService(Context c) {
        RutasAsturiasMutableLiveData = new MutableLiveData<ArrayList<RutasAsturias>>();
        rutas = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://orion.edv.uniovi.es/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        this.restService = retrofit.create(RestService.class);

        updateRutasAsturias();




    }

    private void updateRutasAsturias()
    {
        this.restService.getInfo().enqueue(new Callback<ArrayList<RutasAsturias>>() {

            @Override
            public void onResponse(Call<ArrayList<RutasAsturias>> call, Response<ArrayList<RutasAsturias>> response)
            {

                ArrayList<RutasAsturias> rutasJSON = response.body();
                for(RutasAsturias o : rutasJSON)
                {
                    Log.d("WEBSERVICE", "aqui tamos de sizeeeeeeeeeeeeeeeeeeee " + o.toString());
                    Log.d("WEBSERVICE", "aqui tamos de sizeeeeeeeeeeeeeeeeeeee " + o.getNombre());
                    rutas.add(o);

                }
                RutasAsturiasMutableLiveData.setValue(rutas);
            }

            @Override
            public void onFailure(Call<ArrayList<RutasAsturias>> call, Throwable t) {
                Log.e("Error", t.toString());
            }

        });

    }

    public  MutableLiveData<ArrayList<RutasAsturias>> getRutasAsturias() {
        Log.d("WEBSERVICE","getRutasAsturias");
        if ( RutasAsturiasMutableLiveData.getValue() == null)
        {
            updateRutasAsturias();
            Log.d("WEBSERVICE","getRutasAsturias-update");
        }
        Log.d("WEBSERVICE","getRutasAsturiasReturn");
        return RutasAsturiasMutableLiveData;
    }
}