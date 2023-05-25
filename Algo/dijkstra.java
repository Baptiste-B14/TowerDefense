package fr.iut.montreuil.stationski.Modele;



import java.util.*;

public class Dijkstra {


    private Sommet cible;
    private Sommet source;
    private Grille grille;
    private ArrayList <Sommet> parcours ;
    private Map<Sommet, Sommet> predecesseurs;


    // TO DO : coder classe Sommet
    //         coder classe tableau2D
    //         coder methode voisins dans tableau2D

    public Dijkstra (Terrain terrain, Sommet source, Sommet cible){
        this.cible = cible;
        this.source = source;
        this.grille = new Grille(terrain, this.source, this.cible);
        predecesseurs = new HashMap<>();
        parcours= new ArrayList<Sommet>();
        algo();
    }

    public void algo (){
        PriorityQueue<Sommet> listeàAnalyser = new PriorityQueue<Sommet>();
        listeàAnalyser.add(this.source);
        this.source.setReached(true);
        Sommet courant;
        while (!cible.isReached() && !listeàAnalyser.isEmpty()) {

            courant = listeàAnalyser.poll();
            Iterator ListAdj = grille.getVoisins(courant).iterator();
            Sommet sommet;
            do {
                sommet = (Sommet)ListAdj.next();
                if(!sommet.isReached()){
                    listeàAnalyser.add(sommet);
                    predecesseurs.put(sommet, courant);
                    sommet.setReached(true);
                }
            } while(!ListAdj.hasNext() && !cible.isReached());
        }
        if (cible.isReached()){
            courant = this.cible;
            while (!courant.equals(this.source)){
                parcours.add(courant);
                courant = predecesseurs.get(courant);
            }
        }
    }

    private void clear() {
        this.predecesseurs.clear();
        this.parcours.clear();
    }




    /*************************************************
     **** Pas de modifications à faire ci-dessous ****
     *************************************************/

    public ArrayList<Sommet> getParcours() {
        return parcours;
    }

    public Map<Sommet, Sommet> getPredecesseurs() {
        return predecesseurs;
    }

    public Sommet getSource() {
        return source;
    }

    public void setSource(Sommet source) {
        this.source = source;
        clear();
        algo();
    }


}
