package org.example.ex1.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BankAccount {
    @NotNull(message = "Account number cannot be null")
    private String accountNumber;
    @NotNull(message = "Account owner cannot be null")
    private String accountOwner;
    private double balance;
    private String currency;
}
