package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import repository.DbConnection;
import repository.OracleDbConnection;

@Service
//@Lazy
@Scope("prototype")
public class DbConnectionService {

//    @Autowired
//    @Qualifier("oracleDb")
    /**
     * Autowired -> field/constructor/setter injection
     * try to use it as much as you can on constructor injection
     */

    private final DbConnection dbConnection;

    public DbConnectionService(@Qualifier("oracleDb") DbConnection dbConnection){
        System.out.println("DbConnectionService instantiated with DbConnection: " + dbConnection.getClass().getSimpleName());
        this.dbConnection = dbConnection;
    }

    public void connectToDatabase() {
        dbConnection.connect();
    }
}
