package Projetofinal.Biblioteca.service;

import Projetofinal.Biblioteca.model.Usuario;
import Projetofinal.Biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }

    public Usuario salvar(Usuario usuario) {
        // Comentei a criptografia da senha, já que não está sendo utilizada.
        // usuario.setSenha(passwordEncoder().encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> encontrarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
