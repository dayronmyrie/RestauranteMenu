package org.example.examenll_dayronmyrie.Repository;

import org.example.examenll_dayronmyrie.Entity.Categoria;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("CategoriaRepository")
public class CategoriaRepository {
    List<Categoria> listaCategoria;

    public CategoriaRepository(){
        listaCategoria = new ArrayList<>();
        listaCategoria.add(new Categoria("111", "Entradas"));
        listaCategoria.add(new Categoria("222", "Carnes"));
        listaCategoria.add(new Categoria("333", "Sopas"));
        listaCategoria.add(new Categoria("444", "Arroces"));
        listaCategoria.add(new Categoria("555", "Bebidas"));
        listaCategoria.add(new Categoria("666", "Postres"));
    }
    public Categoria findById(String id)throws Exception{
        return listaCategoria.stream().filter(categoria -> categoria.getId().equals(id)).findFirst().orElse(null);
    }
    public List<Categoria> findAll(){
        return listaCategoria;
    }
}
