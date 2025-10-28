package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import service.BankAccountService;

@Configuration
@ComponentScan(basePackages = {"repository"})
public class ContextConfiguration {

    @Bean("bankAcc1")
    @Primary
    public BankAccountService bankAccountService1() {
        return new BankAccountService();
    }

    @Bean("bankAcc2")
    public BankAccountService bankAccountService2() {
        return new BankAccountService();
    }
}
