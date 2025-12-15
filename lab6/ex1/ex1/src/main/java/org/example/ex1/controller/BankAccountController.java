package org.example.ex1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.ex1.model.BankAccount;
import org.example.ex1.service.BankAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bank-accounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @GetMapping("/list")
    public ResponseEntity<List<BankAccount>> getAllBankAccounts() {
        return ResponseEntity.ok(bankAccountService.getBankAccounts());
    }

    @DeleteMapping("/remove/{accountNumber}")
    public void removeBankAccount(@Parameter(
            description = "accountNumber of the bank account",
            required = true) @PathVariable String accountNumber) {
        bankAccountService.removeBankAccount(accountNumber);
    }

    @PostMapping("/new")
//    @Tag(name = "get", description = "create bank account")
//    @Operation(summary = "Creating new bank account",
//            description = "Creating new bank account with the provided details")
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json",
//                    schema = @Schema(implementation = BankAccount.class))}),
//            @ApiResponse(responseCode = "404", description = "Bank Account not found",
//                    content = @Content)})
    public ResponseEntity<BankAccount> createBankAccount(@RequestBody BankAccount bankAccount) {
        return ResponseEntity.ok(bankAccountService.createBankAccount(bankAccount));
    }

}
