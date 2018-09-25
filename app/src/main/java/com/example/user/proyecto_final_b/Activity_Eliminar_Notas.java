package com.example.user.proyecto_final_b;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class Activity_Eliminar_Notas extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String titulo = getIntent().getStringExtra("pTitutlo");
        String ftitulo = titulo;
        Fragment_Registrar_Notas fragment_registrar_notas = new Fragment_Registrar_Notas();
        Bundle bundle = new Bundle();
        bundle.putString("pTitulo", ftitulo);
        fragment_registrar_notas.setArguments(bundle);

        Fragment fragment = new Fragment_Eliminar_Notas();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(android.R.id.content,fragment).commit();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
