package be.kdg.helloarduino.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.css.Rect;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Alex Van Dijck on 16/05/2020
 * @project helloarduino
 */
public class Spel {

    private GridCell fruit;
    Snake snake;

    private int richting, score;
    //Int richting 0 = boven; 1 = rechts; 2 = onder; 3 = links;
    private boolean klaar;
    private Random rand;

    public Spel() {

        this.richting = 0;
        this.klaar = false;
        this.rand = new Random();
        this.score = 0;
        this.snake = new Snake();

    }

    public void overInput(byte oneByte){
        if(!isKlaar()) {
            if ((char) oneByte == 'T') {

                System.out.println(richting);
                switch(richting){
                    case 0:
                        snake.beweegVooruit();
                        break;
                    case 1:
                        snake.beweegLinks();
                        break;
                    case 2:
                        snake.beweegOnder();
                        break;
                    case 3:
                        snake.beweegRechts();
                        break;
                }

            }else{

                input((char)oneByte);

            }
        }
    }

    public void input (char c){

        switch(c){
            case 'L':
                links();
                break;
            case 'R':
                rechts();
                break;
            case 'F':
                klaar = true;
                break;
        }

    }


    private void rechts(){

        switch(richting){
            case 0:
                richting = 3;
                break;
            default:
                richting = richting - 1;
        }

    }

    private void links(){

        switch (richting){
            case 3:
                richting = 0;
                break;
            default:
                richting = richting + 1;
        }

    }

    public int getRichting() {
        return richting;
    }

    public boolean isKlaar() {
        return klaar;
    }

    public void setKlaar(boolean klaar) {
        this.klaar = klaar;
    }

    public GridCell getFruit() {
        return fruit;
    }

    public void setFruit(GridCell fruit) {
        this.fruit = fruit;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }
}


