import config.ContextConfiguration;
import model.BankAccount;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.BankAccountRepository;
import service.BankAccountService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);
        /**
         * citire beans din context
          */

        //citire din context dupa nume
        BankAccountService bankAccountService1 = (BankAccountService) context.getBean("bankAcc1");

        //citire din context dupa tipul de clasa
//        BankAccountService bankAccountService2 = context.getBean(BankAccountService.class);


        BankAccount b1 = new BankAccount("0000501C5", "John Doe", 50000);
        BankAccount b2 = new BankAccount("0000502C5", "John Mirc", 60000);

        bankAccountService1.makeTransfer(b1,b2, 100);

        BankAccountRepository bankAccountRepository = (BankAccountRepository) context.getBean("bankAccountRepository");
        System.out.println(bankAccountRepository);

    }
}
