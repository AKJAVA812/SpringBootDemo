package com.example.demo.controller;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Catagory;
import com.example.demo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CatagoryController {

    private CategoryService categoryService;
    //create Category

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    //get All Category
    @GetMapping
    public List<CategoryDTO> getCategories(){
        return categoryService.getAllCategories();
    }
    //get Category by id

    @GetMapping("/{id}")
    public CategoryDTO getCategortyById(@PathVariable Long id){
       return categoryService.getCategoryById(id);
    }
    //delete Category
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }
    //

}

