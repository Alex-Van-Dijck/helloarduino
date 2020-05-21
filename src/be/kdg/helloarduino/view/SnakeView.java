package be.kdg.helloarduino.view;

import be.kdg.helloarduino.model.Spel;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeView extends GridPane {


    private Spel spel;
    private ImageView hoofd, punt, body;
    private Random rand = new Random();
    private List<Integer> slangListX, slangListY;
    private int slangX = 10;
    private int slangY = 10;
    private int oudSlangX;
    private int oudSlangY;
    private int puntX;
    private int puntY;
    int vorigeX, vorigeY, vorigeX2, vorigeY2;

    public SnakeView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {


        generateFruit();
        slangListX = new ArrayList<Integer>();
        slangListY = new ArrayList<Integer>();
        hoofd = new ImageView("/Images/blu.png");
        punt = new ImageView("/Images/strawberry.png");
        body = new ImageView("/Images/lightBlu.png");
        hoofd.setFitWidth(20);
        hoofd.setFitHeight(20);
        punt.setFitWidth(20);
        punt.setFitHeight(20);
        body.setFitHeight(20);
        body.setFitWidth(20);

        for (int i = 0; i < 20 ; i++) {
            RowConstraints con = new RowConstraints();
            con.setPrefHeight(20);
            this.getRowConstraints().add(con);
        }
        for (int i = 0; i < 20 ; i++) {
            ColumnConstraints con = new ColumnConstraints();
            con.setPrefWidth(20);
            this.getColumnConstraints().add(con);
        }

    }

    private void layoutNodes() {
        this.setBackground(new Background(new BackgroundFill(Color.YELLOWGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
//        this.setGridLinesVisible(true);


    }


    //Getters & Setters


    public int getSlangX() {
        return slangX;
    }

    public int getSlangY() {
        return slangY;
    }

    public int getPuntX() {
        return puntX;
    }

    public int getPuntY() {
        return puntY;
    }

    public ImageView getHoofd() {
        return hoofd;
    }

    public ImageView getPunt() {
        return punt;
    }

    public void setHoofdSlang(int X, int Y){

        oudSlangX = slangX;
        oudSlangY = slangY;

        slangX = X;
        slangY = Y;

        this.add(hoofd,slangX,slangY);

    }

    
    private void generateFruit(){

    }
    private void draw(){
        this.getChildren().clear();
        this.add(hoofd,slangX,slangY);

        for (int i = 0 ; i < slangListX.size(); i++){

            this.add(body, slangListX.get(i), slangListY.get(i));

        }

        this.add(punt,puntX,puntY);
        System.out.println("X: " + slangX + " Y: " + slangY);
        System.out.println("ListX: " + slangListX);
        System.out.println("ListY: " + slangListY);
    }
    private void addTail() {

        slangListX.add(puntX);
        slangListY.add(puntY);

    }
    private void setOud(){

        oudSlangY = slangY;
        oudSlangX = slangX;

    }
}
