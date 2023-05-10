public class Yeti extends Ennemi{

    private int ptsAttaque;
    public Yeti(int pV, int vitesse, int posX, int posY, int ptsAttaque){
        super(10, posX, posY, 2);
        this.ptsAttaque=ptsAttaque;
    }
}
