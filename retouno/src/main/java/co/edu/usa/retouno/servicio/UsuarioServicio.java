package co.edu.usa.retouno.servicio;

import co.edu.usa.retouno.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.List;
import co.edu.usa.retouno.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {


    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() {
        return usuarioRepository.getAll();
    }

    public Optional<Usuario> getUser(int id) {
        return usuarioRepository.getUser(id);
    }

    public Usuario registrar(Usuario user) {
        if (user.getId() == null) {
            if (existeEmail(user.getemail()) == false) {
                return usuarioRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email) {
        return usuarioRepository.existeEmail(email);
    }

    public Usuario autenticarUsuario(String email, String password) {
        Optional<Usuario> usuario = usuarioRepository.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new Usuario(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}
    

