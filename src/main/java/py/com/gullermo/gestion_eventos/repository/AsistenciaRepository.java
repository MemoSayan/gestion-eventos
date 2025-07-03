package py.com.gullermo.gestion_eventos.repository;

import org.springframework.data.repository.CrudRepository;
import py.com.gullermo.gestion_eventos.model.Asistencia;
import py.com.gullermo.gestion_eventos.model.Evento;

import java.util.List;

public interface AsistenciaRepository extends CrudRepository<Asistencia, Long> {
    List<Asistencia> findByEvento(Evento evento);
}