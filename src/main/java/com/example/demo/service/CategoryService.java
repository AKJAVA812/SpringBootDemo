package com.example.demo.service;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Catagory;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    //get categories
    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }
    //get category by Id
    public CategoryDTO getCategoryById(Long id){
        Catagory catagory= categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category Id Not found!!"));
        return CategoryMapper.toCategoryDTO(catagory);
    }

    //delete Category
    public String deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return "Category Deleted Successfully";
    }
}
