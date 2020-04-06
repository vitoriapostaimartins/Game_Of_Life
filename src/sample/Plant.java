package sample;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Plant extends Lifeform implements HerbivoreEdible {

    public Plant() {
        setColor(Color.GREEN);
    }

    @Override
    boolean act() {
        if (!isNew()) {
            seed();
        }
        setActed(true);
        return true;
    }

    @Override
    public String toString() {
        return "Plant";
    }

    private void seed() {
        ArrayList<Cell> empty = new ArrayList<>();
        int emptyCount = 0;
        ArrayList<Cell> neighbours = getCell().getNeighbours();
        for (Cell c : neighbours) {
            if (c.getLifeform() instanceof Plant) {
                emptyCount++;
                continue;
            } else if (c.getLifeform() instanceof Animal) {
                continue;
            }
            empty.add(c);
        }
        if (emptyCount >= 3 && empty.size() >= 3) {
            for (Cell c : empty) {
                addNewPlant(c);
                return;
            }
        }
    }

    private void addNewPlant(Cell c) {
        Plant pl = new Plant();
        pl.setIsNew(true);
        c.updateLifeform(pl);
        pl.setCell(c);
        World.addLifeform(pl);
    }
}
