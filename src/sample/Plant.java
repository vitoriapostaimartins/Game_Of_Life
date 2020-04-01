package sample;

import javafx.scene.paint.Color;

import java.util.*;

public class Plant extends Lifeform implements Edible {
    boolean moved = false;
    public Plant() {
        color = Color.GREEN;
    }

    @Override
    void reset() {
        moved = false;
        if(isNew){
            isNew = false;
            cell.setColor(Color.GREEN);
            System.out.println("in reset");
        }

    }

    @Override
    boolean act() {
        if(!isNew()){
        seed();
        }
        moved = true;

        return true;
    }

    @Override
    public String toString() {
        return "Plant";
    }

    @Override
    boolean isFood() {
        return true;
    }

    public void seed() {
        ArrayList<Cell> empty = new ArrayList<>();
        int emptyCount = 0;
        ArrayList<Cell> neighbours = cell.getNeighbours();
        for(Cell c : neighbours){
            if(c.getLifeform() instanceof Plant){
                emptyCount++;
                continue;
            } else if(c.getLifeform() instanceof Animal){
                continue;
            }
            empty.add(c);
        }
        if(emptyCount == 4 && empty.size() >=3){
            for(Cell c:empty){
                addNewPlant(c);
            }
        }
    }

    private void addNewPlant(Cell c){
        Plant pl = new Plant();
        pl.isNew = true;
        c.updateLifeform(pl);
        pl.setCell(c);
        World.addLifeform(pl);
    }

}
