package org.example.ex1.controller;

import lombok.RequiredArgsConstructor;
import org.example.ex1.model.BankAccount;
import org.example.ex1.service.BankAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    /**
     *      MVC -> MODEL VIEW CONTROLLER
     */

//    public BankAccountController(BankAccountService bankAccountService) {
//        this.bankAccountService = bankAccountService;
//    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("bankAccount", new BankAccount());
        model.addAttribute("data", bankAccountService.getBankAccounts());
        return "index";
    }

    @GetMapping("/delete/{accountNumber}")
    public String deleteBankAccount(Model model, @PathVariable String accountNumber) {
        bankAccountService.deleteBankAccountByAccountNumber(accountNumber);
        model.addAttribute("bankAccount", new BankAccount());
        model.addAttribute("data", bankAccountService.getBankAccounts());
        return "index";
    }

    @PostMapping("/bankAccount/new")
    public String newBankAccount(Model model, @ModelAttribute("bankAccount") BankAccount bankAccount) {
        bankAccountService.createBankAccount(bankAccount);
        model.addAttribute("data", bankAccountService.getBankAccounts());
        return "index";
    }
}
