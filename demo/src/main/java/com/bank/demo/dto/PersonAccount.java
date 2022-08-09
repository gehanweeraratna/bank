package com.bank.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonAccount {

    private Person person;
    private Account account;

}
