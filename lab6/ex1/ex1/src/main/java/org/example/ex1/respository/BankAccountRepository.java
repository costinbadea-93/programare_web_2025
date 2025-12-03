package org.example.ex1.respository;

import lombok.RequiredArgsConstructor;
import org.example.ex1.model.BankAccount;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BankAccountRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<BankAccount> findAll() {
        String sql = "SELECT * FROM bank_account";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new BankAccount(
                rs.getInt("id"),
                rs.getString("account_number"),
                rs.getString("account_owner"),
                rs.getDouble("balance"),
                rs.getString("currency")
        ));
    }

    public void deleteBankAccountByAccountNumber(String accountNumber) {
        String sql = "DELETE FROM bank_account WHERE account_number = ?";
        jdbcTemplate.update(sql, accountNumber);
    }

    public  BankAccount createBankAccount(BankAccount bankAccount) {
        String sql = "INSERT INTO bank_account (account_number, account_owner, balance, currency) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update( con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, bankAccount.getAccountNumber());
            ps.setString(2, bankAccount.getAccountOwner());
            ps.setDouble(3, bankAccount.getBalance());
            ps.setString(4, bankAccount.getCurrency());
            return ps;
        }, keyHolder);
        bankAccount.setId(keyHolder.getKey().intValue());
        return bankAccount;
    }
}
