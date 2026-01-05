package Database_JDBC;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class SampleJDBCConnection {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Step1: Load/register the Database driver
        Driver driverRef = new Driver();
        DriverManager.registerDriver(driverRef);

        //Step2: Connect DB
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shekharschema", "root", "$Company123$");

        if(connection!=null)
        {
            System.out.println("Connection is successfull!!");
        }

        //Step3: Create Sql Statements
        Statement stmt = connection.createStatement();

        //Step4 Execute SELECT query and get result
        ResultSet res = stmt.executeQuery("SELECT * FROM shekhardb.seleniumdb where Framework=\"TDD\"");
        while(res.next())
        {
            System.out.println(res.getString("QspId")+"==="+(res.getString("browser")+"==="+(res.getString("commonData")+"==="+(res.getString("Framework")))));
        }
        res.close();
        stmt.close();
        connection.close();
    }
}
