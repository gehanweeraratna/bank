package com.bank.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Account {

    private long accountNumber;
    private String branchCode;
    private String branchName;
    private String currency;
    private double balance;

}
