package com.rinf.dell.test.dao;

import com.rinf.dell.test.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	Customer findByMail(String mail);
}