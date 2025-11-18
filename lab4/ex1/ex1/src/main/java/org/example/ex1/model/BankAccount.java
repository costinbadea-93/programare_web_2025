package org.example.ex1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BankAccount {
    private String accountNumber;
    private String accountOwner;
    private double balance;
    private String currency;
}
