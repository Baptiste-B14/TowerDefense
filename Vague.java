package com.example.stationski.Modele;



import java.util.ArrayList;

public class Vague {

    private int numeroVague;
    private double pourcentChanceSkieur;
    private double pourcentChanceSnowboardeur;
    private double pourcentChanceLuge;
    private double pourcentChanceBobsleigh;
    private double pourcentChanceYeti;
    private ArrayList<Ennemi> listEnnemis;
    public Vague (int numeroVague, double pourcentChanceSkieur, double pourcentChanceSnowboardeur, double pourcentChangeLuge, double pourcentChanceYeti){
        this.numeroVague=numeroVague; // this.numeroVague = 0;
        this.pourcentChanceSkieur=pourcentChanceSkieur;
        this.pourcentChanceSnowboardeur=pourcentChanceSnowboardeur;
        this.pourcentChanceLuge=pourcentChangeLuge;
        this.pourcentChanceYeti=pourcentChanceYeti;
        this.listEnnemis= new ArrayList<Ennemi>();


    }

    public ArrayList<Ennemi> getListEnnemis(){
        return this.listEnnemis;
    }



    public void prochaineVague(){
        // Initialisation de tous les paramètres de génération des Ennemis :
        if (numeroVague<=3)
            this.pourcentChanceSkieur = -(double)(0.6/3)*numeroVague + 0.8;
        else
            this.pourcentChanceSkieur = -0.25*numeroVague + 0.2;

        if (numeroVague<=3)
            this.pourcentChanceSnowboardeur = -(double)(1/6)*numeroVague + 0.25 ;
        else
            this.pourcentChanceSnowboardeur = -0.2*numeroVague + 0.75;

        if (numeroVague<=2)
            this.pourcentChanceLuge = 0;
        else if (numeroVague<5)
            this.pourcentChanceLuge = -(double)(0.65/3)*numeroVague;
        else
            this.pourcentChanceLuge = -0.1*numeroVague + 0.65;

        // Génération des ennemis jusqu'à avoir 10 ennemis :
        while (this.listEnnemis.size()<10){
            if ((Math.random() * 1)<this.pourcentChanceSkieur)
                this.listEnnemis.add(new Ennemi(10, 1, 1, 2)); // new Skieur

            if ((Math.random() * 1)<this.pourcentChanceSnowboardeur)
                this.listEnnemis.add(new Ennemi(10, 1, 1, 2)); // new Snowboardeur

            if ((Math.random() * 1)<this.pourcentChanceLuge)
                this.listEnnemis.add(new Ennemi(10, 1, 1, 2)); // new Luge


        }
    }

}
