package org.sid.ebankingbackend.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.sid.ebankingbackend.entities.BankAccount;
import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.repositories.AccountOperationRepository;
import org.sid.ebankingbackend.repositories.BankAccountRepository;
import org.sid.ebankingbackend.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private CustomerRepository customerRepository;
    private  BankAccountRepository bankAccountRepository;
    private AccountOperationRepository accountOperationRepository;
    Logger log=LoggerFactory.getLogger(this.getClass().getName());
    @Override
    public Customer saveCustomer(Customer Customer) {
        return null;
    }

    @Override
    public BankAccount saveBankAccount(double initialBalanc, String type, Long customerId) {
        return null;
    }

    @Override
    public List<Customer> listCustomer() {
        return null;
    }

    @Override
    public BankAccount getBankAccount(String AccountId) {
        return null;
    }

    @Override
    public void debut(String AccountId, double amount, String description) {

    }

    @Override
    public void credit(String AccountId, double amount, String description) {

    }

    @Override
    public void transfer(String accountIdSource, String accountIdDestination, double amount) {

    }
}
