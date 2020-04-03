package sample;

import javafx.scene.paint.Color;

public abstract class Lifeform {
    private Cell cell;
    private Color color;
    private int hunger = 0;
    private boolean dead;
    private boolean isNew;
    private boolean acted;

    public boolean hasActed() {
        return acted;
    }

    public void setActed(boolean acted) {
        this.acted = acted;
    }

    public void incrementHunger() {
        hunger++;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Cell getCell() {
        return cell;
    }

    public void age() {
        if (isNew()) {
            setIsNew(false);
        }
    }

    boolean isDead() {
        return dead;
    }

    public void setDead(boolean d) {
        dead = d;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setIsNew(boolean in) {
        isNew = in;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void reset() {
        acted = false;
        age();
    }

    abstract boolean act();

    public void die() {
        if (!isDead()) {
            setDead(true);
            cell.getWorld().removeLifeform(this);
            cell.updateLifeform(null);
            cell = null;
        }
    }
}
