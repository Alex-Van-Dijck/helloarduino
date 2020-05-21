package be.kdg.helloarduino.model;

/**
 * @author Alex Van Dijck on 21/05/2020
 * @project helloarduino - kopie
 */
public class GridCell {

    private int bodyX, bodyY;

    public GridCell(int bodyX, int bodyY) {
        this.bodyX = bodyX;
        this.bodyY = bodyY;
    }

    public int getBodyX() {
        return bodyX;
    }

    public void setBodyX(int bodyX) {
        this.bodyX = bodyX;
    }

    public int getBodyY() {
        return bodyY;
    }

    public void setBodyY(int bodyY) {
        this.bodyY = bodyY;
    }
}


