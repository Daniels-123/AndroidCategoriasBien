package com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.CrepesPizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.digitalandroidweb.androidregisterandlogin.Dependencias.Adaptor.ExampleAdaptor;
import com.digitalandroidweb.androidregisterandlogin.Dependencias.Adaptor.ExampleItem;
import com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativasDetail;
import com.digitalandroidweb.androidregisterandlogin.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_URL2;
import static com.digitalandroidweb.androidregisterandlogin.Dependencias.DependenciasAdministrativas.EXTRA_URL3;

public class CrepesPizzeriaActivity extends AppCompatActivity implements ExampleAdaptor.OnItemClickListener {
    public static final String EXTRA_URL = "Imagen_1";
    public static final String EXTRA_NOMBRE = "Nombre";
    public static final String EXTRA_DESCRIPTION = "Description";
    public static final String EXTRA_DIRECCION = "Direccion";
    public static final String EXTRA_TELEFONO= "Telefono";




    private RecyclerView mRecyclerView;
    private ExampleAdaptor mExampleAdaptor;
    private ArrayList<ExampleItem> mexampleItems;
    private RequestQueue mRequestQueue;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crepes_pizzeria);
        setupActionBar();
        this.setTitle(R.string.pizzerias);
        mRecyclerView = findViewById(R.id.recycler_view_crepes_pizzeria);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mexampleItems = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);

        parseJSON();

    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);


        }
    }

    private void parseJSON() {

        String url = "http://openfirespark.000webhostapp.com/pruebassql/categorias/cat_1/comida_vegetariana.php";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("Registros");

                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String nombre = hit.getString("Nombre");
                                String imageurl = hit.getString("Imagen_1");
                                String imageurl2 = hit.getString("Imagen_2");
                                String imageurl3 = hit.getString("Imagen_3");
                                String description = hit.getString("Descripcion");
                                String direccion= hit.getString("Direccion");
                                String telefono = hit.getString("Telefono");
                                String latitud = hit.getString("Latitud");
                                String longitud = hit.getString("Longitud");

                                mexampleItems.add(new ExampleItem(imageurl, imageurl2, imageurl3, nombre, description, direccion, telefono, latitud, longitud));

                            }

                            mExampleAdaptor = new ExampleAdaptor(CrepesPizzeriaActivity.this, mexampleItems);
                            mRecyclerView.setAdapter(mExampleAdaptor);
                            mExampleAdaptor.setOnClickItemListener(CrepesPizzeriaActivity.this );

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });


        mRequestQueue.add(request);

    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DependenciasAdministrativasDetail.class);
        ExampleItem clickeditem =mexampleItems.get(position);


        detailIntent.putExtra(EXTRA_URL, clickeditem.getImagen_1());
        detailIntent.putExtra(EXTRA_URL2, clickeditem.getImagen_2());
        detailIntent.putExtra(EXTRA_URL3, clickeditem.getImagen_3());
        detailIntent.putExtra(EXTRA_NOMBRE, clickeditem.getNombre());
        detailIntent.putExtra(EXTRA_DESCRIPTION, clickeditem.getDescripcion());
        detailIntent.putExtra(EXTRA_DIRECCION, clickeditem.getDireccion());
        detailIntent.putExtra(EXTRA_TELEFONO, clickeditem.getTelefono());



        startActivity(detailIntent);
    }
}
