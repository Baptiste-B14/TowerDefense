package fr.iut.montreuil.stationski.Modele;


import java.util.ArrayList;
import java.util.Arrays;

public class Terrain {
    private int largeurCase, hauteurCase;
    private Sommet source, cible;
    private int[] objectif ;
    private ArrayList<int[]> listeSpawn;

    private ArrayList<Integer>listeTerrain;

    private int nbSpawn;


    public Terrain(int largeur, int hauteur, int nbSpawn, Sommet source, Sommet cible){

        this.largeurCase = largeur;
        this.hauteurCase = hauteur;
        this.source = source;
        this.cible = cible;
        //this.objectif = createObj();
        this.nbSpawn = nbSpawn;
        //this.listeSpawn = createSpawn(nbSpawn);



        this.listeTerrain = new ArrayList<Integer>(Arrays.asList(
                1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                0,0,0,1,1,1,1,1,1,1,1,0,0,0,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                0,0,0,1,1,1,1,1,1,1,1,0,0,0,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                0,0,0,0,1,1,1,1,1,1,1,0,0,0,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,0,0,0,1,1,1,1,1,1,1,0,0,0,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,0,0,0,0,0,0,1,1,0,0,0,0,0,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,

                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
                ));
        //this.listeTerrain = new ArrayList<Integer>(Arrays.asList(createTableauTerrain()));
    }


    public ArrayList<Integer> getList(){
        return this.listeTerrain;
    }

    public int getLargeurCase(){return this.largeurCase;}

    public int getHauteurCase(){return this.hauteurCase;}

    public Sommet getSource(){
        return this.source;
    }

    public Sommet getCible() {
        return cible;
    }

    public int[] createObj(){

        int posY, posX;
        int cote = (int)(Math.random()*4)+1;
        switch(cote){
            case 1 :
                posY = 0;
                posX = (int)(Math.random()*largeurCase*16);
                break;
            case 2 :
                posY = (int)(Math.random()* hauteurCase*16);
                posX = hauteurCase*16;
                break;

            case 3:
                posY = hauteurCase*16;
                posX = (int)(Math.random()*largeurCase*16);
                break;
            case 4 :

                posY = (int)(Math.random()* hauteurCase*16);
                posX = 0;
                break;

            default :
                posY = 0;
                posX = 0;
                break;
        }

        int[]obj = {posX, posY};
        return obj;
    }

    public int getObjX(){
        return this.objectif[0];
    }
    public int getObjY(){
        return this.objectif[1];
    }


/*
    public ArrayList<int[]> createSpawn(int nbSpawn){
        ArrayList<int[]> spawns = new ArrayList<int[]>();
        for(int i =0; i<nbSpawn; i++){
            int posY, posX;
            int cote = (int)(Math.random()*4)+1;
            switch(cote){
                case 1 :
                    posY = 0;
                    posX = (int)(Math.random()*largeurCase);
                    break;
                case 2 :
                    posY = (int)(Math.random()* hauteurCase);
                    posX = hauteurCase;
                    break;

                case 3:
                    posY = largeurCase;
                    posX = (int)(Math.random()*largeurCase);
                    break;
                case 4 :

                    posY = (int)(Math.random()* hauteurCase);
                    posX = 0;
                    break;

                default :
                    posY = 0;
                    posX = 0;
                    break;
            }
            int[] spawn = new int[] { posX, posY};
            spawns.add(spawn);
        }

        return spawns;
    }
*/

    public void genererEmplacementTour(){

    }

/*
    public Integer[] createTableauTerrain(){
        Integer[] tableTerrain = new Integer[largeurCase* hauteurCase];
        for(int indice = 0; indice<this.hauteurCase*this.largeurCase; indice++){

                tableTerrain[indice] = ((int)(Math.random()*4)/3);

        }


        for(int i=0;i<this.listeSpawn.size(); i++){
            tableTerrain[listeSpawn.get(i)[1]*16 + listeSpawn.get(i)[0] ] = 3;
        }

        tableTerrain[getObjY() + getObjX()] = 4;

        return tableTerrain;
    }
*/


}