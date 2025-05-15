package com.business_management.controlle;

import com.business_management.dto.request.ProductRequestDTO;
import com.business_management.dto.response.ProductResponseDTO;
import com.business_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> saveStore(@RequestBody ProductRequestDTO requestDTO) {
        var store_id = service.saveProduct(requestDTO);

        return ResponseEntity.created(URI.create("/v1/product/" + store_id.toString())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getStoreById(@PathVariable Long id) {
        var store = service.findById(id);

        return store.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        List<ProductResponseDTO> list = service.findAll();

        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProductById(@PathVariable("id") Long id, @RequestBody ProductRequestDTO requestDTO) {
        service.updateProduct(id, requestDTO);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
