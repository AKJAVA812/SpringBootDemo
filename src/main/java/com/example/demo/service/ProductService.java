package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Catagory;
import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductDTO createProduct(ProductDTO productDTO){
        /**
         * Name,Description,Price,CategoryId
         * **/
        //category Available logic
        Catagory catagory= categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->
                new RuntimeException("Category Not found!!"));
        //DTO to Entity
        Product product = ProductMapper.toProductEntity(productDTO,catagory);
        product = productRepository.save(product);
        //Entity to DTO
        return ProductMapper.toproductDTO(product);
    }
    //get all Product
    public List<ProductDTO> getAllProduct(){
        return productRepository.findAll().stream().map(ProductMapper::toproductDTO).toList();
    }
    //get product by Id
    public ProductDTO getProductById(Long id){
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Procuct not found"));
        return ProductMapper.toproductDTO(product);
    }
    //product update
    public ProductDTO updateProduct(Long id, ProductDTO productDTO){
        //category Available logic
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Procuct not found"));
        Catagory catagory =categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->
                new RuntimeException("Category Not found!!"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCatagory(catagory);
        productRepository.save(product);
        return ProductMapper.toproductDTO(product);
    }
    //product Delete
    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product"+id+"has beend deleted";
    }
}
