package leo.com.cursomc.repositories;

import leo.com.cursomc.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
