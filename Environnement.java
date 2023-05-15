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

    public Environnement(){
        this.terrain = new Terrain();

    }


    public Terrain getTerrain(){return this.terrain;}



    public void unTour(){

    }

}
