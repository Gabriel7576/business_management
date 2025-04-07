package com.business_management.service;

import com.business_management.domain.Employee;
import com.business_management.domain.Store;
import com.business_management.dto.request.EmployeeDTO;
import com.business_management.dto.response.EmployeeCreationDTO;
import com.business_management.dto.response.EmployeeUpdateDTO;
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

    public Long saveEmployee(EmployeeCreationDTO creationDTO) {

        Store store = storeRepository.findById(creationDTO.store_id()).orElseThrow(() -> new EntityNotFoundException("Store not found with id " + creationDTO.store_id()));

        Employee employee = new Employee(creationDTO.name(), creationDTO.email(), creationDTO.phone(), store);

        Employee employeeSaved = repository.save(employee);

        return employeeSaved.getEmployee_id();
    }

    public Optional<EmployeeDTO> findById(Long id) {
        return repository.findById(id).map(employee -> new EmployeeDTO(employee.getEmployee_id(), employee.getName(), employee.getEmail(), employee.getPhone(), employee.getStore().getStore_id()));
    }

    public List<EmployeeDTO> findAll() {
        return repository.findAll().stream().map(employee -> new EmployeeDTO(employee.getEmployee_id(), employee.getName(), employee.getEmail(), employee.getPhone(), employee.getStore().getStore_id())).collect(Collectors.toList());
    }

    public void updateEmployee(Long id, EmployeeUpdateDTO updateDTO) {

        Optional<Employee> employeeEntity = repository.findById(id);

        if (employeeEntity.isPresent()) {
            Employee employee = employeeEntity.get();

            if (updateDTO.name() != null) employee.setName(updateDTO.name());

            if (updateDTO.phone() != null) employee.setPhone(updateDTO.phone());

            if (updateDTO.email() != null) employee.setEmail(updateDTO.email());

            repository.save(employee);
        }

    }

    public void deleteById(Long id) {

        Optional<Employee> EmployeeEntity = repository.findById(id);

        if (EmployeeEntity.isPresent()) {
            repository.deleteById(id);
        }

    }

}
