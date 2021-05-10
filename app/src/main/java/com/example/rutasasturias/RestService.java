package com.example.rutasasturias;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestService {

    @GET("~arias/json/Rutas.json")
    Call<ArrayList<RutasAsturias>> getInfo();

}
