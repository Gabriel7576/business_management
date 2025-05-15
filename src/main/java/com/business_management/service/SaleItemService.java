package com.business_management.service;

import com.business_management.domain.Product;
import com.business_management.domain.Sale;
import com.business_management.domain.SaleItem;
import com.business_management.dto.request.SaleItemRequestDTO;
import com.business_management.repository.ProductRepository;
import com.business_management.repository.SaleItemRepository;
import com.business_management.repository.SaleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleItemService {

    @Autowired
    private SaleItemRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SaleRepository saleRepository;

    public void saleItemSave(Long saleId, SaleItemRequestDTO requestDTO) {

        Product product = productRepository.findById(requestDTO.getProductId()).orElseThrow(() -> new EntityNotFoundException("Product not found with id " + requestDTO.getProductId()));
        Sale sale = saleRepository.findById(saleId).orElseThrow(() -> new EntityNotFoundException("Sale not found with id " + saleId));

        SaleItem saleItem = new SaleItem(requestDTO.getQuantity(), requestDTO.getUnitPrice(), sale, product);

        SaleItem saleItemSaved = repository.save(saleItem);

    }
}
