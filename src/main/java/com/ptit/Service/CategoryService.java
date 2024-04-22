package com.ptit.Service;

import com.ptit.Dto.CategoryDto;
import com.ptit.Entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService  {
    void save(CategoryDto categoryDto);
    Category getCategoryByIdCategory(int idCategory);
    List<Category> findAllByOrderByIdCategoryDesc();
    Category getCategoryByCategoryName(String categoryName);
}
