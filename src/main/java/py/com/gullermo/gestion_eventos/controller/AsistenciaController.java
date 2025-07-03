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
import py.com.gullermo.gestion_eventos.model.Asistencia;
import py.com.gullermo.gestion_eventos.model.Evento;
import py.com.gullermo.gestion_eventos.model.Persona;
import py.com.gullermo.gestion_eventos.repository.AsistenciaRepository;
import py.com.gullermo.gestion_eventos.repository.EventoRepository;
import py.com.gullermo.gestion_eventos.repository.PersonaRepository;

@Controller
@RequestMapping("/asistencias")
public class AsistenciaController {

    @Autowired
    private AsistenciaRepository asistenciaRepo;

    @Autowired
    private EventoRepository eventoRepo;

    @Autowired
    private PersonaRepository personaRepo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("asistencias", asistenciaRepo.findAll());
        return "asistencias/list";
    }

    @GetMapping("/nuevo")
    public String formulario(Asistencia asistencia, Model model) {
        model.addAttribute("asistencia", new Asistencia());
        model.addAttribute("eventos", eventoRepo.findAll());
        model.addAttribute("personas", personaRepo.findAll());
        return "asistencias/form";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Asistencia asistencia, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("eventos", eventoRepo.findAll());
            model.addAttribute("personas", personaRepo.findAll());
            return "asistencias/form";
        }
        asistenciaRepo.save(asistencia);
        return "redirect:/asistencias";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Asistencia asistencia = asistenciaRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
        model.addAttribute("asistencia", asistencia);
        model.addAttribute("eventos", eventoRepo.findAll());
        model.addAttribute("personas", personaRepo.findAll());
        return "asistencias/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        Asistencia asistencia = asistenciaRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
        asistenciaRepo.delete(asistencia);
        return "redirect:/asistencias";
    }
}
