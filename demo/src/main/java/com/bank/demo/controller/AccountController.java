package com.bank.demo.controller;

import com.bank.demo.dto.Account;
import com.bank.demo.dto.PersonAccount;
import com.bank.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = {"/createAccount", "/createAccount.json"}, method = RequestMethod.POST)
    public PersonAccount createAccount(@RequestBody PersonAccount personAccount,
                              HttpServletRequest request,
                              HttpServletResponse response) throws Exception {
        accountService.createAccount(personAccount);
        return personAccount;
    }

    @RequestMapping(value = {"/deposit/{amount}", "/deposit{amount}.json"}, method = RequestMethod.POST)
    public Account deposit(@RequestBody Account account, @PathVariable double amount,
                           HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
        long accountNum = account.getAccountNumber();
        return accountService.depositAmount(accountNum, amount);
    }

    @RequestMapping(value = {"/withdraw/{amount}", "/deposit{amount}.json"}, method = RequestMethod.POST)
    public Account withdraw(@RequestBody Account account, @PathVariable double amount,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        long accountNum = account.getAccountNumber();
        return accountService.withdrawAmount(accountNum, amount);
    }

}
