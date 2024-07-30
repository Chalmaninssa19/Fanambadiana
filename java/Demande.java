package person;

import connex.*;
import java.sql.*;
import java.lang.*;
import java.text.*;
import java.util.Date;
import java.util.Vector;

public class Demande {
    int idDemande;
    int idDemandeur;
    int idInvite;
    Date invitation;

    //Les getters
    public int getIdDemande() { return this.idDemande; }
    public int getIdDemandeur() { return this.idDemandeur; }
    public int getIdInvite() { return this.idInvite; }
    public Date getInvitation() { return this.invitation; }

    //Les setters
    public void setIdDemande( int id ) { this.idDemande = id; }
    public void setIdDemandeur( int id ) { this.idDemandeur = id; }
    public void setIdInvite( int id ) { this.idInvite = id;}
    public void setInvitation( Date inv) { this.invitation = inv; }

    //Inserer une demande
   public void insertDemande( int idDemandeur, int idInvite) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        int incr = increment( "getSeqDem");
        ResultSet result = work.executeQuery("insert into demande values ("+incr+", "+idDemandeur+", "+idInvite+", "+dateNow()+" )");
    }

    //Effacer une ligne dans la table
    public void deleteDemande( int idConnect) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        work.executeUpdate("delete from demande where idInvite="+idConnect);
    }

      //Auto increment
      public int increment( String function) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();

        ResultSet result = work.executeQuery("select "+function+" from dual");
        result.next();
        return Integer.valueOf(result.getString(1));
    }

    //create date
    public String dateNow() throws Exception {
        String values ="";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        values = values.concat("to_date('"+dateFormat.format(new Date()))+"','yyyy-MM-dd')";

        return values;
    } 

    //Verifier si le id a une invitation
    public boolean verifyInvitation( int idConnect) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();

        ResultSet result = work.executeQuery("select * from Demande where idInvite="+idConnect);
        
        if ( result.next()) return true;
        else return false;
    }

    //select idDemandeur grace a l'idInvite
    public int demandeur( int idConnect ) throws Exception  {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        int idDemandeur = 0;

        ResultSet result = work.executeQuery("select idPerso from PersoAnnexe where idPerso in ( select idDemandeur from Demande where idInvite="+idConnect+")");

        while(result.next()) {
            idDemandeur = result.getInt(1);
        }

        return idDemandeur;
    }

    //selectionner la table de l'invitaition grace a l'id
    public Date dateInvitation( int idDemandeur ) throws Exception  {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        Date dateInvite = null;

        ResultSet result = work.executeQuery("select dateInvitation from demande where idDemandeur="+idDemandeur);
        while( result.next() ) {
            dateInvite = result.getDate(1);
        }

        return dateInvite;
    }
 

    /*public static void main( String [] args ) throws Exception {
        deleteDemande(25);
    }*/
}