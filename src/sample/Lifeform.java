package sample;

import javafx.scene.paint.Color;

public abstract class Lifeform {
    public Cell cell;
    public Color color;
    public int count = 0;
    public boolean dead;
    public boolean isNew;

    public void setDead(boolean d){
        dead = d;
    }

    boolean isDead(){
        return dead;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setIsNew(boolean in){
        isNew = in;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
    abstract void reset();
    abstract boolean act();
    abstract boolean isFood();
}
