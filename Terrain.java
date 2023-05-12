package com.example.stationski.Modele;

import java.util.ArrayList;
import java.util.Arrays;

public class Terrain {

    private ArrayList<Integer>listeTerrain;


    public Terrain(){
        this.listeTerrain = new ArrayList<Integer>(Arrays.asList(0,0,1,1,1,1,1,1,1,1     ,1,0,1,1,1,1,1,1,1,1,   1,0,0,0,1,1,1,1,1,1,    1,1,1,0,0,0,1,1,1,1,    1,1,1,1,1,1,0,0,0,0,  1,1,1,1,0,1,1,1,0,1 ,   1,1,1,1,0,0,0,1,0,1,    1,1,1,1,1,0,0,0,0,1   ));
    }


    public ArrayList<Integer> getList(){
        return this.listeTerrain;
    }
}
