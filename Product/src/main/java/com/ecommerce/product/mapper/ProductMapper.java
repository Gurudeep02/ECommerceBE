package com.ecommerce.product.mapper;

import com.ecommerce.product.dto.ProductRequestDTO;
import com.ecommerce.product.dto.ProductResponseDTO;
import com.ecommerce.product.model.Product;

public class ProductMapper {

    public static Product toModel(ProductRequestDTO productRequestDTO){
        Product product = new Product();
        product.setId(Integer.parseInt(productRequestDTO.getId()));
        product.setName(productRequestDTO.getName());
        product.setCategory(productRequestDTO.getCategory());
        product.setStock(Integer.parseInt(productRequestDTO.getStock()));
        product.setPrice(productRequestDTO.getPrice());

        return product;
    }

    public static ProductResponseDTO toDto(Product product){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setId(String.valueOf(product.getId()));
        productResponseDTO.setName(product.getName());
        productResponseDTO.setCategory(product.getCategory());
        productResponseDTO.setPrice(product.getPrice());

        return productResponseDTO;
    }
}
