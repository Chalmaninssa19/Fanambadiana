package person;

import connex.*;
import java.sql.*;
import java.lang.*;
import java.text.*;
import java.util.Date;

public class Raikitra {
    int  idRaikitra;
    int idMasculin;
    int idFeminin;
    Date dateEvenement;

    //Les getters
    public int getIdRaikitra() { return this.idRaikitra; }
    public int getIdMasculin() { return this.idMasculin; }
    public int getIdFeminin() { return this.idFeminin; }
    public Date getDateEvenement() { return this.dateEvenement; }

    //Les setters
    public void setIdRaikitra( int ir ) { this.idRaikitra = ir; }
    public void setIdMasulin( int im ) { this.idMasculin = im; }
    public void setIdFeminin( int ife ) { this.idFeminin = ife; }

    //Inserer une personne dans la table
    public  void  insertRaikitra( int partner1, int partner2) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        int incr = increment("getSeqRaiki");
        ResultSet result = work.executeQuery("insert into Raikitra values("+incr+", "+partner1+", "+partner2+", "+dateNow()+")");
    }

    //inserer dans la table des personnes indisponibles
    public  void insertIndispo( int person) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        int incr = increment("getSeqPersIndispo");
        ResultSet result = work.executeQuery("insert into PersoIndisponnible values("+incr+", "+person+")");
    }

    //Selectionner tous les personnes
    public ResultSet selectRaikitra() throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        ResultSet result = work.executeQuery("select * from Raikitra");
                                
        return result;
    }

    //Auto increment
    public  int increment( String function) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();

        ResultSet result = work.executeQuery("select "+function+" from dual");
        result.next();
        return Integer.valueOf(result.getString(1));
    }

    //create date
    public static String dateNow() throws Exception {
        String values ="";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        values = values.concat("to_date('"+dateFormat.format(new Date()))+"','yyyy-MM-dd')";

        return values;
    } 

     //Verifier si le id a une invitation
     public boolean verifyRaikitra( int idConnect) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();

        ResultSet result = work.executeQuery("select * from Raikitra where idMasculin="+idConnect);
        
        if ( result.next()) return true;
        else return false;
    }

    //selectionner une ligne dans la table ggrace a un id
    public ResultSet selectCouple( int idConnect) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        ResultSet result = work.executeQuery("select * from Raikitra where idMasculin="+idConnect);
                                
        return result;
    }


   /* public static void main( String [] args) throws Exception {
         ResultSet res = selectCouple(25);
        while (res.next()) {
            System.out.println(res.getString(2));
            System.out.println("et "+res.getString(3));

        }
        }*/
}