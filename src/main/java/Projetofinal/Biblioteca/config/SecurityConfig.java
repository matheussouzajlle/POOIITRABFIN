package Projetofinal.Biblioteca.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Desabilita CSRF
                .authorizeRequests(auth -> auth
                        .requestMatchers("/cadastro-livro","/cadastro-usuario","/emprestimo","/home", "/lista-emprestimos","/login", "/register").permitAll()  // Permite acesso irrestrito a essas páginas
                        .anyRequest().permitAll()  // Permite o acesso a todas as páginas sem autenticação
                );

        return http.build();
    }
}
//    private final UsuarioDetailsService usuarioDetailsService;
//
//    public SecurityConfig(UsuarioDetailsService usuarioDetailsService) {
//        this.usuarioDetailsService = usuarioDetailsService;
//    }
//
//    public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Desativa CSRF se necessário
//                .authorizeRequests(authz -> authz
//                        .requestMatchers("/login", "/register", "/home").permitAll()  // Permitir sem autenticação
//                        .anyRequest().authenticated()  // Requer autenticação para outras páginas
//                )
//                .formLogin(form ->
//                        form
//                                .loginPage("/login")  // Página de login personalizada
//                                .defaultSuccessUrl("/u/home", true)  // Redireciona para home após login bem-sucedido
//                )
//                .logout(logout ->
//                        logout
//                                .logoutUrl("/logout")  // URL para logout
//                                .logoutSuccessUrl("/login?logout")  // Página após logout
//                                .permitAll()  // Permitir logout para todos
//                );
//
//        return http.build(); // Construa o filtro de segurança
//    }
//}
