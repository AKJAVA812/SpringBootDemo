package com.example.demo.mapper;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Catagory;
import com.example.demo.entity.Product;

public class ProductMapper {

    //entity to productDTO
    public static ProductDTO toproductDTO(Product product)
    {
        return new ProductDTO(
          product.getId(),
          product.getName(),
          product.getDescription(),
          product.getPrice(),
          product.getCatagory().getId()
        );
    }
    //DTO to entity
    public static Product toProductEntity(ProductDTO productDTO, Catagory category){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(product.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCatagory(category);
        return product;
    }
}
