package com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.Bares.Adaptor;

public class ExampleItem {
    private String Imagen_1;
    private String Nombre;
    private String Descripcion;
    private String Direccion;
    private String Telefono;
    private String Latitud;
    private String Longitud;

    public ExampleItem(String imagen_1, String nombre, String descripcion, String direccion, String telefono, String latitud, String longitud) {
        Imagen_1 = imagen_1;
        Nombre = nombre;
        Descripcion = descripcion;
        Direccion = direccion;
        Telefono = telefono;
        Latitud = latitud;
        Longitud = longitud;

    }


    public String getLatitud() {
        return Latitud;
    }

    public String getLongitud() {
        return Longitud;
    }


    public String getImagen_1() {


        return Imagen_1;
    }

    public String getNombre() {


        return Nombre;
    }

    public String getDescripcion() {


        return Descripcion;
    }

    public String getDireccion(){

        return Direccion;
    }

    public String getTelefono(){

        return Telefono;
    }


}
