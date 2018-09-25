package com.example.user.proyecto_final_b.data;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Notas")
public class Nota {

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "id_Notas")
    private int idNota;

    @ColumnInfo(name = "nombre_Notas")
    private String nombreNota;

    @ColumnInfo(name = "activo_Notas")
    private int activoNotas;





    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public String getNombreNota() {
        return nombreNota;
    }

    public void setNombreNota(String nombreNota) {
        this.nombreNota = nombreNota;
    }

    public int getActivoNotas() {
        return activoNotas;
    }

    public void setActivoNotas(int activoNotas) {
        this.activoNotas = activoNotas;
    }

}
