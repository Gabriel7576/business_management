package com.business_management.service;

import com.business_management.domain.Product;
import com.business_management.dto.response.ProductCreationDTO;
import com.business_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Long saveProduct(ProductCreationDTO creationDTO) {

        Product product = new Product(creationDTO.name(), creationDTO.description(), creationDTO.price());

        Product productSaved = repository.save(product);

        return  productSaved.getProduct_id();
    }
}
