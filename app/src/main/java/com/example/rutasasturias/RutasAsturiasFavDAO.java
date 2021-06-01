package com.example.rutasasturias;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RutasAsturiasFavDAO
{
    @Insert
    public void insertRuta(Ruta ruta);

    @Query("DELETE from ruta_table where nombre=:n")
    public void deleteRuta(String n);

    @Query("DELETE from ruta_table")
    public void deleteAll();

    @Query("SELECT * FROM ruta_table where nombre=:n")
    public Ruta getRuta(String n);

    @Query("SELECT * FROM ruta_table")
    public List<Ruta> getAllRutasFav();
}
