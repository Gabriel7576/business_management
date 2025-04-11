package com.business_management.controlle;

import com.business_management.domain.Product;
import com.business_management.dto.response.ProductCreationDTO;
import com.business_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> saveProduct(ProductCreationDTO creationDTO) {
        var product_id = service.saveProduct(creationDTO);

        return ResponseEntity.created(URI.create("/v1/product/" + product_id.toString())).build();
    }
}
