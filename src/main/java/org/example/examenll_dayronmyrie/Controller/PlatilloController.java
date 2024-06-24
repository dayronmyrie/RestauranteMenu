package org.example.examenll_dayronmyrie.Controller;

import org.example.examenll_dayronmyrie.Entity.Platillo;
import org.example.examenll_dayronmyrie.Repository.PlatilloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platillos")
public class PlatilloController {

    @Autowired
    private PlatilloRepository platilloRepository;

    @GetMapping
    public List<Platillo> getAllPlatillos() {
        return platilloRepository.findAll();
    }

    @GetMapping("/{id}")
    public Platillo getPlatilloById(@PathVariable String id) throws Exception {
        return platilloRepository.findById(id);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Platillo> getPlatillosByCategoria(@PathVariable String categoriaId) {
        return platilloRepository.findByCategoria(categoriaId);
    }
}

