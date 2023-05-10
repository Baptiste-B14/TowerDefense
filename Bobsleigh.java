public class Bobsleigh extends Ennemi{

    private int ptsAttaque;
    public Bobsleigh(int pV,  int posX, int posY, int vitesse,int ptsAttaque){
        super(10,posX, posY ,vitesse);
        this.ptsAttaque=ptsAttaque;
    }
}
