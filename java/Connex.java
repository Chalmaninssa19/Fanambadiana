package connex;
import java.sql.*;

public class Connex
{
    public Connection DBconnect() throws Exception {
        String username = "scott";
        String mdp = "tiger";

        // Etape 1 : Charger la classe de driver
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Etape 2 : creer connection
        Connection resultat = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", username, mdp);
        return resultat;
    }
}