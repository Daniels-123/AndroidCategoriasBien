package com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.CrepesPizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.digitalandroidweb.androidregisterandlogin.R;
import com.squareup.picasso.Picasso;

import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_DESCRIPTION;
import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_DIRECCION;
import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_NOMBRE;
import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_TELEFONO;
import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_URL;


public class CrepesPizzeriaDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_crepes_pizzeria);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String nombre = intent.getStringExtra(EXTRA_NOMBRE);
        String descripcion = intent.getStringExtra(EXTRA_DESCRIPTION);
        String direccion = intent.getStringExtra(EXTRA_DIRECCION);
        String telefono = intent.getStringExtra(EXTRA_TELEFONO);

        this.setTitle(nombre);

        ImageView imageView = findViewById(R.id.image_view_detail_crepes_pizzeria);
        TextView textViewNombre = findViewById(R.id.text_view_nombre_det_crepes_pizzeria);
        TextView textViewDesc = findViewById(R.id.text_view_descrip_det_crepes_pizzeria);
        TextView textViewDire = findViewById(R.id.text_view_direccion_det_crepes_pizzeria);
        TextView textViewTel = findViewById(R.id.text_view_telefono_det_crepes_pizzeria);


        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);
        textViewNombre.setText(nombre);
        textViewDesc.setText(descripcion);
        textViewDire.setText(direccion);
        textViewTel.setText(telefono);
    }
}
