package com.digitalandroidweb.androidregisterandlogin.PromocionesFragment;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.digitalandroidweb.androidregisterandlogin.R;
import com.squareup.picasso.Picasso;

import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_DESCRIPTION;
import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_DIRECCION;
import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_NOMBRE;
import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_TELEFONO;
import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_URL;


public class PromocionesDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_promociones);

        Intent intent = getIntent();
        final String imageUrl = intent.getStringExtra(EXTRA_URL);
        String nombre = intent.getStringExtra(EXTRA_NOMBRE);
        String descripcion = intent.getStringExtra(EXTRA_DESCRIPTION);
        String direccion = intent.getStringExtra(EXTRA_DIRECCION);
        final String telefono = intent.getStringExtra(EXTRA_TELEFONO);

        this.setTitle(nombre);
        final ImageView imageView = findViewById(R.id.image_view_promo);
        //final TextView textViewNombre = findViewById(R.id.text_view_nombre_det);
        final TextView textViewDesc = findViewById(R.id.text_view_descrip_promo);
        final TextView textViewDire = findViewById(R.id.text_view_direccion_promo);
        final Button textViewTel = findViewById(R.id.text_view_telefono_promo);
        Button button = findViewById(R.id.compartir);

        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);
        //Glide.with(this).load(imageUrl).into(imageView);
        //textViewNombre.setText(nombre);
        textViewDesc.setText(descripcion);
        textViewDire.setText(direccion);
        textViewTel.setTextColor(getResources().getColor(R.color.verde));
        textViewTel.setPaintFlags(textViewTel.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        textViewTel.setText(telefono);


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




    }


}
