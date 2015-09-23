package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Customer;

@Repository
public class CustomerRepository2 {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static final BeanPropertyRowMapper<Customer> customerRowMapper = new BeanPropertyRowMapper<Customer>(Customer.class);

    public List<Customer> findAll() {
        List<Customer> customers = jdbcTemplate.query(
                "SELECT id,first_name, first_name,last_name FROM customers ORDER BY id desc",
                customerRowMapper); // (2)
        return customers;
    }
}

