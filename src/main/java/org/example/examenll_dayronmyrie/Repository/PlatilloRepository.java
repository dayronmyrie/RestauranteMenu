package org.example.examenll_dayronmyrie.Repository;

import org.example.examenll_dayronmyrie.Entity.Categoria;
import org.example.examenll_dayronmyrie.Entity.Platillo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component("platilloRepository")
public class PlatilloRepository {
    List<Platillo> listaPlatillos;
    CategoriaRepository categoriaRepository;
    @Autowired
    public PlatilloRepository(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;

        listaPlatillos = new ArrayList<>();
        try{
            Categoria entradas = categoriaRepository.findById("111");
            listaPlatillos.add(new Platillo(entradas, "111", "Ensalada Capresse", "Tomate, mozzarella y hojas de albahaca fresca", 5000 ));
            listaPlatillos.add(new Platillo(entradas, "222", "Crema Espinaca", "Crema hecha con hojas de espincas", 3500 ));
            listaPlatillos.add(new Platillo(entradas, "333", "Patacones", "Platanos verdes, fritos", 4000 ));
            listaPlatillos.add(new Platillo(entradas, "444", "Papas al romero", "Papas horneadas con esencia de romero", 4000 ));

            Categoria carnes = categoriaRepository.findById("222");
            listaPlatillos.add(new Platillo(carnes, "555", "Chuleton", "Chuleta grande salpimentada", 7000 ));
            listaPlatillos.add(new Platillo(carnes, "666", "Bistec encebollado", "Bistec suave con cebolla caramelizada", 5000 ));
            listaPlatillos.add(new Platillo(carnes, "777", "Corte New York", "Suave corte de New York", 8000 ));
            listaPlatillos.add(new Platillo(carnes, "888", "Lomito", "Corte de lomito a la parrilla", 9000 ));

            Categoria sopas = categoriaRepository.findById("333");
            listaPlatillos.add(new Platillo(sopas, "555", "Olla de Carne", "Sopa con verduras y carne", 4000 ));
            listaPlatillos.add(new Platillo(sopas, "666", "Sopa negra", "Sopa negra de frijoles", 3000 ));
            listaPlatillos.add(new Platillo(sopas, "777", "Soppa Maggi", "Sopa de paquete Maggi", 2000 ));
            listaPlatillos.add(new Platillo(sopas, "888", "Sopa de Pollo", "Sustancia de Pollo con verduras", 4000 ));

            Categoria arroces = categoriaRepository.findById("444");
            listaPlatillos.add(new Platillo(arroces, "555", "Arroz con calamares", "Arroz con calamares", 5000 ));
            listaPlatillos.add(new Platillo(arroces, "666", "Arroz mixto", "Arroz con pollo, calamres y res", 7000 ));
            listaPlatillos.add(new Platillo(arroces, "777", "Arroz con Res", "Arroz con carne de res", 5000 ));
            listaPlatillos.add(new Platillo(arroces, "888", "Aarroz con Pollo", "Arroz con pollo", 4000 ));

            Categoria bebidas = categoriaRepository.findById("555");
            listaPlatillos.add(new Platillo(bebidas, "555", "Sarza", "Sarza", 1000 ));
            listaPlatillos.add(new Platillo(bebidas, "666", "Sangria", "Sangria con frutas", 5000 ));
            listaPlatillos.add(new Platillo(bebidas, "777", "Fanta", "Fanta Naranja", 1000 ));
            listaPlatillos.add(new Platillo(bebidas, "888", "Fresco natural", "Fresco de frutas", 1500 ));

            Categoria postres = categoriaRepository.findById("666");
            listaPlatillos.add(new Platillo(postres, "555", "Tres Leches", "Tres leches", 2000 ));
            listaPlatillos.add(new Platillo(postres, "666", "Flan", "Flan de coco", 2000 ));
            listaPlatillos.add(new Platillo(postres, "777", "Queque Chocolate", "Esponjoso queque de chocolate", 2000 ));
            listaPlatillos.add(new Platillo(postres, "888", "Helado", "Helado de Vainilla", 2000 ));
        } catch (Exception e) {

        }
    }
    public Platillo findById(String id)throws Exception{

        return listaPlatillos.stream().filter(platillo -> platillo.getId().equals(id)).findFirst().orElse(null);
    }
    public List<Platillo> findAll(){
        return listaPlatillos;
    }
    public List<Platillo> findByCategoria(String id) {
        return listaPlatillos.stream()
                .filter(platillo -> platillo.getCategoria().getId().equals(id))
                .collect(Collectors.toList());
    }
    }



