package com.example.user.proyecto_final_b.util;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.proyecto_final_b.Activity_Editar_Notas;
import com.example.user.proyecto_final_b.Activity_Eliminar_Notas;
import com.example.user.proyecto_final_b.Activity_Registrar_Notas;
import com.example.user.proyecto_final_b.R;
import com.example.user.proyecto_final_b.data.Nota;

import java.util.List;

public class Adapter_Nota extends RecyclerView.Adapter<Adapter_Nota.ViewHolder>  {

    private List<Nota> notaList;

    public Adapter_Nota(List<Nota> alumnoList) {
        this.notaList = alumnoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notas_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Nota nota = notaList.get(position);
        holder.tvItemId.setText("" + nota.getIdNota());
        holder.tvItemTitulo.setText(nota.getNombreNota().toString());
        holder.tvItemActivo.setText(""+nota.getActivoNotas());
        holder.setOnClickListeners();
    }

    @Override
    public int getItemCount() {
        return notaList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        Context context;
        TextView tvItemId;
        TextView tvItemTitulo;
        TextView tvItemActivo;
        ImageView btnItemEliminar;
        ImageView btnItemEditar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            tvItemId = itemView.findViewById(R.id.tvItemId);
            tvItemTitulo = itemView.findViewById(R.id.tvItemTitulo);
            tvItemActivo = itemView.findViewById(R.id.tvItemActivo);
            btnItemEliminar = itemView.findViewById(R.id.btnItemEliminar);
            btnItemEditar = itemView.findViewById(R.id.btnItemEditar);
        }

        void setOnClickListeners(){
            btnItemEliminar.setOnClickListener(this);
            btnItemEditar.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnItemEliminar:
                    Intent intentEliminar = new Intent(context, Activity_Eliminar_Notas.class);
                    intentEliminar.putExtra("pTitutlo",tvItemTitulo.getText());
                    context.startActivity(intentEliminar);
                    break;
                case R.id.btnItemEditar:
                    Intent intentEditar = new Intent(context, Activity_Editar_Notas.class);
                    context.startActivity(intentEditar);
                    break;
            }

        }
    }





}
