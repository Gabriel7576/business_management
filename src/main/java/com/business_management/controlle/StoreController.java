package com.business_management.controlle;

import com.business_management.domain.Store;
import com.business_management.dto.response.StoreCreationDTO;
import com.business_management.dto.response.StoreUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.business_management.service.StoreService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService service;

    @PostMapping
    public ResponseEntity<Store> saveStore(@RequestBody StoreCreationDTO creationDTO) {
        var store_id = service.saveStore(creationDTO);

        return ResponseEntity.created(URI.create("/v1/store/" + store_id.toString())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long id) {
        var store = service.findById(id);

        return store.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Store>> findAll() {
        List<Store> list = service.findAll();

        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStoreById(@PathVariable("id") Long id, @RequestBody StoreUpdateDTO updateDTO) {
        service.updateStore(id, updateDTO);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
