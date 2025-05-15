package com.business_management.dto.response;

public class EmployeeResponseDTO {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private Long storeId;

    public EmployeeResponseDTO() {
    }

    public EmployeeResponseDTO(Long id, String name, String email, String phone, Long storeId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.storeId = storeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
