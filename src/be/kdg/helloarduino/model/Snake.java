package be.kdg.helloarduino.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Van Dijck on 21/05/2020
 * @project helloarduino - kopie
 */
public class Snake {

   private List<SnakeBody> snakeBodies;

    public Snake() {
        this.snakeBodies = new ArrayList<>();
        SnakeBody hoofd = new SnakeBody(10,10);
        snakeBodies.add(hoofd);
    }

}


