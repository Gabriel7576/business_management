package com.business_management.service;

import com.business_management.domain.Store;
import com.business_management.dto.request.StoreRequestDTO;
import com.business_management.dto.response.StoreResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business_management.repository.StoreRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoreService {

    @Autowired
    private StoreRepository repository;

    public Long saveStore(StoreRequestDTO requestDTO) {

        Store entity = new Store(requestDTO.getName(), requestDTO.getAddress(), requestDTO.getPhone(), requestDTO.getEmail());

        Store storeSaved = repository.save(entity);

        return storeSaved.getStore_id();
    }

    public Optional<StoreResponseDTO> findById(Long id) {

        return repository.findById(id).map(store -> new StoreResponseDTO(store.getStore_id(), store.getName(), store.getAddress(), store.getPhone(), store.getEmail()));
    }

    public List<StoreResponseDTO> findAll() {
        return repository.findAll().stream().map(store -> new StoreResponseDTO(store.getStore_id(), store.getName(), store.getAddress(), store.getPhone(), store.getEmail())).collect(Collectors.toList());
    }

    public void updateStore(Long id, StoreRequestDTO requestDTO) {

        Optional<Store> entity = repository.findById(id);

        if (entity.isPresent()) {
            Store store = entity.get();

            if (requestDTO.getName() != null)
                store.setName(requestDTO.getName());

            if (requestDTO.getAddress() != null)
                store.setAddress(requestDTO.getAddress());

            if (requestDTO.getPhone() != null)
                store.setPhone(requestDTO.getPhone());

            if (requestDTO.getEmail() != null)
                store.setEmail(requestDTO.getEmail());

            repository.save(store);
        }

    }

    public void deleteById(Long id) {

        Optional<Store> entity = repository.findById(id);

        if (entity.isPresent()) {
            repository.deleteById(id);
        }

    }


}
