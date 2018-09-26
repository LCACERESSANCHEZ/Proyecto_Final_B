package com.example.user.proyecto_final_b;


import android.content.Context;
import android.os.Bundle;

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
public class Fragment_Editar_Notas extends Fragment {
    private static final int MENU_ITEM_ELIMINAR = 10;
    private TextView tvItemEditarId;
    private TextView tvItemEditarTitulo;
    private String pTitulo,pId,pActivo;
    private Dao_Nota dao_nota;


    public Fragment_Editar_Notas() {
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
            pActivo = getArguments().getString("pActivo");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__editar__notas, container, false);
        tvItemEditarId = (TextView)view.findViewById(R.id.tvItemEditarId);
        tvItemEditarTitulo = (TextView)view.findViewById(R.id.tvItemEditarTitulo);
        tvItemEditarTitulo.setText(pTitulo);
        setHasOptionsMenu(true);

        Toast.makeText(getActivity(),"Registro Encontrado" ,Toast.LENGTH_SHORT).show();
        return view;
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.add(0, MENU_ITEM_ELIMINAR, Menu.NONE, "Editar")
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ITEM_ELIMINAR:
                int v_tvItemEditarId = Integer.parseInt(pId.toString());
                String v_tvItemEditarTitulo = tvItemEditarTitulo.getText().toString();
                int v_activo = Integer.parseInt(pActivo.toString());

                Nota nota = new Nota();
                nota.setIdNota(v_tvItemEditarId);
                nota.setNombreNota(v_tvItemEditarTitulo);
                nota.setActivoNotas(v_activo);

                dao_nota.updateNota(nota);
                Toast.makeText(getActivity(),"Editado",Toast.LENGTH_SHORT).show();
                tvItemEditarId.setText("");
                tvItemEditarTitulo.setText("");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
