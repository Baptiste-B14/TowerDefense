package com.example.stationski.Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ennemi{


    private int pV;
    private IntegerProperty posX;
    private IntegerProperty posY;
    private int vitesse;
    private Environnement env;
    public Ennemi (int pV, int posX, int posY, int vitesse, Environnement env){
        this.pV= pV;

        this.posX = new SimpleIntegerProperty(posX);
        this.posY = new SimpleIntegerProperty(posY);
        this.vitesse=vitesse;
        this.env = env;

    }

    public IntegerProperty getPosXP(){
        return posX;
    }
    public IntegerProperty getPosYP(){
        return posY;
    }

    public int getPosX() {
        return posX.getValue();
    }
    public int getPosY() {
        return posY.getValue();
    }

    public void agit(){
        deplacement();
    }

    public void deplacement (){
        //deplacement tres simple
        posX.setValue(posX.getValue()+ (int)(Math.random()*3-1));
        posY.setValue(posY.getValue()+ (int)(Math.random()*3-1));
    }

}
