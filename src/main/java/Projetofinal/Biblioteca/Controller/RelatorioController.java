package Projetofinal.Biblioteca.Controller;

import Projetofinal.Biblioteca.dto.RelatorioDTO;
import Projetofinal.Biblioteca.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    // Endpoint para exibir a lista de empréstimos com o gráfico de pizza
    @GetMapping("/lista-emprestimos")
    public String exibirRelatorio(Model model) {
        // Obtém os dados do serviço
        RelatorioDTO relatorioDTO = relatorioService.relatorioDePizza();

        // Adiciona os dados ao modelo para Thymeleaf
        model.addAttribute("labels", relatorioDTO.getLabels());
        model.addAttribute("values", relatorioDTO.getValues());

        return "lista-emprestimos"; // Nome da página HTML
    }
}
