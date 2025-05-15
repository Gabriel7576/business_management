package com.business_management.controlle;

import com.business_management.dto.request.SaleRequestDTO;
import com.business_management.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService service;

    @PostMapping
    public ResponseEntity<SaleRequestDTO> saveSale(@RequestBody SaleRequestDTO requestDTO) {
        var sale_id = service.saveSale(requestDTO);

        return ResponseEntity.created(URI.create("/v1/sale/" + sale_id.toString())).build();
    }

}
