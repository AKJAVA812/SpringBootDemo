package com.example.demo.service;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Catagory;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;
    //Create Category
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Catagory catagory = CategoryMapper.toCategoryEntity(categoryDTO);
        catagory = categoryRepository.save(catagory);
        return CategoryMapper.toCategoryDTO(catagory);
    }
}
