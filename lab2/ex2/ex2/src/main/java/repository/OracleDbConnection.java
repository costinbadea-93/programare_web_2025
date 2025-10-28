package repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("oracleDb")
public class OracleDbConnection implements  DbConnection{
    @Override
    public void connect() {
        System.out.println("Connecting to Oracle Database...");
    }
}
