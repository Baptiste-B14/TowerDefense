package fr.iut.montreuil.stationski.Modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Grille {
    private int largeur;
    private int hauteur;
    private Sommet source;
    private Sommet cible;
    private Terrain terrain;
    private Map<Sommet, Set<Sommet>> listeAdj;


    public Grille(Terrain terrain, Sommet source, Sommet cible) {
        this.terrain=terrain;
        this.largeur = terrain.getList().size()*16;
        this.hauteur = terrain.getList().size()*16;
        this.source=source;
        this.cible=cible;
        this.listeAdj = new HashMap();
        this.build();
    }

    // Cette méthode crée tous les Set Adj et initialise tous les sommets
    public void build() {
        for (int i = 0; i < this.hauteur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                if (i!= this.source.getX() && j!=this.source.getY())
                    this.listeAdj.put(this.source, new HashSet());
                else if (i!=this.cible.getX() && j!=this.cible.getY())
                    this.listeAdj.put(this.cible, new HashSet());
                else
                    this.listeAdj.put(new Sommet(i, j, false), new HashSet());
            }
        }

        for (int i = 0; i < this.hauteur; ++i) {
            for (int j = 0; j < this.largeur; ++j) {
                Sommet s = this.getSommet(i, j);
                if (this.dansGrille(i - 1, j)) {
                    ((Set) this.listeAdj.get(s)).add(this.getSommet(i - 1, j));
                }

                if (this.dansGrille(i + 1, j)) {
                    ((Set) this.listeAdj.get(s)).add(this.getSommet(i + 1, j));
                }

                if (this.dansGrille(i, j + 1)) {
                    ((Set) this.listeAdj.get(s)).add(this.getSommet(i, j + 1));
                }

                if (this.dansGrille(i, j - 1)) {
                    ((Set) this.listeAdj.get(s)).add(this.getSommet(i, j - 1));
                }
            }
        }
    }

    // Cette méthode recherche un sommet par ses coordonnées parmi la listeAdj
    public Sommet getSommet (int x, int y){
        Iterator ListAdj = this.listeAdj.keySet().iterator();
        Sommet sommet;

        do{
            if (!ListAdj.hasNext()) {
                return null;
            }
            sommet = (Sommet)ListAdj.next();
        }while(sommet.getX() != x || sommet.getY() != y);

        return sommet;
    }

    public boolean dansGrille (int x, int y){return x >= 0 && x < this.largeur && y >= 0 && y < this.hauteur && this.terrain.getList().get((x+y)/16)==0;}



    public Set<Sommet> getVoisins(Sommet s) {
        return (Set)this.listeAdj.get(s);
    }
}
