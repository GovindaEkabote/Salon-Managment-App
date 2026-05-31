package com.category.controller;

import com.category.dto.SaloneDTO;
import com.category.model.Category;
import com.category.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/salons")
@AllArgsConstructor
public class SalonCategoryController {

    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        SaloneDTO saloneDTO = new SaloneDTO();
        saloneDTO.setId(1L);
        Category saveCategory = categoryService.saveCategory(category, saloneDTO);
        return ResponseEntity.ok(saveCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) throws Exception {
        SaloneDTO saloneDTO = new SaloneDTO();
        saloneDTO.setId(1L);
        categoryService.deleteCategory(id, saloneDTO.getId());
        return ResponseEntity.ok("Category deleted successfully");
    }
}
