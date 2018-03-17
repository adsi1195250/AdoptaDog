package com.example.adsi.adoptadog.models;

import android.widget.ImageView;

/**
 * Created by ADSI on 8/03/2018.
 */

public class Perros {

    private Integer perrosImage;
    private String nombre;
    private String edad;
    private String raza;
    private String tipo;

    public int getPerrosImage() {
        return perrosImage;
    }

    public void setPerrosImage(int perrosImage) {
        this.perrosImage = perrosImage;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Perros(int perrosImage, String nombre, String edad, String raza, String tipo) {
        this.perrosImage = perrosImage;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.tipo = tipo;
    }
}
