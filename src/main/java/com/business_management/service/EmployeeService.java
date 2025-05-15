package com.business_management.service;

import com.business_management.domain.Employee;
import com.business_management.domain.Store;
import com.business_management.dto.request.EmployeeRequestDTO;
import com.business_management.dto.response.EmployeeResponseDTO;
import com.business_management.repository.EmployeeRepository;
import com.business_management.repository.StoreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private StoreRepository storeRepository;

    public Long saveEmployee(EmployeeRequestDTO requestDTO) {

        Store store = storeRepository.findById(requestDTO.getStoreId()).orElseThrow(() -> new EntityNotFoundException("Store not found with id " + requestDTO.getStoreId()));

        Employee employee = new Employee(requestDTO.getName(), requestDTO.getEmail(), requestDTO.getPhone(), store);

        Employee employeeSaved = repository.save(employee);

        return employeeSaved.getEmployee_id();
    }

    public Optional<EmployeeResponseDTO> findById(Long id) {

        return repository.findById(id).map(employee -> new EmployeeResponseDTO(employee.getEmployee_id(), employee.getName(), employee.getEmail(), employee.getPhone(), employee.getStore().getStore_id()));
    }

    public List<EmployeeResponseDTO> findAll() {

        return repository.findAll().stream().map(employee -> new EmployeeResponseDTO(employee.getEmployee_id(), employee.getName(), employee.getEmail(), employee.getPhone(), employee.getStore().getStore_id())).collect(Collectors.toList());
    }

    public void updateEmployee(Long id, EmployeeRequestDTO requestDTO) {

        Optional<Employee> entity = repository.findById(id);

        if (entity.isPresent()) {
            Employee employee = entity.get();

            if (requestDTO.getName() != null) employee.setName(requestDTO.getName());

            if (requestDTO.getPhone() != null) employee.setPhone(requestDTO.getPhone());

            if (requestDTO.getEmail() != null) employee.setEmail(requestDTO.getEmail());

            repository.save(employee);
        }

    }

    public void deleteById(Long id) {

        Optional<Employee> entity = repository.findById(id);

        if (entity.isPresent()) {
            repository.deleteById(id);
        }

    }

}
