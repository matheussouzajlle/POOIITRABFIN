package Projetofinal.Biblioteca.repository;

import Projetofinal.Biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    // Busca livros pelo título (case insensitive)
    List<Livro> findByTituloContainingIgnoreCase(String titulo);

    // Busca livros pelo autor (case insensitive)
    List<Livro> findByAutorContainingIgnoreCase(String autor);

    // Busca livros disponíveis
    List<Livro> findByDisponivelTrue();

    // Busca livros indisponíveis
    List<Livro> findByDisponivelFalse();

    // Consulta personalizada para buscar livros pelo ISBN
    @Query("SELECT l FROM Livro l WHERE l.isbn = :isbn")
    Livro buscarPorIsbn(@Param("isbn") String isbn);
}
