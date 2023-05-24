package fr.iut.montreuil.stationski.Modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Environnement {
    private Terrain terrain;

    private int argent;
    private ArrayList<Integer> listeEnv;
    private Capacite capa;
    private ObservableList<Tour> listeTours;
    private Vague vague;
    private ArrayList<Ennemi> listEnnemis;

    public Environnement(Terrain terrain){
        this.terrain = terrain;
        this.listEnnemis = new ArrayList<Ennemi>();
        this.listeTours = FXCollections.observableArrayList();

    }
    public void ajouterEnnemi(Ennemi ennemi){
        this.listEnnemis.add(ennemi);
    }

    public Terrain getTerrain(){return this.terrain;}

    public Vague getVague(){
        return this.vague;
    }


    public void unTour(){
        for (int acteur = 0; acteur<this.listEnnemis.size(); acteur++){
            this.listEnnemis.get(acteur).agit();
        }
    }


    public void addTour(Tour t){
        this.listeTours.add(t);
    }

    public ObservableList<Tour> getListeTours(){
        return this.listeTours;
    }

    public Tour getTour(String id){
        for(Tour t : this.listeTours){
            if(t.getId().equals(id)){
                return t;
            }
        }
        return null;
    }

}
