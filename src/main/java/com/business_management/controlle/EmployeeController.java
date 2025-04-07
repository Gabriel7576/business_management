package com.business_management.controlle;

import com.business_management.domain.Employee;
import com.business_management.dto.request.EmployeeDTO;
import com.business_management.dto.response.EmployeeCreationDTO;
import com.business_management.dto.response.EmployeeUpdateDTO;
import com.business_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeCreationDTO creationDTO) {
        var employee_id = service.saveEmployee(creationDTO);

        return ResponseEntity.created(URI.create("/v1/employee/" + employee_id.toString())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        var EmployeeDTO = service.findById(id);

        return EmployeeDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        List<EmployeeDTO> list = service.findAll();

        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployeeById(@PathVariable("id") Long id, @RequestBody EmployeeUpdateDTO updateDTO) {
        service.updateEmployee(id, updateDTO);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
