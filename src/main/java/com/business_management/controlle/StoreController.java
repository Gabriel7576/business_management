package com.business_management.controlle;

import com.business_management.domain.Store;
import com.business_management.dto.request.StoreRequestDTO;
import com.business_management.dto.response.StoreResponseDTO;
import com.business_management.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService service;

    @PostMapping
    public ResponseEntity<StoreResponseDTO> saveStore(@RequestBody StoreRequestDTO requestDTO) {
        var store_id = service.saveStore(requestDTO);

        return ResponseEntity.created(URI.create("/v1/store/" + store_id.toString())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreResponseDTO> getStoreById(@PathVariable Long id) {
        var store = service.findById(id);

        return store.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<StoreResponseDTO>> findAll() {
        List<StoreResponseDTO> list = service.findAll();

        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStoreById(@PathVariable("id") Long id, @RequestBody StoreRequestDTO requestDTO) {
        service.updateStore(id, requestDTO);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
