package co.edu.usa.retouno.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import co.edu.usa.retouno.entities.Usuario;

public interface UsuarioCRUDRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByEmailAndPassword(String email,String password);
    //Optional<User> findByName(String name);
}
