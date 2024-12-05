package Projetofinal.Biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Emprestimo {

    @Id
    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Livro livro;

    private LocalDate dataEmprestimo = LocalDate.now();
    private LocalDate dataDevolucao;

    // Getters e Setters
    // Construtores
}
