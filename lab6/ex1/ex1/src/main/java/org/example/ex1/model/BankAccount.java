package org.example.ex1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class BankAccount {
    private Integer id;
    private String accountNumber;
    private String accountOwner;
    private double balance;
    private String currency;
}
