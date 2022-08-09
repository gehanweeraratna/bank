package com.bank.demo.service;

import com.bank.demo.dao.Account;
import com.bank.demo.dao.Person;
import com.bank.demo.dto.PersonAccount;
import com.bank.demo.persistence.AccountRepository;
import com.bank.demo.persistence.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PersonRepository personRepository;

    public PersonAccount createAccount(PersonAccount personAccount) {
        Person person = new Person();
        Account account = new Account();
        BeanUtils.copyProperties(personAccount.getPerson(), person);
        BeanUtils.copyProperties(personAccount.getAccount(), account);
        personRepository.save(person);
        account.addPerson(person);
        accountRepository.save(account);
        return personAccount;
    }

    public com.bank.demo.dto.Account depositAmount(long accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        Account result = accountRepository.save(account);
        com.bank.demo.dto.Account updatedAccount = new com.bank.demo.dto.Account();
        BeanUtils.copyProperties(result, updatedAccount);
        return updatedAccount;
    }

    public com.bank.demo.dto.Account withdrawAmount(long accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        com.bank.demo.dto.Account updatedAccount = new com.bank.demo.dto.Account();
        if(account.getBalance() > amount) {
            double newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);
            Account result = accountRepository.save(account);
            BeanUtils.copyProperties(result, updatedAccount);
            return updatedAccount;
        } else {
            BeanUtils.copyProperties(account, updatedAccount);
            return updatedAccount;
        }
    }

}
