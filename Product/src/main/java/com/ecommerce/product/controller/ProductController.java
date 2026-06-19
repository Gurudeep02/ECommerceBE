package com.ecommerce.product.controller;

import com.ecommerce.product.exception.ProductException;
import com.ecommerce.product.service.ProductService;
import com.ecommerce.product.dto.ProductRequestDTO;
import com.ecommerce.product.dto.ProductResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ProductResponseDTO saveProduct(@RequestBody ProductRequestDTO productRequestDTO){
        System.out.println("API hit");
        return productService.saveProduct(productRequestDTO);
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PutMapping("/reduceStock")
    public ProductResponseDTO reduceStock(@RequestParam int quantity, @RequestParam int product_id) throws ProductException {
            try{
               return productService.reduceStock(quantity, product_id);
            } catch (ProductException e) {
                throw e;
            }
    }
}
