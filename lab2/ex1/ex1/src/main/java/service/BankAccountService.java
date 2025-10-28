package service;

import model.BankAccount;

public class BankAccountService {

    public void makeTransfer(BankAccount from, BankAccount to, double amount) {

        if(from.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        System.out.println("Transfer from " +
                from.getAccountNumber() + " to "
                + to.getAccountNumber() +
                " with amount " + amount + " was successful!");
    }
}
