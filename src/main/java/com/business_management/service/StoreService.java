package com.business_management.service;

import com.business_management.domain.Store;
import com.business_management.dto.response.StoreCreationDTO;
import com.business_management.dto.response.StoreUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business_management.repository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository repository;

    public Long saveStore(StoreCreationDTO creationDTO) {

        Store entity = new Store(creationDTO.name(), creationDTO.address(), creationDTO.phone(), creationDTO.email());

        Store storeSaved = repository.save(entity);

        return storeSaved.getStore_id();
    }

    public Optional<Store> findById(Long id) {
        return repository.findById(id);
    }

    public List<Store> findAll() {
        return repository.findAll();
    }

    public void updateStore(Long id, StoreUpdateDTO updateDTO) {

        Optional<Store> storeEntity = findById(id);

        if (storeEntity.isPresent()) {
            Store store = storeEntity.get();

            if (updateDTO.name() != null)
                store.setName(updateDTO.name());

            if (updateDTO.address() != null)
                store.setAddress(updateDTO.address());

            if (updateDTO.phone() != null)
                store.setPhone(updateDTO.phone());

            if (updateDTO.email() != null)
                store.setEmail(updateDTO.email());

            repository.save(store);
        }

    }

    public void deleteById(Long id) {

        Optional<Store> storeEntity = findById(id);

        if (storeEntity.isPresent()) {
            repository.deleteById(id);
        }

    }


}
