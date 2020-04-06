package sample;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Herbivore extends Animal implements Movable {
    public static final int LIFE = 5;
    public Herbivore() {
        setColor(Color.YELLOW);
        setHunger(0);

    }

    @Override
    public String toString() {
        return "Herbivore";
    }

    @Override
    boolean act() {
        if (getHunger() == LIFE) {
            return false;
        } else {
            if (!hasActed()) {
                move();
                setActed(true);
            }
            return true;
        }
    }

    @Override
    public Cell chooseDestiny() {
        ArrayList<Cell> neighbours = getCell().getNeighbours();
        for (Cell cell : neighbours) {
            if (eat(cell.getLifeform())) {
                return cell;
            }
        }
        incrementHunger();
        return null;
    }

    @Override
    boolean eat(Lifeform lf) {
        if (lf == null) {
            incrementHunger();
            return true;
        } else if (lf instanceof HerbivoreEdible) {
            setHunger(0);
            return true;
        }
        return false;
    }

}
