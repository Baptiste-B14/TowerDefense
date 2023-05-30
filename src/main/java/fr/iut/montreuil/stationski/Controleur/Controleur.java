package fr.iut.montreuil.stationski.Controleur;

import fr.iut.montreuil.stationski.Main;

import fr.iut.montreuil.stationski.Modele.*;
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

    @FXML
    private Label PV;


    private Environnement env;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListChangeListener<Entite> listen = new ListObs(panneauDeJeu, env);


        Terrain terrain = new Terrain(16,16,2);
        this.env = new Environnement(terrain);
        Ennemi ennemi = new Ennemi(10, 20, 20, 1, env, 1);
        monnaie.textProperty().bind(env.getArgentP().asString());
        PV.textProperty().bind((env.getPVP().asString()));
        this.env.getVague().getListEnnemis().addListener(listen);
        this.env.getListeTours().addListener(listen);


        //this.env.getListeTours().addListener(listen);


        // ici code pour l'aspect des cases
        root.setStyle("-fx-background-color:blue");
        //root.getChildren().add(imageSnow);
// 1 neige, 0 chemin ,  3 spawn , 4 objectif, 5 tour
        for (int row = 0; row<this.env.getTerrain().getList().size(); row++){
            if(this.env.getTerrain().getList().get(row) == 1 || this.env.getTerrain().getList().get(row) == 3 || this.env.getTerrain().getList().get(row) == 5){
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
        //this.setTile();

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
    int creationTourTest(ActionEvent event) {
        int x=0;
        int y=0;
        Tour t;
        for (int row = 0; row<this.env.getTerrain().getList().size(); row++){

            if (this.env.getTerrain().getList().get(row) == 1){
                t = new Tour(3,x,y,2,2,env);
                env.getTerrain().getList().set(row, 5);
                env.addTour(t);
                return 0;
            }
            if (row%32 ==0 && row!=0){
                y++;
            }

            x++;
            if (x>32){
                x=0;
            }
        }


        return 1;
    }

}