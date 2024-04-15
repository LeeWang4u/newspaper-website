package com.ptit.Repository;


import com.ptit.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> getAllByIdCategory(int idCategory);
}
