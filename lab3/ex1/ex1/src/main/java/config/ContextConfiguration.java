package config;

import aspects.BankAccountAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "service")
@EnableAspectJAutoProxy
public class ContextConfiguration {

    @Bean
    public BankAccountAspect bankAccountAspect() {
        return  new BankAccountAspect();
    }
}
