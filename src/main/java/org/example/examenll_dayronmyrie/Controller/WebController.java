package org.example.examenll_dayronmyrie.Controller;

import org.example.examenll_dayronmyrie.Entity.Categoria;
import org.example.examenll_dayronmyrie.Repository.CategoriaRepository;
import org.example.examenll_dayronmyrie.Repository.PlatilloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private PlatilloRepository platilloRepository;
    public WebController(CategoriaRepository categoriaRepository, PlatilloRepository platilloRepository){
        this.categoriaRepository = categoriaRepository; this.platilloRepository = platilloRepository;}
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("categoorias", categoriaRepository);
        model.addAttribute("platillos", platilloRepository);
        return "index";
    }
    @GetMapping("/index")
    public String mostrarIndex(Model model){
        model.addAttribute("categoorias", categoriaRepository);
        model.addAttribute("platillos", platilloRepository);
        return "index";
    }

}
