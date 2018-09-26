package com.example.user.proyecto_final_b;


import android.content.Context;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.proyecto_final_b.conexion.ConexionBD;
import com.example.user.proyecto_final_b.dao.Dao_Nota;
import com.example.user.proyecto_final_b.data.Nota;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Eliminar_Notas extends Fragment {
    private static final int MENU_ITEM_ELIMINAR = 10;
    String pTitulo;
    String pId;
    TextView etTituloEliminar;

    private Dao_Nota dao_nota;

    public Fragment_Eliminar_Notas() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dao_nota = ConexionBD.getAppDataBase(context).dao_Nota();

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!= null){
            pTitulo = getArguments().getString("pTitulo");
            pId = getArguments().getString("pId");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__eliminar__notas, container, false);
        setHasOptionsMenu(true);
        etTituloEliminar = (TextView)view.findViewById(R.id.etTituloEliminar);

        etTituloEliminar.setText(pTitulo);


        Toast.makeText(getActivity(),"Registro Encontrado" ,Toast.LENGTH_SHORT).show();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
            menu.add(0, MENU_ITEM_ELIMINAR, Menu.NONE, "Eliminar")
                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ITEM_ELIMINAR:
                int intIdPrueba = Integer.parseInt(pId);
                Nota nota = new Nota();
                nota.setIdNota(intIdPrueba);
                dao_nota.deleteNota(nota);
                Toast.makeText(getActivity(),"Eliminado",Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
