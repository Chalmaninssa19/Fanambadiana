package person;

import connex.*;
import java.sql.*;

public class PersoIndispo {
    int idIndispo, idPerso;

    //Les getters
    public int getIdIndispo() { return this.idIndispo; }
    public int getIdPerso() { return this.idPerso; }

    //Les setters
    public void setIdIndispo( int i ) { this.idIndispo = i; }
    public void setIdPerso( int i ) { this.idPerso = i; }

    //Inserer un critere dans la table
    public void insertPersoIndispo( int idInd, int idPers) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        ResultSet result = work.executeQuery("insert into PersoIndisponible values("+idInd+", "+idPers+")");
    }

    //Selectionner tous les personnes
    public ResultSet selectPersoIndispo() throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        ResultSet result = work.executeQuery("select * from PersoIndisponible");

        return result;
    }
}