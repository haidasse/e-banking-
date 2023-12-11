package org.sid.ebankingbackend;

import lombok.experimental.SuperBuilder;
import org.sid.ebankingbackend.entities.*;
import org.sid.ebankingbackend.enums.AccountStatus;
import org.sid.ebankingbackend.enums.OperationType;
import org.sid.ebankingbackend.repositories.AccountOperationRepository;
import org.sid.ebankingbackend.repositories.BankAccountRepository;
import org.sid.ebankingbackend.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(EbankingBackendApplication.class, args);
    }


@Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){


        return args -> {


        BankAccount bankAccount=bankAccountRepository.findById("2c233514-e885-4ea7-ae59-e4b164fef096").orElse(null);


        if (bankAccount!=null){

            System.out.println("***********************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());

            System.out.println(bankAccount.getClass().getSimpleName());
            if (bankAccount instanceof CurrentAccount){
                System.out.println("overDRaft"+" "+((CurrentAccount)bankAccount).getOveDraft());

            }else if (bankAccount instanceof SavingAccount) {
                System.out.println("interesrate"+" "+((SavingAccount)bankAccount).getInteresRate());
            }
            bankAccount.getAccountOperations().forEach( op->{

                System.out.println("======================"+"\n" +op.getType()+"\n"+op.getAmount()+"\n"+
                op.getOperationDate());




            });
        }

        };






}

//@Bean
   CommandLineRunner Start(
           CustomerRepository customerRepository,
            BankAccountRepository bankAccountRepository,
            AccountOperationRepository accountOperationRepository){
        return args -> {
            Stream.of("hassan","said","khalid").forEach(name->{
                        Customer cus=new Customer();
                        cus.setName(name);
                        cus.setEmail(name+"@gmail.com");
                        customerRepository.save(cus);

                    } );
            customerRepository.findAll().forEach(cus->{

                        CurrentAccount cat=new CurrentAccount();
                        cat.setId(UUID.randomUUID().toString());
                        cat.setBalance(Math.random()*70000);
                        cat.setCreatedAt(new Date());
                        cat.setStatus(AccountStatus.CREATED);
                        cat.setCustomer(cus);
                        cat.setOveDraft(9000);
                        bankAccountRepository.save(cat);



                        SavingAccount hh=new SavingAccount();
                        hh.setId(UUID.randomUUID().toString());
                        hh.setBalance(Math.random()*70000);
                        hh.setCreatedAt(new Date());
                        hh.setStatus(AccountStatus.CREATED);
                        hh.setCustomer(cus);
                        hh.setInteresRate(5.5);
                        bankAccountRepository.save(hh);





                    } );
         bankAccountRepository.findAll().forEach(acc->{
                   for (int i=0;i<5;i++){
                       AccountOperation ac=new AccountOperation();

                       ac.setOperationDate(new Date());
                       ac.setAmount(Math.random()*12000);
                       ac.setType(Math.random()>0.5? OperationType.DEBIT : OperationType.CREDIT);
                       ac.setBankAccount(acc);

                       accountOperationRepository.save(ac);

                   }



         });

        };




};

    }

