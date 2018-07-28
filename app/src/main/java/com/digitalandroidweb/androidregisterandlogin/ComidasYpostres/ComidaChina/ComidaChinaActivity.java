package com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.ComidaChina;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class ComidaChinaActivity extends AppCompatActivity implements ExampleAdaptor.OnItemClickListener {
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
        setContentView(R.layout.activity_comida_china);
        setupActionBar();
        this.setTitle(R.string.comida_china);
        mRecyclerView = findViewById(R.id.recycler_view_comida_china);
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

        String url = "http://openfirespark.000webhostapp.com/pruebassql/categorias/cat_1/comida_china.php";

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
                                String description = hit.getString("Descripcion");
                                String direccion= hit.getString("Direccion");
                                String telefono = hit.getString("Telefono");


                                mexampleItems.add(new ExampleItem(imageurl, nombre, description,direccion,telefono));

                            }

                            mExampleAdaptor = new ExampleAdaptor(ComidaChinaActivity.this, mexampleItems);
                            mRecyclerView.setAdapter(mExampleAdaptor);
                            mExampleAdaptor.setOnClickItemListener(ComidaChinaActivity.this );

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
        Intent detailIntent = new Intent(this, ComidaChinaDetail.class);
        ExampleItem clickeditem =mexampleItems.get(position);


        detailIntent.putExtra(EXTRA_URL, clickeditem.getImagen_1());
        detailIntent.putExtra(EXTRA_NOMBRE, clickeditem.getNombre());
        detailIntent.putExtra(EXTRA_DESCRIPTION, clickeditem.getDescripcion());
        detailIntent.putExtra(EXTRA_DIRECCION, clickeditem.getDireccion());
        detailIntent.putExtra(EXTRA_TELEFONO, clickeditem.getTelefono());



        startActivity(detailIntent);
    }
}
