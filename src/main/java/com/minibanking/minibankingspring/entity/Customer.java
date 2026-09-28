package com.minibanking.minibankingspring.entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Customer name wajib diisi")
    private String customerName;

    @NotBlank(message = "Account number wajib diisi")
    @Pattern(
            regexp = "\\d{10}",
            message = "Account number harus 10 digit"
    )
    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;

    @DecimalMin(
            value = "0.0",
            inclusive = true,
            message = "Balance tidak boleh negatif"
    )
    @NotNull(message = "Balance wajib diisi")
    @DecimalMin(
            value = "0.0",
            inclusive = true,
            message = "Balance tidak boleh negatif"
    )
    @Column(nullable = false)
    private Double balance;
    public Customer() {
    }

    public Customer(String customerName, String accountNumber, Double balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}