package com.business_management.dto.request;

import java.math.BigDecimal;

public class SaleItemRequestDTO {

    private Integer quantity;

    private BigDecimal unitPrice;

    private Long productId;

    public SaleItemRequestDTO() {
    }

    public SaleItemRequestDTO(Integer quantity, BigDecimal unitPrice, Long saleId, Long productId) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
