package fr.iut.montreuil.stationski.Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ennemi{

    public static int compteur=0;
    private String id;
    private int pV;
    private IntegerProperty posX;
    private IntegerProperty posY;
    private int vitesse;
    private Environnement env;
    private int butin;

    public Ennemi (int pV, int posX, int posY, int vitesse, Environnement env, int butin){
        this.pV= pV;

        this.posX = new SimpleIntegerProperty(posX);
        this.posY = new SimpleIntegerProperty(posY);
        this.vitesse=vitesse;
        this.env = env;
        this.butin = butin;
        this.id = "E"+compteur;
        compteur++;
    }

    public IntegerProperty getPosXP(){
        return posX;
    }
    public IntegerProperty getPosYP(){
        return posY;
    }

    public String getId (){
        return id;
    }
    public int getPosX() {
        return posX.getValue();
    }
    public int getPosY() {
        return posY.getValue();
    }
    public int getPV(){return this.pV;}

    public void agit(){
        deplacement();

        // pour les test
        this.prendDegats(1);
        //
    }

    public void deplacement (){
        //deplacement tres simple
        posX.setValue(posX.getValue()+ (int)(Math.random()*3-1));
        posY.setValue(posY.getValue()+ (int)(Math.random()*3-1));
    }


    public void prendDegats(int degat){
        this.pV-= degat;
    }

    public int getButin() {
        return butin;
    }

    public boolean estVivant (){
        return pV>0;
    }


}
