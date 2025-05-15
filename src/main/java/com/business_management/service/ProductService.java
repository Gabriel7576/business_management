package com.business_management.service;

import com.business_management.domain.Product;
import com.business_management.dto.request.ProductRequestDTO;
import com.business_management.dto.response.ProductResponseDTO;
import com.business_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Long saveProduct(ProductRequestDTO requestDTO) {

        Product product = new Product(requestDTO.getName(), requestDTO.getDescription(), requestDTO.getPrice());

        Product productSaved = repository.save(product);

        return productSaved.getProduct_id();
    }

    public Optional<ProductResponseDTO> findById(Long id) {

        return repository.findById(id).map(product -> new ProductResponseDTO(product.getProduct_id(), product.getName(), product.getDescription(), product.getPrice()));
    }

    public List<ProductResponseDTO> findAll() {

        return repository.findAll().stream().map(product -> new ProductResponseDTO(product.getProduct_id(), product.getName(), product.getDescription(), product.getPrice())).collect(Collectors.toList());
    }

    public void updateProduct(Long id, ProductRequestDTO requestDTO) {

        Optional<Product> entity = repository.findById(id);

        if (entity.isPresent()) {
            Product product = entity.get();

            if (requestDTO.getName() != null) product.setName(requestDTO.getName());

            if (requestDTO.getDescription() != null) product.setDescription(requestDTO.getDescription());

            if (requestDTO.getPrice() != null) product.setPrice(requestDTO.getPrice());

            repository.save(product);
        }

    }

    public void deleteById(Long id) {

        Optional<Product> entity = repository.findById(id);

        if (entity.isPresent()) {
            repository.deleteById(id);
        }

    }


}
