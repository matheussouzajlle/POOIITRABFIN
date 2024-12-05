package Projetofinal.Biblioteca.repository;

import Projetofinal.Biblioteca.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
