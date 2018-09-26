package com.example.user.proyecto_final_b.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.example.user.proyecto_final_b.data.Nota;
import com.example.user.proyecto_final_b.data.Nota_Detalle;

@Dao
public interface Dao_NotaDetalle {

    @Insert
    public void addNota_Detalle(Nota_Detalle nota_detalle);
}
