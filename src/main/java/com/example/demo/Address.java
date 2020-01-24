package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Address {
    @Id
    private String zip;
    private String state, city, addressLine;
}
