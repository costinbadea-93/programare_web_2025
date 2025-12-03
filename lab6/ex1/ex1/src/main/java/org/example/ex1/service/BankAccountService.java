package org.example.ex1.service;

import lombok.RequiredArgsConstructor;
import org.example.ex1.controller.BankAccountController;
import org.example.ex1.model.BankAccount;
import org.example.ex1.respository.BankAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankAccountService {

   private List<BankAccount> bankAccounts = new ArrayList<>();
   private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountController.class);
   private final BankAccountRepository bankAccountRepository;

    public BankAccount createBankAccount(BankAccount bankAccount) {
        bankAccountRepository.createBankAccount(bankAccount);
        LOGGER.info("Bank Account created: {}", bankAccount);
        return bankAccount;
    }

    public List<BankAccount>  getBankAccounts(){
        List<BankAccount> bankAccountList = bankAccountRepository.findAll();
        LOGGER.info("Returning bank accounts: {}", bankAccountList);
        return  bankAccountList;
    }

    public void removeBankAccount(String accountNumber) {
        bankAccountRepository.deleteBankAccountByAccountNumber(accountNumber);
        LOGGER.info("Bank Account removed: {}", accountNumber);
    }
}
