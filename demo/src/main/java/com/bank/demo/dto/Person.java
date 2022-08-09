package com.bank.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Person {

    private String nationalId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String sex;
    private String email;
    private String mobile;
    private String address;
    private String street;
    private String city;
    private String country;

}
