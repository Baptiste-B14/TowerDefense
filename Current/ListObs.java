package fr.iut.montreuil.stationski.Controleur;

import fr.iut.montreuil.stationski.Main;
import fr.iut.montreuil.stationski.Modele.Entite;
import fr.iut.montreuil.stationski.Modele.Environnement;
import javafx.collections.ListChangeListener;
import fr.iut.montreuil.stationski.Modele.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;

public class ListObs implements ListChangeListener<Entite> {
    private Pane panneauJeu;
    private Environnement env;

    public ListObs(Pane panneauJeu, Environnement env){
        this.env = env;
        this.panneauJeu = panneauJeu;
    }

    @Override
    public void onChanged(Change<? extends Entite> c){
        while(c.next()){
            for(Entite e : c.getAddedSubList()){
                creerSprite(e);
            }
        }
    }

    public void creerSprite(Entite e){
        if(e instanceof Ennemi){
            URL urlIm= Main.class.getResource("ennemi.png");
            Image im= new Image(String.valueOf(urlIm));
            ImageView imageSnow = new ImageView();
            imageSnow.setImage(im);

            root.getChildren().add(imageSnow);
            Circle cercle = new Circle();
            cercle.setRadius(5);
            cercle.setFill(Color.RED);
            cercle.translateXProperty().bind(ennemi.getPosXP());
            cercle.translateYProperty().bind(ennemi.getPosYP());
            panneauDeJeu.getChildren().add(cercle);


        }else {

        }
    }
}
