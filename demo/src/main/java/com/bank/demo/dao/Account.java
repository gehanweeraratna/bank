package com.bank.demo.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Account {

    @Id
    private long accountNumber;
    private String branchCode;
    private String branchName;
    private String currency;
    private double balance;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "person_account",
            joinColumns = { @JoinColumn(name = "accountNumber") },
            inverseJoinColumns = { @JoinColumn(name = "nationalId") })
    private Set<Person> persons = new HashSet<>();

    public void addPerson(Person p) {
        this.persons.add(p);
        p.getAccounts().add(this);
    }

    public void removePerson(Person p) {
        this.persons.remove(p);
        p.getAccounts().remove(this);
    }

}
