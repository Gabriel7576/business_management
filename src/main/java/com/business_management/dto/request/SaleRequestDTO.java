package com.business_management.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class SaleRequestDTO {

    private Long employeeId;

    private Long storeId;

    private List<SaleItemRequestDTO> itemList;

    public SaleRequestDTO() {
    }

    public SaleRequestDTO(Long employeeId, Long storeId, List<SaleItemRequestDTO> itemList) {
        this.employeeId = employeeId;
        this.storeId = storeId;
        this.itemList = itemList;
    }


    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public List<SaleItemRequestDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<SaleItemRequestDTO> itemList) {
        this.itemList = itemList;
    }
}
