package com.digitalandroidweb.androidregisterandlogin.ComidasYpostres.ComidaRapida.Adaptor;

public class ExampleItem {
    private String Imagen_1;
    private String Nombre;
    private String Descripcion;
    private String Direccion;
    private String Telefono;

    public ExampleItem(String imagen_1, String nombre, String descripcion, String direccion, String telefono) {
        Imagen_1 = imagen_1;
        Nombre = nombre;
        Descripcion = descripcion;
        Direccion = direccion;
        Telefono = telefono;

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
