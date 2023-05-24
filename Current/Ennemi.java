package fr.iut.montreuil.stationski.Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ennemi extends Entite {

    public static int compteur=0;
    private String id;
    private int pV;
    private IntegerProperty posX;
    private IntegerProperty posY;
    private int vitesse;
    private Environnement env;
    private int butin;

    public Ennemi (int pv, int posX, int posY, int vitesse, Environnement env, int butin){
        super(pv, posX, posY, env);
        this.vitesse=vitesse;
        this.butin = butin;

    }




    public void agit(){
        deplacement();
    }

    public void deplacement (){
        //deplacement tres simple
        posX.setValue(posX.getValue()+ (int)(Math.random()*3-1));
        posY.setValue(posY.getValue()+ (int)(Math.random()*3-1));
    }



    public int getButin() {
        return butin;
    }



}