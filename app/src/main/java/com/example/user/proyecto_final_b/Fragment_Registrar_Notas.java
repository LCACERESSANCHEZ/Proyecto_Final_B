package com.example.user.proyecto_final_b;

import android.content.Context;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.proyecto_final_b.conexion.ConexionBD;
import com.example.user.proyecto_final_b.dao.Dao_Nota;
import com.example.user.proyecto_final_b.data.Nota;


public class Fragment_Registrar_Notas extends Fragment {

    private EditText etTitulo;
    private Button button2;
    private Dao_Nota dao_nota;

    private String pTitulo;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dao_nota = ConexionBD.getAppDataBase(context).dao_Nota();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__registrar__notas, container, false);

        etTitulo = (EditText)view.findViewById(R.id.etTitulo);
        button2 = (Button)view.findViewById(R.id.button2);
        setHasOptionsMenu(true);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AGREGAR UNA LISTAR
            }
        });

        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_guardar) {
            String nombreNota = etTitulo.getText().toString();
            int activo = 1;

            Nota nota = new Nota();
            nota.setNombreNota(nombreNota);
            nota.setActivoNotas(activo);

            dao_nota.addNota(nota);

            etTitulo.setText("");

            Toast.makeText(getActivity(),"Nota Guardada" ,Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





}
