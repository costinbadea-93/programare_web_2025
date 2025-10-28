import config.ContextConfiguration;
import model.BankAccount;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BankAccountService;

public class Main {
    public static void main(String[] args) {
        /**
         * join-point(JoinPoint pt primele 4 advice-uri), around(ProceedingJoinPoint pt)  -> obiectul prin care facem interceptarea
         * pointcut -> expresie ce stie sa targeteze locul de interceptare - AspectJ
         * advice :
         *      - before
         *      - after
         *      - after returning
         *      - after throwing
         *      - around(cel mai puternic advice, poate schimba comportamentul metodelor)
         */

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        BankAccount b1 = BankAccount.builder()
                .accountNumber("0000501C5")
                .accountOwner("Adrian Calancea")
                .balance(2500.0)
                .build();

        BankAccount b2 = BankAccount.builder()
                .accountNumber("0000502C5")
                .accountOwner("Ionut Calin")
                .balance(2500.0)
                .build();

        BankAccountService bankAccountService = context.getBean(BankAccountService.class);
        bankAccountService.makeTransfer(b1, b2, 5000.0);
    }
}
