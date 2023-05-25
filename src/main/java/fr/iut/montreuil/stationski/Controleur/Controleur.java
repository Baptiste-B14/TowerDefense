package fr.iut.montreuil.stationski.Controleur;

import fr.iut.montreuil.stationski.Main;

import fr.iut.montreuil.stationski.Modele.Ennemi;
import fr.iut.montreuil.stationski.Modele.Entite;
import fr.iut.montreuil.stationski.Modele.Terrain;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;


import java.net.URL;

import fr.iut.montreuil.stationski.Modele.Environnement;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ResourceBundle;

public class Controleur implements Initializable {
    @FXML
    private TilePane root;

    @FXML
    private Pane panneauDeJeu;

    private Timeline gameLoop;


    @FXML
    private Label monnaie;

    private Environnement env;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListChangeListener<Entite> listen = new ListObs(panneauDeJeu, env);


        Terrain terrain = new Terrain(480/16,480/16,2);
        this.env = new Environnement(terrain);
        Ennemi ennemi = new Ennemi(10, 20, 20, 1, env, 1);
        monnaie.textProperty().bind(env.getArgentP().asString());
        this.env.getVague().getListEnnemis().addListener(listen);


        //this.env.getListeTours().addListener(listen);



        root.setStyle("-fx-background-color:blue");
        //root.getChildren().add(imageSnow);
// 1 neige, 0 chemin ,  3 spawn , 4 objectif
        for (int row = 0; row<this.env.getTerrain().getList().size(); row++){
            if(this.env.getTerrain().getList().get(row) == 1 || this.env.getTerrain().getList().get(row) == 3){
                URL urlIm= Main.class.getResource("snow2.png");
                Image im= new Image(String.valueOf(urlIm));
                ImageView imageSnow = new ImageView();
                imageSnow.setImage(im);

                root.getChildren().add(imageSnow);

            }else if(this.env.getTerrain().getList().get(row) == 0 || this.env.getTerrain().getList().get(row) == 4){
                URL urlIm= Main.class.getResource("snow01.png");
                Image im= new Image(String.valueOf(urlIm));
                ImageView imageSnow = new ImageView();
                imageSnow.setImage(im);

                root.getChildren().add(imageSnow);
            }

        }
        this.setTile();

        initAnimation();
        gameLoop.play();


    }


    public void setTile(){

        URL urlIm=Main.class.getResource("Chalet.png");
        Image flag= new Image(String.valueOf(urlIm));
        ImageView imageFlag = new ImageView();
        imageFlag.setImage(flag);

        imageFlag.setX(this.env.getTerrain().getObjX());
        imageFlag.setY(this.env.getTerrain().getObjY());

        panneauDeJeu.getChildren().add(imageFlag);

    }







    private void initAnimation(){
        gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),
                (ev ->{
                    env.unTour();
                })
        );

        gameLoop.getKeyFrames().add(kf);
    }


    @FXML
    void SelectionTourCanonEau(ActionEvent event) {

    }
}