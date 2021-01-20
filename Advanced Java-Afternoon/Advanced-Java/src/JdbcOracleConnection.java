

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * This program demonstrates how to make database connection with Oracle
 * database server.
 * @author www.codejava.net
 *
 */
public class JdbcOracleConnection {

    public static void DBwrite(assignment ass) {

        Connection conn1 = null;
        Connection conn2 = null;
        Connection conn3 = null;

        try {
            // registers Oracle JDBC driver - though this is no longer required
            // since JDBC 4.0, but added here for backward compatibility
            Class.forName("oracle.jdbc.OracleDriver");
            String dbURL2 = "jdbc:oracle:thin:@localhost:1521:orcl";
            String username = "sys as sysdba";
            String password = "Gamerz1234";
            conn2 = DriverManager.getConnection(dbURL2, username, password);
            if (conn2 != null) {
                System.out.println("Connected with connection #2");
            }
            String sql = "INSERT INTO ASSIGNMENTS (ID, NAME, PROGLANG, STATUS) "
                    + "VALUES ('" + ass.getId().toString() + "','" + ass.getName() + "','" + ass.getProgLang() + "','" + ass.getStatus() + "')";

            Statement statement = conn2.createStatement();
            int rows = statement.executeUpdate(sql);

            if(rows > 0){
                System.out.println("Row Inserted");
            }

            statement.close();

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn1 != null && !conn1.isClosed()) {
                    conn1.close();
                }
                if (conn2 != null && !conn2.isClosed()) {
                    conn2.close();
                }
                if (conn3 != null && !conn3.isClosed()) {
                    conn3.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}