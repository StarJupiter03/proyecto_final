
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String MYSQL_URL = "jdbc:mysql://containers-us-west-190.railway.app:5925/railway";
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PASSWORD = "9HgV8Q50l7GZKlAACiAG";

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
    }
}
