package org.example.examenll_dayronmyrie.Entity;

import java.util.List;

public class Orden {
    private String id;
    private List<OrdenItem> items;

    public Orden() {
    }

    public Orden(String id, List<OrdenItem> items) {
        this.id = id;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<OrdenItem> getItems() {
        return items;
    }

    public void setItems(List<OrdenItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id='" + id + '\'' +
                ", items=" + items +
                '}';
    }
}

