package com.ptit.Service.impl;

import com.ptit.Dto.CategoryDto;
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
    public void save(CategoryDto categoryDto) {

    }

    @Override
    public void update(CategoryDto categoryDto, int id){
        Category category = categoryRepository.findCategoriesByIdCategory(id);
        category.setCategoryName(categoryDto.getCategoryName());
        category.setDescribe(categoryDto.getCategoryDescribe());

        categoryRepository.save(category);
    }
    @Override
    public Category getCategoryByIdCategory(int idCategory) {
        return categoryRepository.findCategoriesByIdCategory(idCategory);
    }

    @Override
    public List<Category> findAllByOrderByIdCategoryDesc() {
        return categoryRepository.findAllByOrderByIdCategoryDesc();
    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) {
        return categoryRepository.findCategoriesByCategoryName(categoryName);
    }
}
