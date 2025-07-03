package py.com.gullermo.gestion_eventos.auth.repository;

import org.springframework.data.repository.CrudRepository;
import py.com.gullermo.gestion_eventos.auth.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
