package com.bank.demo.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Person {

    @Id
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

    @ManyToMany(mappedBy = "persons")
    private Set<Account> accounts = new HashSet<>();

}
