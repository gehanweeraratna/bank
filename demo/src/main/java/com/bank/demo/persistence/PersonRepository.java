package com.bank.demo.persistence;

import com.bank.demo.dao.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,String> {

    public Person findByNationalId(String nationalId);

}
