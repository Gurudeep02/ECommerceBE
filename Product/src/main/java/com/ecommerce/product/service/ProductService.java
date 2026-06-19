package com.ecommerce.product.service;

import com.ecommerce.product.dto.ProductRequestDTO;
import com.ecommerce.product.dto.ProductResponseDTO;
import com.ecommerce.product.exception.ProductException;
import com.ecommerce.product.mapper.ProductMapper;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    ProductRepository productRepository;

    ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO){
        Product product = ProductMapper.toModel(productRequestDTO);
        return ProductMapper.toDto(productRepository.save(product));
    }

    public ProductResponseDTO getProductById(int id){
        return ProductMapper.toDto(productRepository.getById(id));
    }

    public ProductResponseDTO
    reduceStock(int quantity, int productId) throws ProductException {
        Product product = productRepository.getById(productId);

        if(product.getStock() < quantity){
            throw new ProductException("Stock is not available, Try other product");
        }

        product.setStock(product.getStock() - quantity);
        return ProductMapper.toDto(productRepository.save(product));
    }
}
