package com.ptit.Service;

import com.ptit.Entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService  {
<<<<<<< HEAD
=======
    void save(CategoryDto categoryDto);

    void update(CategoryDto categoryDto,int id);
>>>>>>> 3d23de938d5a685d033199a3a6bba72ade7dffaa
    Category getCategoryByIdCategory(int idCategory);
    List<Category> findAllByOrderByIdCategoryDesc();
    Category getCategoryByCategoryName(String categoryName);
}
