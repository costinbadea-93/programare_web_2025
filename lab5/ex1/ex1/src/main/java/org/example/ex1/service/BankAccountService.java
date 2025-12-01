package org.example.ex1.service;

import org.example.ex1.model.BankAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {

    private List<BankAccount> bankAccounts = new ArrayList<>();

    public BankAccountService() {
        BankAccount bankAccount1 = BankAccount.builder()
                .accountNumber("001A")
                .accountOwner("John Doe")
                .balance(1000)
                .currency("USD")
                .build();

        BankAccount bankAccount2 = BankAccount.builder()
                .accountNumber("002B")
                .accountOwner("Jane Smith")
                .balance(2000)
                .currency("EUR")
                .build();

        BankAccount bankAccount3 = BankAccount.builder()
                .accountNumber("003C")
                .accountOwner("Alice Johnson")
                .balance(2000)
                .currency("EUR")
                .build();

        bankAccounts.add(bankAccount1);
        bankAccounts.add(bankAccount2);
        bankAccounts.add(bankAccount3);
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public BankAccount createBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
        return bankAccount;
    }

    public void deleteBankAccountByAccountNumber(String accountNumber) {
        bankAccounts.removeIf(bankAccount -> bankAccount.getAccountNumber().equalsIgnoreCase(accountNumber));
    }
}
