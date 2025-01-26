package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DataBaseConnection {

    private static DataBaseConnection instance;
    private final Connection connection;

    private DataBaseConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc", "postgres", "root");
        } catch (SQLException exception){
            throw new RuntimeException("An error occurred while connecting to the database");
        }
    }

    public static DataBaseConnection getInstance(){
        if(Objects.isNull(instance)){
            instance = new DataBaseConnection();
        }
        return instance;
    }

    public Connection connection(){
        return connection;
    }
}
