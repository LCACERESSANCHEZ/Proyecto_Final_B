package com.example.user.proyecto_final_b;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class Activity_Editar_Notas extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String id = getIntent().getStringExtra("pId");
        String titulo = getIntent().getStringExtra("pTitulo");
        String activo = getIntent().getStringExtra("pActivo");


        Fragment_Editar_Notas fragment = new Fragment_Editar_Notas();
        Bundle bundle = new Bundle();
        bundle.putString("pId", id);
        bundle.putString("pTitulo", titulo);
        bundle.putString("pActivo", activo);
        fragment.setArguments(bundle);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(android.R.id.content,fragment).commit();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

}
