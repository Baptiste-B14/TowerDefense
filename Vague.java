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
        this.numeroVague=numeroVague;
        this.pourcentChanceSkieur=pourcentChanceSkieur;
        this.pourcentChanceSnowboardeur=pourcentChanceSnowboardeur;
        this.pourcentChanceLuge=pourcentChangeLuge;
        this.pourcentChanceYeti=pourcentChanceYeti;
        this.listEnnemis= new ArrayList<Ennemi>();
    }



}
