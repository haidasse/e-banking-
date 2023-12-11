package org.sid.ebankingbackend.services;

import org.sid.ebankingbackend.entities.BankAccount;
import org.sid.ebankingbackend.entities.Customer;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer(Customer Customer);
    BankAccount saveBankAccount(double initialBalanc,String type,Long customerId);
    List<Customer> listCustomer();
    BankAccount getBankAccount(String AccountId);
    void  debut(String AccountId,double amount,String description);
    void  credit(String AccountId,double amount,String description);
    void transfer(String accountIdSource,String accountIdDestination,double amount);
}
