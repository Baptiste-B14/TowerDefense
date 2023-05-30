package fr.iut.montreuil.stationski.Modele;

import java.util.ArrayList;

public class Bobsleigh extends Ennemi{
    public Bobsleigh(int pv, int posX, int posY, int vitesse, Environnement env, int butin, ArrayList<Sommet> parcours) {
        super(pv, posX, posY, vitesse, env, butin, parcours);
    }
}

