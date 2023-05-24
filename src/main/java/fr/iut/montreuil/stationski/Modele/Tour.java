package fr.iut.montreuil.stationski.Modele;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Tour extends Entite {

    private int ptsAttaque;
    private int range;
    private Ennemi ennemiCible;
    private int prix;

    public Tour (int pv, int posX, int posY, int ptsAttaque, int range, Environnement env){
        super(pv, posX, posY, env);
        this.ptsAttaque=ptsAttaque;
        this.range=range;
        this.prix = 500;

    }


    public void attaquer(){
        if(ennemiCible != null  ){
            this.ennemiCible.prendDegats(ptsAttaque);
        }
        ObservableList<Ennemi> listeEn = this.env.getVague().getListEnnemis();
        for(int i =0; i<listeEn.size(); i++){
            if(isInRange(listeEn.get(i))){
                this.ennemiCible = listeEn.get(i);
                this.ennemiCible.prendDegats(ptsAttaque);
            }
        }
    }


    public boolean isInRange(Ennemi ennemi){
        return (Math.abs(ennemi.getPosY()-this.getPosY())<range && Math.abs(ennemi.getPosX()-this.getPosX())<range);

    }


    @Override
    public void agit() {

    }
}