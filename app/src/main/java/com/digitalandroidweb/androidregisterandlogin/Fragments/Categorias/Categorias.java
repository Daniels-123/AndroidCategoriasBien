package com.digitalandroidweb.androidregisterandlogin.Fragments.Categorias;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.ComidasPostresActivity;
import com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas;
import com.digitalandroidweb.androidregisterandlogin.R;

public class Categorias extends Fragment implements NavigationView.OnNavigationItemSelectedListener {
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.categorias_fragment, container, false);
        Button btn = (Button) myView.findViewById(R.id.comi_postres);
        Button btn2 = (Button) myView.findViewById(R.id.tiendas_ropa);
        Button btn3 = (Button) myView.findViewById(R.id.tiendas_varias);
        Button btn4 = (Button) myView.findViewById(R.id.hogar_remodelacion);
        Button btn5 = (Button) myView.findViewById(R.id.mascotas_agro);
        Button btn6 = (Button) myView.findViewById(R.id.salud_belleza);
        Button btn7 = (Button) myView.findViewById(R.id.transporte);
        Button btn8 = (Button) myView.findViewById(R.id.mantenimiento);
        Button btn9= (Button) myView.findViewById(R.id.servicios);
        Button btn10 = (Button) myView.findViewById(R.id.turismo);
        Button btn11 = (Button) myView.findViewById(R.id.dependencias);
        Button btn12 = (Button) myView.findViewById(R.id.tiendas_calzado);
        Button btn13 = (Button) myView.findViewById(R.id.guia_turistica);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ComidasPostresActivity.class);
                startActivity(intent);
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), DependenciasAdministrativas.class);
                    startActivity(intent);
            }
        });

        return myView;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
