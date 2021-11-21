package co.edu.usa.retouno.repositories;

import co.edu.usa.retouno.entities.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


public class UsuarioRepository {

    @Autowired
    private UsuarioCRUDRepository usuarioCRUDRepository;

    public List<Usuario> getAll() {
        return (List<Usuario>) usuarioCRUDRepository.findAll();
    }

    public Optional<Usuario> getUser(int id) {
        return usuarioCRUDRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        return usuarioCRUDRepository.save(usuario); 
    }

    public boolean existeEmail(String email) {
        Optional<Usuario> usuario = usuarioCRUDRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<Usuario> autenticarUsuario(String email, String password) {
        return usuarioCRUDRepository.findByEmailAndPassword(email, password);
    }
}
    
