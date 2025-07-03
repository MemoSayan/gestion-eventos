package py.com.gullermo.gestion_eventos.repository;

import org.springframework.data.repository.CrudRepository;
import py.com.gullermo.gestion_eventos.model.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {
}