package Projetofinal.Biblioteca.service;

import Projetofinal.Biblioteca.model.Usuario;
import Projetofinal.Biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        // Retorna as credenciais do usuário (email e senha) junto com os papéis (roles)
        return User.builder()
                .username(usuario.getEmail())   // Email como nome de usuário
                // .password(usuario.getSenha())   // Remova a senha ou altere para não usar
                .password("")                   // Como você não quer criptografar, não usa senha (ou deixe em branco)
                .roles("USER")                  // Roles (você pode modificar conforme necessário)
                .build();
    }
}