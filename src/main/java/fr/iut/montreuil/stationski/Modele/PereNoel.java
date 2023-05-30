package fr.iut.montreuil.stationski.Modele;

import java.util.ArrayList;

public class PereNoel extends Ennemi{
    public PereNoel(int pv, int posX, int posY, int vitesse, Environnement env, int butin, ArrayList<Sommet> parcours) {
        super(pv, posX, posY, vitesse, env, butin, parcours);
    }
}
