package com.example;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
import com.example.repository.CustomerRepository2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerRepository2 customerRepository2;

    @Override
    public void run(String... strings) throws Exception {
        // データ追加
        Customer created = customerRepository.save(new Customer(null, "Sugio", "Deki"));
        System.out.println(created + " is created!");
        // データ表示
        customerRepository.findAllOrderByName()
                .forEach(System.out::println);
        System.out.println("hogehoge!!!!!!!!!");
        customerRepository2.findAll().forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
