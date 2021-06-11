package br.com.gt.trainee.repositories;


import br.com.gt.trainee.models.Ingrediente;
import br.com.gt.trainee.models.TipoUnidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
}
