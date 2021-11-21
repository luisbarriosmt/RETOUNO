package co.edu.usa.retouno.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import java.util.List;
import co.edu.usa.retouno.entities.Usuario;
import co.edu.usa.retouno.servicio.UsuarioServicio;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioservicio;

    @GetMapping("/all")
    public List<Usuario> getAll() {
        return usuarioservicio.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario registrar(@RequestBody Usuario usuario) {
        return usuarioservicio.registrar(usuario);
    }

    @GetMapping("/{email}/{password}")
    public Usuario autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return usuarioservicio.autenticarUsuario(email, password);
    }

    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return usuarioservicio.existeEmail(email);
    }   
}

