package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    public ProductService productService;
    //get All Product
    @GetMapping
    public List<ProductDTO> getAllProdcut()
    {
        return productService.getAllProduct();
    }
    //get product by Id
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    //Create Product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO productDTO1 = productService.createProduct(productDTO);
        return new ResponseEntity<> (productDTO1, HttpStatus.CREATED);
    }
    //Update Product
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id,productDTO);
    }
    //Remove Product
    @DeleteMapping("/{id}")
    public String productDelete(@PathVariable Long id){
        return productService.deleteProduct(id);
    }
}
