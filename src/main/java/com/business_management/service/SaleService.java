package com.business_management.service;

import com.business_management.domain.Employee;
import com.business_management.domain.Product;
import com.business_management.domain.Sale;
import com.business_management.domain.Store;
import com.business_management.dto.request.SaleRequestDTO;
import com.business_management.repository.EmployeeRepository;
import com.business_management.repository.SaleRepository;
import com.business_management.repository.StoreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private SaleItemService saleItemService;

    public Long saveSale(SaleRequestDTO requestDTO) {

        BigDecimal totalValue = requestDTO.getItemList().stream()
                .map(item -> item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Employee employee = employeeRepository.findById(requestDTO.getEmployeeId()).orElseThrow(() -> new EntityNotFoundException("Employee not found with id " + requestDTO.getEmployeeId()));

        Store store = storeRepository.findById(requestDTO.getStoreId()).orElseThrow(() -> new EntityNotFoundException("Store not found with id " + requestDTO.getStoreId()));

        Sale sale = new Sale(LocalDateTime.now(), totalValue, employee, store);

        Sale saleSaved = repository.save(sale);

        requestDTO.getItemList().forEach(saleItem -> {
            saleItemService.saleItemSave(saleSaved.getSale_id(), saleItem);
        });


        return saleSaved.getSale_id();
    }
}
