package com.business_management.controlle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business_management.service.StoreService;

@RestController
@RequestMapping("/v1/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

}
