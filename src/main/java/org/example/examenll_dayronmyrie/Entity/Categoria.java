package org.example.examenll_dayronmyrie.Entity;

import java.util.List;

public class Categoria {
    String id;
    String nombre;
    List<Platillo> listaPlatillos;

    public Categoria() {
    }

    public Categoria(String id, String nombre, List<Platillo> listaPlatillos) {
        this.id = id;
        this.nombre = nombre;
        this.listaPlatillos = listaPlatillos;
    }
    public Categoria(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Platillo> getListaPlatillos() {
        return listaPlatillos;
    }

    public void setListaPlatillos(List<Platillo> listaPlatillos) {
        this.listaPlatillos = listaPlatillos;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", listaPlatillos=" + listaPlatillos +
                '}';
    }
}
