package com.example.stationski.Controleur;

import com.example.stationski.Main;
import com.example.stationski.Modele.Ennemi;
import com.example.stationski.Modele.Environnement;
import com.example.stationski.Modele.Terrain;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;


import java.net.URL;

import com.example.stationski.Modele.Environnement;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    @FXML
    private TilePane root;

    @FXML
    private Pane panneauDeJeu;

    private Timeline gameLoop;

    private Environnement env;
    
        @FXML
    private Label monnaie;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Terrain terrain = new Terrain();
        this.env = new Environnement(terrain);
        Ennemi ennemi = new Ennemi(10, 20, 20, 1, this.env);
        this.env.ajouterEnnemi(ennemi);
         monnaie.textProperty().bind(env.getArgentP().asString());
        
        
         ListChangeListener<Entite> listen = new ListObs(panneauDeJeu, env);
        this.env.getListeTours().addListener(listen);
        this.env.getVague().getListEnnemis().addListener(listen);

        Circle cercle = new Circle();
        cercle.setRadius(5);
        cercle.setFill(Color.RED);
        cercle.translateXProperty().bind(ennemi.getPosXP());
        cercle.translateYProperty().bind(ennemi.getPosYP());
        panneauDeJeu.getChildren().add(cercle);

        root.setStyle("-fx-background-color:blue");
        //root.getChildren().add(imageSnow);

        for (int row = 0; row<this.env.getTerrain().getList().size(); row++){
            if(this.env.getTerrain().getList().get(row) == 1){
                URL urlIm= Main.class.getResource("snow2.png");
                Image im= new Image(String.valueOf(urlIm));
                ImageView imageSnow = new ImageView();
                imageSnow.setImage(im);

                root.getChildren().add(imageSnow);

            }else if(this.env.getTerrain().getList().get(row) == 0){
                URL urlIm= Main.class.getResource("snow01.png");
                Image im= new Image(String.valueOf(urlIm));
                ImageView imageSnow = new ImageView();
                imageSnow.setImage(im);

                root.getChildren().add(imageSnow);
            }

        }

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
