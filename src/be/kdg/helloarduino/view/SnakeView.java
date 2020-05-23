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

    public SnakeView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {


        slangListX = new ArrayList<Integer>();
        slangListY = new ArrayList<Integer>();
        punt = new ImageView("/Images/strawberry.png");
        body = new ImageView("/Images/lightBlu.png");
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

    public ImageView getHoofd() {

        hoofd = new ImageView("/Images/blu.png");
        hoofd.setFitWidth(20);
        hoofd.setFitHeight(20);
        return  hoofd;
    }

    public ImageView getPunt() {
        return punt;
    }





}
