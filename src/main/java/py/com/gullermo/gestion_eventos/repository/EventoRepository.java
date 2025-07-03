package py.com.gullermo.gestion_eventos.repository;

import org.springframework.data.repository.CrudRepository;
import py.com.gullermo.gestion_eventos.model.Evento;

public interface EventoRepository extends CrudRepository<Evento, Long> {
}