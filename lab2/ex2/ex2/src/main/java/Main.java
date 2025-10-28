import config.ContextConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.DbConnection;
import service.DbConnectionService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);
        System.out.println("In main class!");
//        DbConnection dbConnectionService = context.getBean(DbConnection.class);
//        dbConnectionService.connect();
        DbConnectionService dbConnectionService1 = context.getBean(DbConnectionService.class);
        DbConnectionService dbConnectionService2 = context.getBean(DbConnectionService.class);
        /**
         * bean initialization (lazy vs eager)
         * by default beans are eager initialized
         */

//        dbConnectionService1.connectToDatabase();

        /**
         * bean scope (singleton vs prototype)
         */
        System.out.println(dbConnectionService1.hashCode());
        System.out.println(dbConnectionService2.hashCode());

        //injectarea de prototype in singleton => singleton";
    }
}
