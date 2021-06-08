package br.com.gt.trainee.repositories;

import br.com.gt.trainee.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
