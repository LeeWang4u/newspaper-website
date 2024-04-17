package com.ptit.Service;

import com.ptit.Entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    Page<Category> getAllByIdCategory();
}
