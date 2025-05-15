package com.business_management.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "sale_item")
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleItem_id;

    private Integer quantity;

    private BigDecimal unitPrice;

    @NotNull()
    @JoinColumn(name = "sale_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sale sale;

    @NotNull()
    @JoinColumn(name = "product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public SaleItem() {
    }

    public SaleItem(Integer quantity, BigDecimal unitPrice, Sale sale, Product product) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.sale = sale;
        this.product = product;
    }

    public Long getSaleItem_id() {
        return saleItem_id;
    }

    public void setSaleItem_id(Long saleItem_id) {
        this.saleItem_id = saleItem_id;
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

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
