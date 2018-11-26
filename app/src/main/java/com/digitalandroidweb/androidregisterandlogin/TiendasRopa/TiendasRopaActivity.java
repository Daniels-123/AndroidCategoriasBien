package com.digitalandroidweb.androidregisterandlogin.TiendasRopa;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.Bares.BaresActivity;
import com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.ComidaChina.ComidaChinaActivity;
import com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.ComidaInternacional.ComidaInternacionalActivity;
import com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.ComidaRapida.ComidaRapidaActivity;
import com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.ComidaTradicional.ComidaTradicionalActivity;
import com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.ComidaVegetariana.ComidaVegetarianaActivity;
import com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.ComidasPostresActivity;
import com.digitalandroidweb.androidregisterandlogin.R;
import com.digitalandroidweb.androidregisterandlogin.TiendasRopa.Bebes.BebesActivity;


public class TiendasRopaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiendas_ropa);
        this.setTitle(R.string.tienda_ropa);
        setupActionBar();
        Button bebes = findViewById(R.id.bebes);
       // Button comidachina= findViewById(R.id.comida_china);
       // Button comidainternacional = findViewById(R.id.comida_internacional);
       // Button comidarapida = findViewById(R.id.comida_rapida);
       // Button comidatradicional = findViewById(R.id.comida_tradicional);
       // Button comidavegeta = findViewById(R.id.comida_vegetariana);

        bebes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TiendasRopaActivity.this, BebesActivity.class));
            }
        });


       /* comidachina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TiendasRopaActivity.this, ComidaChinaActivity.class));
            }
        });
        comidainternacional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TiendasRopaActivity.this, ComidaInternacionalActivity.class));
            }
        });
        comidarapida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TiendasRopaActivity.this, ComidaRapidaActivity.class));
            }
        });
        comidatradicional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TiendasRopaActivity.this, ComidaTradicionalActivity.class));
            }
        });
        comidavegeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TiendasRopaActivity.this, ComidaVegetarianaActivity.class));
            }
        });
*/

    }


    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);


        }
    }
}
