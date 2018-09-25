package com.example.user.proyecto_final_b.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.user.proyecto_final_b.data.Nota;

import java.util.List;

@Dao
public interface Dao_Nota {

    @Insert
    public void addNota(Nota nota);

    @Query("SELECT * FROM Notas")
    public List<Nota> getNota();

    @Delete
    public void deleteNota (Nota nota);

    @Update
    public void updateNota (Nota nota); 

}
