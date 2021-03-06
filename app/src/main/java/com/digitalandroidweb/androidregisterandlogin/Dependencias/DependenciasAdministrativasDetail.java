package com.digitalandroidweb.androidregisterandlogin.Dependencias;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.digitalandroidweb.androidregisterandlogin.R;
import com.squareup.picasso.Picasso;

import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_DESCRIPTION;
import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_DIRECCION;
import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_LATITUD;
import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_LONGITUD;
import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_NOMBRE;
import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_TELEFONO;
import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_URL;
import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_URL2;
import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_URL3;


public class DependenciasAdministrativasDetail extends AppCompatActivity {


    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        final String imageUrl = intent.getStringExtra(EXTRA_URL);
        final String imageUrl2 = intent.getStringExtra(EXTRA_URL2);
        final String imageUrl3 = intent.getStringExtra(EXTRA_URL3);
        final String nombre = intent.getStringExtra(EXTRA_NOMBRE);
        final String descripcion = intent.getStringExtra(EXTRA_DESCRIPTION);
        final String direccion = intent.getStringExtra(EXTRA_DIRECCION);
        final String latitud = intent.getStringExtra(EXTRA_LATITUD);
        final String longitud = intent.getStringExtra(EXTRA_LONGITUD);
        final String telefono = intent.getStringExtra(EXTRA_TELEFONO);

        this.setTitle(nombre);
        final ImageView imageView = findViewById(R.id.image_view_detail);
        final ImageView imageView2 = findViewById(R.id.image_view_detail2);
        final ImageView imageView3 = findViewById(R.id.image_view_detail3);
        //final TextView textViewNombre = findViewById(R.id.text_view_nombre_det);
        final TextView textViewDesc = findViewById(R.id.text_view_descrip_det);
        final TextView textViewDire = findViewById(R.id.text_view_direccion_det);
        final Button textViewTel = findViewById(R.id.text_view_telefono_det);

        //Button button2 = findViewById(R.id.prueba);
        Button button = findViewById(R.id.compartir);
        Button mapa = findViewById(R.id.mapa);



        Picasso.with(this).load(imageUrl)
                .priority(Picasso.Priority.HIGH)
                .fit().
               // resize(100,100).
                centerInside().
                into(imageView);



        Picasso.with(this).load(imageUrl2)

                .fit().
          //      resize(400,400).
                 // resize(100,100).
                  centerInside().

                into(imageView2);
        Picasso.with(this).load(imageUrl3)

                .fit().
               // resize(100,100).
            //    resize(400,400).
                centerInside().
                into(imageView3);


      //  Picasso.with(this).startSlideshow(10000, imageUrl, imageUrl2);
        //Glide.with(this).load(imageUrl).into(imageView);

        //Glide.with(this).load(imageUrl).into(imageView);
        //textViewNombre.setText(nombre);
        textViewDesc.setText(descripcion);
        textViewDire.setText(direccion);
        // textViewTel.setTextColor(getResources().getColor(R.color.verde));
       // textViewTel.setPaintFlags(textViewTel.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
       // textViewTel.setText(telefono);

        textViewTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                textViewTel.setTextColor(getResources().getColor(R.color.crema));
                Uri uri = Uri.parse("tel:" + telefono);
                Intent intent1 = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent1);

                startActivity(intent1);

            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageIntent = new Intent(Intent.ACTION_SEND);
                Uri imageUri = Uri.parse("http://openfirespark.000webhostapp.com/LOGOS/Guia%20Turistica/guidez11.png");
                imageIntent.setType("image/*");
                imageIntent.putExtra(Intent.EXTRA_STREAM, String.valueOf(imageUri));
                startActivity(imageIntent);            }
        });


        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DependenciasAdministrativasDetail.this, MapsActivity2.class);

                String Mensaje = latitud;
                String Mensaje2 = longitud;
                String Mensaje3 = nombre;
                String Mensaje4 = direccion;
                i.putExtra("latitud", latitud);
                i.putExtra("longitud", longitud);
                i.putExtra("nombre", nombre);
                i.putExtra("descripcion", descripcion);

                startActivity(i);
                // startActivity( new Intent(DependenciasAdministrativasDetail.this, MapsActivity2.class));
            }
        });



    }






}
