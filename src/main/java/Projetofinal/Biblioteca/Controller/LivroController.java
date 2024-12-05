package Projetofinal.Biblioteca.Controller;

import Projetofinal.Biblioteca.model.Livro;
import Projetofinal.Biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LivroController {

    @Autowired
    private LivroService livroService;

    // Exibe o formulário de cadastro
    @GetMapping("/cadastro-livro")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("livros", livroService.listarTodos()); // Adiciona os livros existentes
        model.addAttribute("livro", new Livro()); // Cria um objeto vazio para o formulário
        return "cadastro-livro";
    }

    // Cadastra ou atualiza um livro
    @PostMapping("/cadastro-livro")
    public String cadastrarOuAlterarLivro(@ModelAttribute Livro livro, Model model) {
        livroService.salvar(livro); // Salva o livro no banco de dados
        model.addAttribute("mensagem", "Livro cadastrado/atualizado com sucesso!");
        return "redirect:/cadastro-livro";
    }

    // Exclui um livro pelo ID
    @GetMapping("/excluir/{id}")
    public String excluirLivro(@PathVariable Long id, Model model) {
        livroService.excluirPorId(id); // Exclui o livro pelo ID
        model.addAttribute("mensagem", "Livro excluído com sucesso!");
        return "redirect:/cadastro-livro"; // Retorna para a mesma página
    }

    // Edita um livro existente
    @GetMapping("/editar/{id}")
    public String editarLivro(@PathVariable Long id, Model model) {
        Livro livro = livroService.buscarPorId(id); // Busca o livro pelo ID
        if (livro != null) {
            model.addAttribute("livro", livro); // Popula o formulário com os dados do livro
            model.addAttribute("livros", livroService.listarTodos()); // Lista de livros cadastrados
            return "cadastro-livro";
        }
        model.addAttribute("mensagem", "Livro não encontrado!");
        return "redirect:/cadastro-livro";
    }

    // Exibe a página inicial com todos os livros cadastrados
    @GetMapping("/home")
    public String exibirHome(Model model) {
        model.addAttribute("livros", livroService.listarTodos()); // Passa a lista de livros para o modelo
        return "home"; // Retorna a página home.html
    }
}
