package com.category.service.impl;

import com.category.dto.SaloneDTO;
import com.category.model.Category;
import com.category.repository.CategoryRepository;
import com.category.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category, SaloneDTO saloneDTO) {
        Category  newCategory =  new Category();
        newCategory.setName(category.getName());
        newCategory.setSalonId(category.getSalonId());
        newCategory.setImage(category.getImage());
        newCategory.setSalonId(saloneDTO.getId());
        return categoryRepository.save(newCategory);
    }

    @Override
    public Set<Category> getAllCategoriesBysalone(Long id) {
        return categoryRepository.findBySalonId(id);
    }

    @Override
    public Category getCategoryById(Long id) throws Exception {
        Category category= categoryRepository.findById(id).orElse(null);
        if (category == null){
            throw new Exception("Category Not Exist with this id"+ id);
        }
        return category;
    }

    @Override
    public void deleteCategory(Long id, Long aLong) throws Exception {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category.getSalonId().equals(aLong)){
            throw new Exception("Category Not Exist with this id"+ id);
        }
        categoryRepository.delete(category);
    }
}
