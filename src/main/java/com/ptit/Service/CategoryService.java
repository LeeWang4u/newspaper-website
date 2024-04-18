package com.ptit.Service;

import com.ptit.Entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService  {
    Category getCategoryByIdCategory(int idCategory);
    List<Category> findAllByOrderByIdCategoryDesc();
}
