package person;

import connex.*;
import java.sql.*;

public class CritereAnnexe {
    int idCritereAnnexe;
    int idPerso;                                                                                                                     
    int salaire;
    int fivavahana;
    int fiavanana;
    int diplome;
    int physics;

    //Les getters
    public int getIdCritereAnnexe() { return this.idCritereAnnexe; }
    public int getIdPerso() { return this.idPerso; }
    public int getSalaire() { return this.salaire; }
    public int getFivavahana() { return this.fivavahana; }
    public int getFiavanana() { return this.fiavanana; }
    public int getDiplome() { return this.diplome; }
    public int getPhysics() { return this.physics; }
    
    //Les setters
    public void setIdCritereAnnexe( int id ) { this.idCritereAnnexe = id; }
    public void setIdPero( int id ) { this.idPerso = id; }
    public void setSalaire( int s ) { this.salaire = s; }
    public void setFivavahana( int f ) { this.fivavahana = f; }
    public void setFiavanana( int f ) { this.fiavanana = f; }
    public void setDiplome( int d ) { this.diplome = d; }
    public void setPhysics( int p ) { this.physics = p; }

    //Inserer un critere dans la table
    public void insertCriterePersoAnnexe( int [] tab, String sexe) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        PersonAnnexe person = new PersonAnnexe();
        int incr = increment("getSeqCritAnn");
        int note = person.calculSomme(tab);
        ResultSet result = work.executeQuery("insert into CriterePersonAnnexe values("+incr+", "+tab[0]+", '"+sexe+"', "+tab[1]+", "+tab[2]+", "+tab[3]+", "+tab[4]+", "+tab[5]+", "+note+")");
        
    }

    //Selectionner tous les criteres
    public ResultSet selectCriterePersonAnnexe() throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        ResultSet result = work.executeQuery("select * from CriterePersonAnnexe");

        return result;
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
    //Selectionner l'idCritere dans la criterePersoAnnexe
    public ResultSet selectIdCritere( int idPerso) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        ResultSet result = work.executeQuery("select * from CriterePersonAnnexe where Idperson ="+idPerso);

        return result;
    }
    //selectionner la note d'un critere grace a l'id connecte
    public ResultSet noteCrit( int idConnect ) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        ResultSet result = work.executeQuery("select Note from CriterePersonAnnexe where idPerson = "+idPerso+")");

        return result;
    }
/*
    public static void main( String [] args ) throws Exception {
        ResultSet res = selectIdCritere(1);
        while( res.next()) {
            System.out.println(res.getString(2));
        } 
    }
 */
}   