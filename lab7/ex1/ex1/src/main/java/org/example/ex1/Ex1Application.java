package org.example.ex1;

import lombok.RequiredArgsConstructor;
import org.example.ex1.model.AccountOwner;
import org.example.ex1.model.BankAccount;
import org.example.ex1.repository.AccountOwnerRepository;
import org.example.ex1.repository.BankAccountRepository;
import org.example.ex1.service.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Ex1Application implements CommandLineRunner {
//    private final AccountOwnerRepository accountOwnerRepository;
//    private final BankAccountRepository bankAccountRepository;
    private final BankAccountService bankAccountService;

    public static void main(String[] args) {
        SpringApplication.run(Ex1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        AccountOwner accountOwner = AccountOwner.builder()
//                .accountOwnerName("John Doe")
//                .build();
//
//        AccountOwner savedAccOwner = accountOwnerRepository.save(accountOwner);
//
//        BankAccount bankAccount = BankAccount.builder()
//                .accountNumber("1234567890")
//                .balance(2000.0)
//                .currency("RON")
//                .accountOwner(accountOwner)
//                .build();
//
//        bankAccountRepository.save(bankAccount);
        /**
         * Tranzactie = o succesiune de operatii in cadrul carora, daca una da fail o sa se faca rollback;
         * "ACID" = Atomicitate, Consistenta, Izolare, Durabilitate
         * -propagare: tine de pasare contextului tranzactional dintr o functie in alta
         * -izolare: tine de cum citeste o tranzactatie raportat la o alta tranzactie
         */

        bankAccountService.add10BankAccOwners();
    }
}
