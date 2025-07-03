package py.com.gullermo.gestion_eventos.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import py.com.gullermo.gestion_eventos.model.Ciudad;
import py.com.gullermo.gestion_eventos.repository.CiudadRepository;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/ciudades")
public class CiudadController {

    @Autowired
    private CiudadRepository repo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ciudades", repo.findAll());
        return "ciudades/list";
    }

    @GetMapping("/nuevo")
    public String crearForm(Model model) {
        model.addAttribute("ciudad", new Ciudad());
        return "ciudades/form";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Ciudad ciudad, BindingResult res) {
        if (res.hasErrors()) return "ciudades/form";
        repo.save(ciudad);
        return "redirect:/ciudades";
    }



    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model, HttpServletResponse response) {
        repo.findById(id).ifPresent(c -> {
            model.addAttribute("ciudad", c);

            try {
                String valorCodificado = URLEncoder.encode(c.getDescripcionCiudad(), StandardCharsets.UTF_8);
                Cookie cookie = new Cookie("ultimaCiudad", valorCodificado);
                cookie.setMaxAge(60 * 60 * 24); // 1 día
                cookie.setPath("/");
                response.addCookie(cookie);
            } catch (Exception e) {
                e.printStackTrace(); // Para debug
            }
        });
        return "ciudades/form";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/ciudades";
    }
}
