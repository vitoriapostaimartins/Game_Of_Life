package sample;

import javafx.scene.paint.Color;

import java.util.*;

public class Herbivore extends Animal implements Movable {
    boolean moved = false;

    public Herbivore() {
        color = Color.YELLOW;
        count = 0;

    }

    @Override
    public String toString() {
        return "Herbivore";
    }

    @Override
    void reset() {
        moved = false;
    }

    void die() {
        System.out.println("called die");
        cell.updateLifeform(null);
        cell.getBoard().getLifeforms().remove(this);
        cell = null;
    }

    @Override
    boolean act() {
        if (count == 5) {
            return false;
        } else {
            if (!moved) {
                move();
                moved = true;
            }
            return true;
        }
    }

    @Override
    boolean isFood() {
        return false;
    }

    @Override
    public void move() {
//        System.out.println("herbivore acted");
        Cell destiny = lookAround();
        if (destiny != null) {
            moveTo(destiny);
        }
    }

    public ArrayList<Cell> getEatable() {
        ArrayList<Cell> occNeighbours = Cell.getOccupied(cell.getNeighbours());
        ArrayList<Cell> eatable = new ArrayList<>();
        Collections.shuffle(occNeighbours);
        for(Cell b : occNeighbours){
            if(b.getLifeform().isFood()){
                eatable.add(b);
            }
        }
        return eatable;
    }

    public Cell getMovable(){
        ArrayList<Cell> neighbours = cell.getNeighbours();
        List<Cell> cells = new ArrayList<>();
        Collections.shuffle(cells);
        for(Cell cell : neighbours){
            if(cell.getLifeform() == null){
                count ++;
                return cell;
            } else if(cell.getLifeform().isFood()){
                count = 0;
                return cell;
            }
        }
        count++;
        return null;
    }

    public void moveTo(Cell destiny) {

        destiny.updateLifeform(this);
        cell.updateLifeform(null);
        cell = destiny;
    }

    public Cell lookAround() {
        try {
            return getMovable();
        } catch (Exception e) {
            return null;
        }
//        return null
    }

}
