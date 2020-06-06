/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendrier.DAO;


import calendrier.controleur.Connexion;
import calendrier.modele.Seance;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alexi
 */
public class SeanceDAO extends DAO<Seance> {
    public SeanceDAO(Connection connect) {
        super(connect);
    }

    @Override
    public boolean create(Seance obj) {
        return false;
    }

    @Override
    public boolean delete(Seance obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Seance obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Seance> findAll(int id,int droit){
        ArrayList<Seance> seances= new ArrayList<Seance>();
        String request=null;
        String nameId="";
        if  (droit==4){
            request="SELECT * FROM seance_groupes INNER JOIN etudiant ON seance_groupes.Id_groupe = etudiant.Id_groupe WHERE Id_utilisateur="+id;
            nameId="Id_seance";
        }
        else if (droit==3){
            request="SELECT * FROM seance_enseignants WHERE Id_enseignant="+id;
            nameId="Id_seance";
        }
        else{
            request="SELECT id FROM seance";
            nameId="id";
        }
        try{
            ResultSet result = connect.createStatement(
             ResultSet.TYPE_SCROLL_INSENSITIVE,
             ResultSet.CONCUR_READ_ONLY)
             .executeQuery(request);
            while (result.next()){
                seances.add(find(result.getInt(nameId)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seances;
    }

    @Override
    public Seance find(int id) {
        Seance seance = new Seance();
        try{
            ResultSet result = connect.createStatement(
             ResultSet.TYPE_SCROLL_INSENSITIVE,
             ResultSet.CONCUR_READ_ONLY)
             .executeQuery("SELECT * FROM seance WHERE id="+id);
            if(result.first()){
                ResultSet result2 = connect.createStatement(
                 ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY)
                 .executeQuery("SELECT * FROM type_cours WHERE id="+result.getInt("Id_type"));
                ResultSet result3 = connect.createStatement(
                 ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY)
                 .executeQuery("SELECT * FROM cours WHERE id="+result.getInt("Id_cours"));
                Date date= result.getDate("date");
                ArrayList<String> enseignants =new ArrayList<String>();
                ResultSet result4 = connect.createStatement(
                 ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY)
                 .executeQuery("SELECT * FROM seance_enseignants JOIN utilisateur WHERE Id_seance="+id+" and Id_enseignant=id");
                while(result4.next()){
                    enseignants.add(result4.getString("nom")+" "+result4.getString("prenom"));
                }
                ArrayList<String> salles =new ArrayList<String>();
                int capacite=0;
                String sites=null;
                result4 = connect.createStatement(
                 ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY)
                 .executeQuery("SELECT * FROM seance_salles JOIN salle WHERE Id_seance="+id+" and Id_salles=id");
                while(result4.next()){
                    salles.add(result4.getString("nom"));
                    capacite+=result4.getInt("capacite");
                    ResultSet result5 = connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT * FROM site WHERE id="+result4.getInt("Id_site"));
                    result5.first();
                    sites=result5.getString("nom");
                }
                ArrayList<String> groupes =new ArrayList<String>();
                String promo=null;
                result4 = connect.createStatement(
                 ResultSet.TYPE_SCROLL_INSENSITIVE,
                 ResultSet.CONCUR_READ_ONLY)
                 .executeQuery("SELECT * FROM seance_groupes INNER JOIN groupe ON seance_groupes.Id_groupe=groupe.id WHERE Id_seance="+id);
                while(result4.next()){
                    groupes.add(result4.getString("nom"));
                    ResultSet result5 = connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)
                    .executeQuery("SELECT * FROM promotion WHERE id="+result4.getInt("Id_promotion"));
                    result5.first();
                    promo=result5.getString("nom");
                }
                result2.first();
                result3.first();
                seance=new Seance(
                id,
                result.getInt("semaine"),
                date,
                result.getTime("heure_debut"),
                result.getTime("heure_fin"),
                result.getString("etat"),
                enseignants,
                result2.getString("nom"),
                result3.getString("nom"),
                salles,
                sites,
                capacite,
                groupes,
                promo
                );
                System.out.println(id);
                System.out.println(result.getInt("semaine"));
                System.out.println(date);
                System.out.println(result.getTime("heure_debut"));
                System.out.println(result.getTime("heure_fin"));
                System.out.println(result.getString("etat"));
                System.out.println(enseignants);
                System.out.println(result2.getString("nom"));
                System.out.println(result3.getString("nom"));
                System.out.println(salles);
                System.out.println(sites);
                System.out.println(capacite);
                System.out.println(groupes);
                System.out.println(promo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seance;
    }
}
