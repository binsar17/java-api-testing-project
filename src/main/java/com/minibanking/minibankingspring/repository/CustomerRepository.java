package com.minibanking.minibankingspring.repository;

import com.minibanking.minibankingspring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}