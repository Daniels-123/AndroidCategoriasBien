package com.digitalandroidweb.androidregisterandlogin.Dependencias.Adaptor;

public class ExampleItem {
    private String Imagen_1;
    private String Imagen_2;
    private String Imagen_3;
    private String Nombre;
    private String Descripcion;
    private String Direccion;
    private String Telefono;
    private String Latitud;
    private String Longitud;
    private String Link;


    public ExampleItem(String imagen_1, String imagen_2, String imagen_3, String nombre, String descripcion, String direccion, String telefono, String latitud, String longitud) {
        Imagen_1 = imagen_1;
        Nombre = nombre;
        Descripcion = descripcion;
        Direccion = direccion;
        Telefono = telefono;
        Imagen_2 = imagen_2;
        Imagen_3 = imagen_3;
        Latitud = latitud;
        Longitud = longitud;
    }



    public String getImagen_1() {


        return Imagen_1;
    }

    public String getImagen_2() {


        return Imagen_2;
    }


    public String getImagen_3() {
        return Imagen_3;
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


    public String getLatitud() {
        return Latitud;
    }

    public String getLongitud() {
        return Longitud;
    }

}
