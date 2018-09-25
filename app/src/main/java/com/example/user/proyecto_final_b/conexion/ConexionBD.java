package com.example.user.proyecto_final_b.conexion;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.user.proyecto_final_b.dao.Dao_Nota;
import com.example.user.proyecto_final_b.data.Nota;

@Database(entities = {Nota.class}, version = 1)
public abstract class ConexionBD extends RoomDatabase {

    private static ConexionBD INSTANCE;
    public abstract Dao_Nota dao_Nota();

    public static ConexionBD getAppDataBase(Context context) {
        if (null == INSTANCE) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ConexionBD.class, "NOTAS_BD").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

}
