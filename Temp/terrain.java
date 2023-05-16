package com.example.stationski.Modele;

import java.util.ArrayList;
import java.util.Arrays;

public class Terrain {
    private int largeur, hauteur;
    private int[] objectif ;
    private ArrayList<int[]> listeSpawn;

    private ArrayList<Integer>listeTerrain;

    private int nbSpawn;


    public Terrain(int largeur, int hauteur, int nbSpawn){
        this.listeTerrain = new ArrayList<Integer>(Arrays.asList(createTableauTerrain()));
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.objectif = createObj();
        this.nbSpawn = nbSpawn;
        this.listeSpawn = createSpawn(nbSpawn);
    }


    public ArrayList<Integer> getList(){
        return this.listeTerrain;
    }

    public int[] createObj(){

        int posY, posX;
        int cote = (int)(Math.random()*4)+1;
        switch(cote){
            case 1 :
                posY = 0;
                posX = (int)(Math.random()*largeur);
                break;
            case 2 :
                posY = (int)(Math.random()*hauteur);
                posX = hauteur;
                break;

            case 3:
                posY = largeur;
                posX = (int)(Math.random()*largeur);
                break;
            case 4 :

                posY = (int)(Math.random()*hauteur);
                posX = 0;
                break;

            default :
                posY = 0;
                posX = 0;
                break;
        }

        int[]obj = {posX, posY};
        return obj;
    }

    public int getObjX(){
        return this.objectif[0];
    }
    public int getObjY(){
        return this.objectif[1];
    }

    public ArrayList<int[]> createSpawn(int nbSpawn){
        ArrayList<int[]> spawns = new ArrayList<int[]>();
        for(int i =0; i<nbSpawn; i++){
            int posY, posX;
            int cote = (int)(Math.random()*4)+1;
            switch(cote){
                case 1 :
                    posY = 0;
                    posX = (int)(Math.random()*largeur);
                    break;
                case 2 :
                    posY = (int)(Math.random()*hauteur);
                    posX = hauteur;
                    break;

                case 3:
                    posY = largeur;
                    posX = (int)(Math.random()*largeur);
                    break;
                case 4 :

                    posY = (int)(Math.random()*hauteur);
                    posX = 0;
                    break;

                default :
                    posY = 0;
                    posX = 0;
                    break;
            }
            int[] spawn = new int[] { posX, posY};
            spawns.add(spawn);
        }

        return spawns;
    }

    public Integer[] createTableauTerrain(){
            Integer[] tableTerrain = new Integer[largeur*hauteur];
        for(int hauteur = 0; hauteur <this.hauteur; hauteur++){
            for(int largeur = 0; largeur<this.largeur; largeur++){
                tableTerrain[hauteur*largeur+ largeur] = ((int)(Math.random()*4)/4);
            }
        }
        for(int i=0;i<listeSpawn.size(); i++){
            tableTerrain[largeur* listeSpawn.get(i)[1] + listeSpawn.get(i)[0] ] = 3;
        }

        tableTerrain[largeur *getObjY() + getObjX()] = 4;

    return tableTerrain;
    }



}
