package com.example.stationski.Modele;

import java.util.ArrayList;

public class Tour {
    private int pV;
    private int ptsAttaque;
    private int range;
    private int posX;
    private int posY;
    private Environnement env;
    private Ennemi ennemiCible;
    private int prix;

    public Tour (int posX, int posY, int pV, int ptsAttaque, int range, Environnement env){
        this.posX=posX;
        this.posY=posY;
        this.pV=pV;
        this.ptsAttaque=ptsAttaque;
        this.range=range;
        this.env = env;
        this.prix = 500;
    }

    public boolean ennemiVivant(Ennemi ennemi){
        return ennemi.getPV() ==0;
    }

    public void attaquer(){
        if(ennemiCible != null  ){
            this.ennemiCible.prendDegats(ptsAttaque);
        }
        ArrayList<Ennemi> listeEn = this.env.getVague().getListEnnemis();
        for(int i =0; i<listeEn.size(); i++){
            if(isInRange(listeEn.get(i))){
                this.ennemiCible = listeEn.get(i);
                this.ennemiCible.prendDegats(ptsAttaque);
            }
        }
    }


    public boolean isInRange(Ennemi ennemi){
        //if(ennemi.getPosY())
        return true;
    }



}