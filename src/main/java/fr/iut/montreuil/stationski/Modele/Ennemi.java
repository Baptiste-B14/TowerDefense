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
        System.out.println("se deplace");
        this.prendDegats(1);
        System.out.println("souffre");
    }

    public void deplacement () {
        //deplacement tres simple
        posX.setValue(posX.getValue() + (int) (Math.random() * 4) - 1 + vitesse);
        posY.setValue(posY.getValue() + (int) (Math.random() * 4) - 1 + vitesse);


        if (this.parcours.size() > 0) {
            this.posX.setValue(((Sommet) this.parcours.get(0)).getX());
            this.posY.setValue(((Sommet) this.parcours.get(0)).getY());
            this.parcours.remove(0);

            for (int i = 0; i < this.vitesse - 1 && this.parcours.size() > this.vitesse; ++i) {
                this.parcours.remove(0);
            }
        }
        //posX.setValue(posX.getValue()+ (int)(Math.random()*4)-1+ vitesse);
        //posY.setValue(posY.getValue()+ (int)(Math.random()*4)-1+ vitesse);


    }



    public int getButin() {
        return butin;
    }



}