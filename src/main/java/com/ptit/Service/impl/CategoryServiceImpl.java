package com.ptit.Service.impl;

import com.ptit.Entities.Category;
import com.ptit.Repository.CategoryRepository;
import com.ptit.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category getCategoryByIdCategory(int idCategory) {
        return categoryRepository.findCategoriesByIdCategory(idCategory);
    }

    @Override
    public List<Category> findAllByOrderByIdCategoryDesc() {
        return categoryRepository.findAllByOrderByIdCategoryDesc();
    }
}
