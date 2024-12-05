package Projetofinal.Biblioteca.service;

import Projetofinal.Biblioteca.model.Livro;
import Projetofinal.Biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    // Salvar ou atualizar um livro
    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    // Listar todos os livros
    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    // Buscar livro por ID
    public Livro buscarPorId(Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.orElse(null); // Retorna null caso o livro não seja encontrado
    }

    // Excluir livro por ID
    public void excluirPorId(Long id) {
        livroRepository.deleteById(id);
    }
}
