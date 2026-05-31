package com.category.service;

import com.category.dto.SaloneDTO;
import com.category.model.Category;
import org.springframework.stereotype.Service;


import java.util.Set;

@Service
public interface CategoryService {

    Category saveCategory(Category category, SaloneDTO saloneDTO);

    Set<Category> getAllCategoriesBysalone(Long id);

    Category getCategoryById(Long id) throws Exception;

    void deleteCategory(Long id, Long salonId) throws Exception;

}
