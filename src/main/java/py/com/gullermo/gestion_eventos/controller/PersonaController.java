package py.com.gullermo.gestion_eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;
import py.com.gullermo.gestion_eventos.model.Persona;
import py.com.gullermo.gestion_eventos.model.Ciudad;
import py.com.gullermo.gestion_eventos.repository.PersonaRepository;
import py.com.gullermo.gestion_eventos.repository.CiudadRepository;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepo;

    @Autowired
    private CiudadRepository ciudadRepo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("personas", personaRepo.findAll());
        return "personas/list";
    }

    @GetMapping("/nuevo")
    public String formulario(Persona persona, Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("ciudades", ciudadRepo.findAll());
        return "personas/form";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ciudades", ciudadRepo.findAll());
            return "personas/form";
        }
        personaRepo.save(persona);
        return "redirect:/personas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Persona persona = personaRepo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
        model.addAttribute("persona", persona);
        model.addAttribute("ciudades", ciudadRepo.findAll());
        return "personas/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        Persona persona = personaRepo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
        personaRepo.delete(persona);
        return "redirect:/personas";
    }
}
