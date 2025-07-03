package py.com.gullermo.gestion_eventos.repository;

import org.springframework.data.repository.CrudRepository;
import py.com.gullermo.gestion_eventos.model.Ciudad;

public interface CiudadRepository extends CrudRepository<Ciudad, Long> {}