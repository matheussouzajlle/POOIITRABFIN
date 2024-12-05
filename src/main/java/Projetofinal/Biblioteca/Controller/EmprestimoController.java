package Projetofinal.Biblioteca.Controller;

import Projetofinal.Biblioteca.model.Emprestimo;
import Projetofinal.Biblioteca.service.EmprestimoService;
import Projetofinal.Biblioteca.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//@RequestMapping("/emprestimos")
public class EmprestimoController {


    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping("/emprestimo")
    public String exibirFormularioEmprestimo(Model model) {
        model.addAttribute("emprestimo", new Emprestimo());
        return "emprestimo"; // nome do template emprestimo.html
    }

    @PostMapping("/emprestimo")
    public String realizarEmprestimo(@ModelAttribute("emprestimo") Emprestimo emprestimo) {
        emprestimoService.salvar(emprestimo);
        return "emprestimo"; // redireciona para a lista de empréstimos
    }

}
