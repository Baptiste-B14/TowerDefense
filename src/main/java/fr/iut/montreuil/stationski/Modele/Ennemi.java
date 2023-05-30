package fr.iut.montreuil.stationski.Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ennemi extends Entite {
    private int vitesse;
    private int butin;

    public Ennemi (int pv, int posX, int posY, int vitesse, Environnement env, int butin){
        super(pv, posX, posY, env);
        this.vitesse=vitesse;
        this.butin = butin;

    }




    public void agit(){
        deplacement();
        System.out.println("se deplace");
        this.prendDegats(1);
        System.out.println("souffre");
    }

    public void deplacement (){
        //deplacement tres simple
        posX.setValue(posX.getValue()+ (int)(Math.random()*4)-1+ vitesse);
        posY.setValue(posY.getValue()+ (int)(Math.random()*4)-1+ vitesse);
    }



    public int getButin() {
        return butin;
    }



}