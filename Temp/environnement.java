package com.example.stationski.Modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Environnement {
    private Terrain terrain;

    private int argent;
    private ArrayList<Integer> listeEnv;
    private Capacite capa;
    private ArrayList<Tour> listeTours;
    private Vague vague;
    private ArrayList<Ennemi> listEnnemis;

    public Environnement(Terrain terrain){
        this.terrain = terrain;
        this.listEnnemis = new ArrayList<Ennemi>();

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

}
