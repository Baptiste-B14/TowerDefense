package fr.iut.montreuil.stationski.Modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


import java.util.ArrayList;

public class Environnement {
    private Terrain terrain;

    private IntegerProperty argent;
    private ArrayList<Integer> listeEnv;
    private Capacite capa;
    private ObservableList<Tour> listeTours;
    private Vague vague;

    public Environnement(Terrain terrain){
        this.terrain = terrain;
        this.vague = new Vague(1, 100,6,9,0,this);
        this.listeTours = FXCollections.observableArrayList();
        this.argent = new SimpleIntegerProperty(500);


    }


    public Terrain getTerrain(){return this.terrain;}

    public Vague getVague(){
        return this.vague;
    }


    public void unTour(){


        for (int acteur = this.vague.getListEnnemis().size()-1; acteur>=0; acteur--){
            this.vague.getListEnnemis().get(acteur).agit();

            if (!this.vague.getListEnnemis().get(acteur).estVivant()){
                this.ajoutArgent(this.vague.getListEnnemis().get(acteur).getButin());
                this.vague.getListEnnemis().remove(acteur);
            }
        }

        this.vague.prochaineVague();


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



    public int getArgent() {
        return argent.getValue();
    }

    public IntegerProperty getArgentP () {
        return argent;
    }

    public void ajoutArgent(int somme) {
        this.argent.setValue(this.argent.getValue()+ somme);
    }

    public void retraitArgent (int somme){
        this.argent.setValue(this.argent.getValue()- somme);
    }

}
