package com.minibanking.minibankingspring.controller;

import com.minibanking.minibankingspring.entity.Customer;
import com.minibanking.minibankingspring.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer createCustomer(
            @Valid @RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(
            @PathVariable Long id,
            @Valid @RequestBody Customer customer) {

        Customer existingCustomer = customerService.getCustomerById(id);

        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setAccountNumber(customer.getAccountNumber());
        existingCustomer.setBalance(customer.getBalance());

        return customerService.saveCustomer(existingCustomer);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {

        // Cek customer terlebih dahulu
        customerService.getCustomerById(id);

        // Jika tidak ditemukan, method di atas akan menghasilkan 404
        customerService.deleteCustomer(id);

        return "Customer berhasil dihapus";
    }
}