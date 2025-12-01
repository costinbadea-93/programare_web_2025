package org.example.ex1.controller;

import jakarta.validation.Valid;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.example.ex1.model.BankAccount;
import org.example.ex1.service.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilderFactory;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bankAccount")
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @GetMapping("/list")
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountService.getBankAccounts();
    }

    @PostMapping("/new")
    public ResponseEntity<BankAccount> createBankAccount(@RequestBody @Valid BankAccount bankAccount) {

        URI uri = URI.create("/bankAccount");
        return ResponseEntity.created(uri).body(bankAccountService.createBankAccount(bankAccount));
    }

//    @DeleteMapping("/remove/{accountNumber}")
//    public void deleteBankAccount(@PathVariable String accountNumber) {
//        bankAccountService.deleteBankAccountByAccountNumber(accountNumber);
//    }

    @DeleteMapping("/remove")
    public void deleteBankAccount(@RequestParam String accountNumber) {
        bankAccountService.deleteBankAccountByAccountNumber(accountNumber);
    }

}
