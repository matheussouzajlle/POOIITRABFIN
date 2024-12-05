package Projetofinal.Biblioteca.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/")
public class InitialPageController {

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("home"); // Página inicial sem relação com login
    }
}
