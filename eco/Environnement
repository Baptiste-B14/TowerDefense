package com.example.stationski.Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Environnement {
    private Terrain terrain;

    private IntegerProperty argent;
    private ArrayList<Integer> listeEnv;
    private Capacite capa;
    private ArrayList<Tour> listeTours;
    private Vague vague;
    private ArrayList<Ennemi> listEnnemis;

    public Environnement(Terrain terrain){
        this.terrain = terrain;
        this.listEnnemis = new ArrayList<Ennemi>();
        this.argent = new SimpleIntegerProperty(500);

    }
    public void ajouterEnnemi(Ennemi ennemi){
        this.listEnnemis.add(ennemi);
    }

    public Terrain getTerrain(){return this.terrain;}

    public Vague getVague(){
        return this.vague;
    }


    public void unTour(){
        for (int acteur = this.listEnnemis.size()-1; acteur>=0; acteur--){
            this.listEnnemis.get(acteur).agit();
            if (!this.listEnnemis.get(acteur).estVivant()){
                this.ajoutArgent(this.listEnnemis.get(acteur).getButin());
                this.listEnnemis.remove(acteur);
            }
        }




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
