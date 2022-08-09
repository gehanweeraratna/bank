package com.bank.demo.persistence;

import com.bank.demo.dao.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long> {

    public Account findByAccountNumber(long accountNumber);

}
