package Projetofinal.Biblioteca.Controller;

import Projetofinal.Biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;  // Importação para PostMapping
import org.springframework.web.bind.annotation.ModelAttribute;  // Importação para ModelAttribute
import Projetofinal.Biblioteca.model.Usuario;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

//    @GetMapping("/home")
//    public String home(Model model) {
//        model.addAttribute("mensagem", "Bem-vindo à Biblioteca!");
//        return "home"; // Certifique-se de ter a página home.html configurada
//    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        System.out.println("Acessando pagina de registro");
        return "register"; // Nome do template do formulário de registro (register.html)
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("usuario") Usuario usuario, Model model) {
        // Verifica se o email já está cadastrado antes de salvar
        if (usuarioService.encontrarPorEmail(usuario.getEmail()).isPresent()) {
            // Passa a mensagem de erro para o modelo
            model.addAttribute("emailJaExistente", true);
            return "register"; // Retorna para a página de cadastro com erro
        }
        usuarioService.salvar(usuario); // Salva o novo usuário
        return "redirect:/home"; // Redireciona para a página inicial após o registro
    }
}


