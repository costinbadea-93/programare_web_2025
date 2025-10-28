package repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mysqlDb")
public class MySqlDbConnection implements DbConnection {
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL database...");
    }
}
