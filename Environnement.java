package com.example.stationski.Modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Environnement {

    private int argent;
    private ArrayList<Integer> listeEnv;
    private Capacite capa;
    private ArrayList<Tour> listeTours;
    private Vague vague;


    public Environnement(){

       this.listeEnv = new ArrayList<Integer>(Arrays.asList(0,0,1,1,1,1,1,1,1,1     ,1,0,1,1,1,1,1,1,1,1,   1,0,0,0,1,1,1,1,1,1,    1,1,1,0,0,0,1,1,1,1,    1,1,1,1,1,1,0,0,0,0,  1,1,1,1,0,1,1,1,0,1 ,   1,1,1,1,0,0,0,1,0,1,    1,1,1,1,1,0,0,0,0,1   ));

    }


    public ArrayList<Integer> getList(){
        return this.listeEnv;
    }

}
