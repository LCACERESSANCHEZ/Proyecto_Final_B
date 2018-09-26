package com.example.user.proyecto_final_b.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;



@Entity(tableName = "Notas_Detalles",
        foreignKeys = @ForeignKey(entity = Nota.class,
            parentColumns = "id_Notas",
            childColumns = "id_NotasF",
            onDelete = ForeignKey.CASCADE))

public class Nota_Detalle {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_Notas_Detalles")
    private int idNota_Detalle;

    @ColumnInfo(name = "detalle")
    private String detalle;

    @ColumnInfo(name = "id_NotasF")
    private int idNotaF;





    public int getIdNota_Detalle() {
        return idNota_Detalle;
    }

    public void setIdNota_Detalle(int idNota_Detalle) {
        this.idNota_Detalle = idNota_Detalle;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getIdNotaF() {
        return idNotaF;
    }

    public void setIdNotaF(int idNotaF) {
        this.idNotaF = idNotaF;
    }


}
