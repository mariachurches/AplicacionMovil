package com.example.rutasasturias;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;

@Database(entities = {Ruta.class}, version = 1, exportSchema=false)
public abstract class RoomDatabaseAsturias extends RoomDatabase {

    public abstract RutasAsturiasFavDAO rutasDAO();
    private static RoomDatabaseAsturias INSTANCE;

    public static RoomDatabaseAsturias getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDatabaseAsturias.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDatabaseAsturias.class, "rutas_database").fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new Callback() {
        // Se podría usar onCreate()
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            // Código para introducir datos iniciales en la base de datos
        }
    };
}
