package com.digitalandroidweb.androidregisterandlogin.ComidasYpostres;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.Bares.BaresActivity;
import com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.ComidaChina.ComidaChinaActivity;
import com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.ComidaChina.ComidaChinaDetail;
import com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.ComidaInternacional.ComidaInternacionalActivity;
import com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.ComidaRapida.ComidaRapidaActivity;
import com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.ComidaTradicional.ComidaTradicionalActivity;
import com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.ComidaVegetariana.ComidaVegetarianaActivity;
import com.digitalandroidweb.androidregisterandlogin.R;

public class ComidasPostresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comidas_postres);
        this.setTitle(R.string.comidas_y_postres);
        setupActionBar();

        Button bares = findViewById(R.id.bares);
        Button comidachina= findViewById(R.id.comida_china);
        Button comidainternacional = findViewById(R.id.comida_internacional);
        Button comidarapida = findViewById(R.id.comida_rapida);
        Button comidatradicional = findViewById(R.id.comida_tradicional);
        Button comidavegeta = findViewById(R.id.comida_vegetariana);

        comidachina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ComidasPostresActivity.this, ComidaChinaActivity.class));
            }
        });
        bares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ComidasPostresActivity.this, BaresActivity.class));
            }
        });
        comidainternacional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ComidasPostresActivity.this, ComidaInternacionalActivity.class));
            }
        });
        comidarapida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ComidasPostresActivity.this, ComidaRapidaActivity.class));
            }
        });
        comidatradicional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ComidasPostresActivity.this, ComidaTradicionalActivity.class));
            }
        });
        comidavegeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ComidasPostresActivity.this, ComidaVegetarianaActivity.class));
            }
        });


    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);


        }
    }

}
