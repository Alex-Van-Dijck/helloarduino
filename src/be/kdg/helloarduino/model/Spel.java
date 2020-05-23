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
    SerialArduinoConnection serial;

    private int richting;
    //Int richting 0 = boven; 1 = rechts; 2 = onder; 3 = links;
    private boolean klaar, score, getoond;
    private Random rand;

    public Spel() {

        this.richting = 0;
        this.klaar = false;
        this.rand = new Random();
        this.score = false;
        this.getoond = false;
        this.snake = new Snake();
        this.fruit = new GridCell(rand.nextInt(20),rand.nextInt(20));

    }

    public void overInput(byte oneByte){

        isGameOver();

            if ((char) oneByte == 'T') {

                System.out.println(richting);
                switch(richting){
                    case 0:
                        if(!snake.beweegVooruit(fruit)){
                            generateFruit();
                        }
                        break;
                    case 1:
                        if(!snake.beweegLinks(fruit)){
                            generateFruit();
                        }
                        break;
                    case 2:
                        if(!snake.beweegOnder(fruit)){
                            generateFruit();
                        }
                        break;
                    case 3:
                        if(!snake.beweegRechts(fruit)){
                            generateFruit();
                        }
                        break;
                }

            }else{

                input((char)oneByte);

            }
    }

    public void isGameOver(){

        for (int i = 1; i < snake.getSnakeBodies().size() - 1; i++) {
            if (snake.getHoofd().getBodyX() == snake.getSnakeBodies().get(i).getBodyX() && snake.getHoofd().getBodyY() == snake.getSnakeBodies().get(i).getBodyY()  ) {
                klaar = true;
                System.out.println("Het spel is afgelopen, je bent tegen jezelf gebotst");
            }
        }
        if(snake.getHoofd().getBodyX() == 20 || snake.getHoofd().getBodyX() < 0 || snake.getHoofd().getBodyY() == 20|| snake.getHoofd().getBodyY() < 0 ){
            klaar = true;
            System.out.println("Het spel is afgelopen, je bent buiten het veld gegaan");
        }

    }

    private void input(char c){

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

    private void generateFruit(){

        score = true;
        boolean fruitTest = false;

        while(!fruitTest) {
            fruit = new GridCell(rand.nextInt(20), rand.nextInt(20));
            for (int i = 0; i < snake.getSnakeBodies().size() - 1; i++) {
                if (fruit.getBodyX() == snake.getSnakeBodies().get(i).getBodyX() && fruit.getBodyY() == snake.getSnakeBodies().get(i).getBodyY()  ) {
                    fruitTest = false;
                    System.out.println("Rerolling fruit");
                }else{
                    fruitTest = true;
                }
            }

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

    public boolean isScore() {
        return score;
    }

    public boolean isGetoond() {
        return getoond;
    }

    public void setScore(boolean score) {
        this.score = score;
    }

    public int getRichting() {
        return richting;
    }

    public boolean isKlaar() {
        return klaar;
    }

    public void setGetoond(boolean getoond) {
        this.getoond = getoond;
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


