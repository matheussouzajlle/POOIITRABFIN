package Projetofinal.Biblioteca.service;

import Projetofinal.Biblioteca.dto.RelatorioDTO;
import Projetofinal.Biblioteca.repository.LivroRepository;
import Projetofinal.Biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    // Método para gerar o relatório de pizza
    public RelatorioDTO relatorioDePizza() {
        RelatorioDTO relatorioDTO = new RelatorioDTO();

        // Contagem de livros e usuários (usando tipos primitivos long e int)
        long quantidadeLivros = livroRepository.count();  // Usando 'long' em vez de Long
        long quantidadeUsuarios = usuarioRepository.count();  // Usando 'long' em vez de Long

        // Converte para 'int' e define os valores no DTO
        relatorioDTO.setValues(List.of((int)quantidadeLivros, (int)quantidadeUsuarios));  // Convertendo para 'int' explicitamente
        relatorioDTO.setLabels(List.of("Livros", "Usuários"));

        return relatorioDTO;
    }
}
