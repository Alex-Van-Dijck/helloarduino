package be.kdg.helloarduino.model;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Alex Van Dijck on 21/05/2020
 * @project helloarduino - kopie
 */
public class Snake {

   private List<GridCell> snakeBodies;

    public Snake() {
        this.snakeBodies = new LinkedList<>();
        GridCell hoofd = new GridCell(10,10);
        snakeBodies.add(hoofd);
    }

    public GridCell getHoofd(){

        return snakeBodies.get(0);

    }

    public List<GridCell> getSnakeBodies() {
        return snakeBodies;
    }

    public void  beweegVooruit(){

        GridCell oudHoofd = getHoofd();
        GridCell newHoofd = new GridCell(oudHoofd.getBodyX(), oudHoofd.getBodyY() - 1);
        snakeBodies.add(newHoofd);
        snakeBodies.remove(getSnakeBodies().size() - 1);
    }
    public void beweegLinks(){

        GridCell oudHoofd = getHoofd();
        GridCell newHoofd = new GridCell(oudHoofd.getBodyX() - 1, oudHoofd.getBodyY());
        snakeBodies.add(newHoofd);
        snakeBodies.remove(getSnakeBodies().size() - 1);


    }
    public void beweegOnder(){

        GridCell oudHoofd = getHoofd();
        GridCell newHoofd = new GridCell(oudHoofd.getBodyX(), oudHoofd.getBodyY() + 1);
        snakeBodies.add(newHoofd);
        snakeBodies.remove(getSnakeBodies().size() - 1);
    }
    public void beweegRechts(){

        GridCell oudHoofd = getHoofd();
        GridCell newHoofd = new GridCell(oudHoofd.getBodyX() + 1, oudHoofd.getBodyY());
        snakeBodies.add(newHoofd);
        snakeBodies.remove(getSnakeBodies().size() - 1);

    }

    public void setSnakeBodies(List<GridCell> snakeBodies) {
        this.snakeBodies = snakeBodies;
    }
}


