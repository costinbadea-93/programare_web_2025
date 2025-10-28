package service;

import model.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class BankAccountService {

    public boolean makeTransfer(BankAccount from, BankAccount to, double amount){
        if(from.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds!");
        }
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        System.out.println("Transfer of " + amount + " from " + from.getAccountNumber() + " to " + to.getAccountNumber() + " completed.");
        return true;
    }
}
