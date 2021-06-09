package br.com.gt.trainee.repositories;

import br.com.gt.trainee.models.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitasRepository extends JpaRepository<Receita, Long> {
}
