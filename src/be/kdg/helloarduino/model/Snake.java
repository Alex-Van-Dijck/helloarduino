package be.kdg.helloarduino.model;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Alex Van Dijck on 21/05/2020
 * @project helloarduino - kopie
 */
public class Snake {

   private List<GridCell> snakeBodies;
   Spel spel;

    public Snake() {
        this.snakeBodies = new LinkedList<>();
        GridCell hoofd = new GridCell(10,10);
        snakeBodies.add(hoofd);
//        addTestSnake();
    }

    public GridCell getHoofd(){

        return snakeBodies.get(0);

    }

    public List<GridCell> getSnakeBodies() {
        return snakeBodies;
    }

    public boolean beweegVooruit(GridCell fruit){

        GridCell oudHoofd = getHoofd();
        GridCell newHoofd = new GridCell(oudHoofd.getBodyX(), oudHoofd.getBodyY() - 1);
        snakeBodies.add(0,newHoofd);

        if (fruit.getBodyX() != newHoofd.getBodyX() || fruit.getBodyY() != newHoofd.getBodyY()) {
            snakeBodies.remove(getSnakeBodies().size() - 1);
            return true;
        }else{
            return false;
        }

    }
    public boolean beweegLinks(GridCell fruit){

        GridCell oudHoofd = getHoofd();
        GridCell newHoofd = new GridCell(oudHoofd.getBodyX() - 1, oudHoofd.getBodyY());
        snakeBodies.add(0,newHoofd);
        if (fruit.getBodyX() != newHoofd.getBodyX() || fruit.getBodyY() != newHoofd.getBodyY()) {
            snakeBodies.remove(getSnakeBodies().size() - 1);
            return true;
        }else{
            return false;
        }


    }
    public boolean beweegOnder(GridCell fruit){

        GridCell oudHoofd = getHoofd();
        GridCell newHoofd = new GridCell(oudHoofd.getBodyX(), oudHoofd.getBodyY() + 1);
        snakeBodies.add(0,newHoofd);
        if (fruit.getBodyX() != newHoofd.getBodyX() || fruit.getBodyY() != newHoofd.getBodyY()) {
            snakeBodies.remove(getSnakeBodies().size() - 1);
            return true;
        }else{
            return false;
        }
    }
    public boolean beweegRechts(GridCell fruit){

        GridCell oudHoofd = getHoofd();
        GridCell newHoofd = new GridCell(oudHoofd.getBodyX() + 1, oudHoofd.getBodyY());
        snakeBodies.add(0, newHoofd);
        if (fruit.getBodyX() != newHoofd.getBodyX() || fruit.getBodyY() != newHoofd.getBodyY()) {
            snakeBodies.remove(getSnakeBodies().size() - 1);
            return true;
        }else {
            return false;
        }
    }

    public void addTestSnake(){

        GridCell tail1 = new GridCell(11,10);
        GridCell tail2 = new GridCell(12,10);
        snakeBodies.add(1,tail1);
        snakeBodies.add(2,tail2);

    }

    public void setSnakeBodies(List<GridCell> snakeBodies) {
        this.snakeBodies = snakeBodies;
    }

}


