package com.example.demo.mapper;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Catagory;
import lombok.Data;


public class CategoryMapper {

    //DTO to Entity
    public static Catagory toCategoryEntity(CategoryDTO categoryDTO){
        Catagory catagory = new Catagory();
        catagory.setName(categoryDTO.getName());
        return catagory;
    }

    //Enitiy to DTO

    public static CategoryDTO toCategoryDTO(Catagory catagory)
    {
        if (catagory == null) {
            return null;
        }else {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(catagory.getId());
            categoryDTO.setName(catagory.getName());
            categoryDTO.setProductDTOS(catagory.getProductList().stream().map(ProductMapper::toproductDTO).toList());
            return categoryDTO;
        }
    }

}
