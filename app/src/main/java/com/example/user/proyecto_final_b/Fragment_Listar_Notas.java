package com.example.user.proyecto_final_b;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.user.proyecto_final_b.conexion.ConexionBD;
import com.example.user.proyecto_final_b.dao.Dao_Nota;
import com.example.user.proyecto_final_b.data.Nota;
import com.example.user.proyecto_final_b.util.Adapter_Nota;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Listar_Notas extends Fragment {
    private RecyclerView rcvNotas1;
    private List<Nota> notaList;
    private Adapter_Nota adapter;
    private Dao_Nota dao_nota;

    public Fragment_Listar_Notas() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dao_nota = ConexionBD.getAppDataBase(context).dao_Nota();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_fragment__listar__notas, container, false);

        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Activity_Registrar_Notas.class);
                startActivity(intent);
            }
        });


        notaList = dao_nota.getNota();
        adapter = new Adapter_Nota(notaList);


        rcvNotas1 = view.findViewById(R.id.rcvNotas1);
        rcvNotas1.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvNotas1.setHasFixedSize(true);
        rcvNotas1.setAdapter(adapter);

        return view;
    }



}
