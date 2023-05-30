package fr.iut.montreuil.stationski.Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class Ennemi extends Entite {
    private int vitesse;
    private int butin;
    private ArrayList<Sommet> parcours;
    public Ennemi (int pv, int posX, int posY, int vitesse, Environnement env, int butin, ArrayList<Sommet> parcours){
        super(pv, posX, posY, env);
        this.vitesse=vitesse;
        this.butin = butin;
        this.parcours = parcours;


    }




    public void agit(){
        deplacement();

    }

    public void deplacement (){
        //deplacement tres simple
        if (parcours.size()>0) {
            posX.setValue(parcours.get(0).getX());
            posY.setValue(parcours.get(0).getY());
            parcours.remove(0);
            for (int i=0 ; i<vitesse-1 && parcours.size()>vitesse ; i++){
                parcours.remove(0);
            }
        }
        //posX.setValue(posX.getValue()+ (int)(Math.random()*4)-1+ vitesse);
        //posY.setValue(posY.getValue()+ (int)(Math.random()*4)-1+ vitesse);
    }



    public int getButin() {
        return butin;
    }



}