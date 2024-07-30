package person;

import connex.*;
import java.sql.*;
import java.util.*;

public class PersonAnnexe {
    int idPerso;
    String nom;
    String mdp;
    String sexe;
    String pays;
    int salaire;
    int fivavahana;
    int fiavanana;
    int diplome;
    int physics;
    String photo;

    //Les getters
    public int getIdPerso() { return this.idPerso; }
    public String getNom() { return this.nom; }
    public String getMdp() { return this.mdp; }
    public String getSexe() { return this.sexe; }
    public String getPays() { return this.pays; }
    public int getSalaire() { return this.salaire; }
    public int getFivavahana() { return this.fivavahana; }
    public int getFiavanana() { return this.fiavanana; }
    public int getDiplome() { return this.diplome; }
    public int getPhysics() { return this.physics; }
    public String getPhoto() { return this.photo; }
    
    //Les setters
    public void setIdPerso( int p ) { this.idPerso = p; }
    public void setNom( String n ) { this.nom = n; }
    public void setMdp( String m ) { this.mdp = m; }
    public void setSexe( String s ) { this.sexe = s; }
    public void setPays( String p ) { this.pays = p; }
    public void setSalaire( int s ) { this.salaire = s; }
    public void setFivavahana( int f ) { this.fivavahana = f; }
    public void setFiavanana( int f ) { this.fiavanana = f; }
    public void setDiplome( int d ) { this.diplome = d; }
    public void setPhysics( int p ) { this.physics = p; }
    public void setPhoto( String p ) { this.photo = p; }

    //calcul somme d'un tableau
    public int calculSomme( int [] tab) {
        int sum = 0;
        for ( int i = 0; i < tab.length; i++) {
            sum = sum + tab[i];
        }
        return sum;
    }
    //Inserer une personne dans la table
    public void insertPersoAnnexe( Vector<String> lesStrings, int [] lesInts) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        int incre = increment("getSeqPersAnn");
        int note = calculSomme(lesInts);

        ResultSet result = work.executeQuery("insert into PersoAnnexe values("+incre+", '"+lesStrings.get(0)+"', '"+lesStrings.get(1)+"', '"+lesStrings.get(2)+"', '"+lesStrings.get(3)+"', "+lesInts[0]+", "+lesInts[1]+", "+lesInts[2]+", "+lesInts[3]+", "+lesInts[4]+", "+note+")");
    }

    //Selectionner tous les personnes
    public ResultSet selectPersonAnnexe() throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        ResultSet result = work.executeQuery("select * from PersoAnnexe");

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

     //Selectionne le Id du connecte grace a son nom
     public int idConnect( String nom) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();

        ResultSet result = work.executeQuery("select IdPerso from PersoAnnexe where Nom='"+nom+"'");
        result.next();
        return Integer.valueOf(result.getString(1));
    }

    //Selectionne le membre grace a son id
    public ResultSet member( int id ) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();

        ResultSet result = work.executeQuery("select * from PersoAnnexe where IdPerso='"+id+"'");
        return result;
    }

    //Selectionne le nom d'un membre grace a son id
    public String memberName( int id ) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        String name = "";

        ResultSet result = work.executeQuery("select Nom from PersoAnnexe where IdPerso='"+id+"'");
        while(result.next()) {
            name = result.getString(1);
        }
        return name;
    }

    //Selectionne un membre grace a son nom
    public ResultSet memberLogin( String name ) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();

        ResultSet result = work.executeQuery("select * from PersoAnnexe where Nom='"+name+"'");
        return result;
    }

    //verifier si le mot de passe entre correspond
    public boolean verifyPwd( String pwd, String name ) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        String req = "select * from PersoAnnexe where Nom='"+name+"'";
        System.out.println(req);
        ResultSet result = work.executeQuery(req);
        if(result.next()) {
            if (result.getString(3).equals(pwd)) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    //Selectionne le sexe d'une membre grace a son id
    public String memberSexe( int id ) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();

        ResultSet result = work.executeQuery("select Sexe from PersoAnnexe where IdPerso='"+id+"'");
        result.next();
        return result.getString(1);
    }

    //Le dernier inscrit
    public ResultSet lastInscrit() throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        ResultSet result = work.executeQuery("select max(IdPersoAnnexe) from PersoAnnexe");

        return result;
    }

    //Sexe oppose
    public String sexOppose( String sexe ) throws Exception {
        if ( sexe == "masculin") return "Feminin";
        else return "Masculin";
    }
    //selectionne note grace a l'id connecte
    public ResultSet getNoteConnect( int idConnect ) throws Exception {
        Connex connex = new Connex();
        Connection conn = connex.DBconnect();
        Statement work = conn.createStatement();
        ResultSet result = work.executeQuery("select Note from PersoAnnexe where idPerso="+idConnect);

        return result;
    }

     //Rechercher les recommandations
     public Vector <Integer> recommandations( int note ) throws Exception {
        Vector <Integer> tab = new Vector<>();
        ResultSet res = selectPersonAnnexe();
        while( res.next()) {
            if ( Integer.parseInt(res.getString(11)) >= note) {
                tab.add(Integer.parseInt(res.getString(1)));
            }
        }
        return tab;
    }
 
    /*public static void main( String[] args ) throws Exception {
        System.out.println(memberName(25));
    }*/

}