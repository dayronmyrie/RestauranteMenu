package org.example.examenll_dayronmyrie.Entity;


public class OrdenItem {
    private Platillo platillo;
    private int cantidad;
    private String tamanio;

    public OrdenItem() {
    }

    public OrdenItem(Platillo platillo, int cantidad, String tamanio) {
        this.platillo = platillo;
        this.cantidad = cantidad;
        this.tamanio = tamanio;
    }

    public Platillo getPlatillo() {
        return platillo;
    }

    public void setPlatillo(Platillo platillo) {
        this.platillo = platillo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "OrdenItem{" +
                "platillo=" + platillo +
                ", cantidad=" + cantidad +
                ", tamaño='" + tamanio + '\'' +
                '}';
    }
}

