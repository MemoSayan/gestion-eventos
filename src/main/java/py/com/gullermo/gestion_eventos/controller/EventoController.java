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
import py.com.gullermo.gestion_eventos.model.Evento;
import py.com.gullermo.gestion_eventos.model.Ciudad;
import py.com.gullermo.gestion_eventos.repository.EventoRepository;
import py.com.gullermo.gestion_eventos.repository.CiudadRepository;

@Controller
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepo;

    @Autowired
    private CiudadRepository ciudadRepo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("eventos", eventoRepo.findAll());
        return "eventos/list";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("evento", new Evento());
        model.addAttribute("ciudades", ciudadRepo.findAll());
        return "eventos/form";
    }
    @PostMapping("/guardar")
    public String guardar(@Valid Evento evento, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ciudades", ciudadRepo.findAll());
            return "eventos/form";
        }
        eventoRepo.save(evento);
        return "redirect:/eventos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Evento evento = eventoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
        model.addAttribute("evento", evento);
        model.addAttribute("ciudades", ciudadRepo.findAll());
        return "eventos/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        Evento evento = eventoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
        eventoRepo.delete(evento);
        return "redirect:/eventos";
    }
}
