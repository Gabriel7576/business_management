package com.business_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business_management.repository.StoreRepository;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

}
