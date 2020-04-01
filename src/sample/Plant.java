package sample;

import javafx.scene.paint.Color;

import java.util.*;

public class Plant extends Lifeform implements Edible {
    private Cell newPlant;
    boolean moved = false;
    public Plant() {
        color = Color.GREEN;
    }

    @Override
    void reset() {
        moved = false;
//        isNew = false;
    }

    @Override
    boolean act() {
        seed();
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
       canSeed();
    }



    public boolean canSeed(){
        ArrayList<Cell> nb = cell.getNeighbours();
        List<Cell> empty = Cell.getEmpty(nb);
        for(Cell b : empty){};
        if (empty.size() >= 3) {
            for(Cell b : empty){
                if(b.getLifeform() == null) {
                    System.out.println(b.getLifeform());
                    newPlant = b;
                    ArrayList<Cell> p = Cell.getPlants(cell.getNeighbours());
                    if (p.size() == 4) {
                        Plant pl = new Plant();
                        pl.isNew = true;
                        newPlant.updateLifeform(pl);
                        pl.setCell(newPlant);
                        pl.setIsNew(true);
                        pl.setIsNew(true);
                        newPlant.setColor(Color.RED);
                    } else {
                    }
                }
            }
        }else{}
        return true;
    }




    public Cell getPlant(Cell b1, Cell b2, Cell b3, Cell b4) {
        List<Cell> bs = new ArrayList<>(Arrays.asList(b1, b2, b3, b4));
        Collections.shuffle(bs);
        for (Cell cell : bs) {
            if (cell != null && cell.getLifeform() != null && cell.getLifeform().isFood()) {
                return cell;
            }
        }
        return null;
    }

    public Cell getEmpty(Cell b1, Cell b2, Cell b3, Cell b4) {
        List<Cell> bs = new ArrayList<>(Arrays.asList(b1, b2, b3, b4));
        Collections.shuffle(bs);
        for (Cell cell : bs) {
            try {
                if (cell.getLifeform() == null) {
                    return cell;
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public boolean searchPlants() {
        Cell down = cell.getBlock(cell.getRow() + 1, cell.getCol());
        Cell left = cell.getBlock(cell.getRow(), cell.getCol() - 1);
        Cell right = cell.getBlock(cell.getRow(), cell.getCol() + 1);
        Cell up = cell.getBlock(cell.getRow() - 1, cell.getCol());
        List<Cell> bs = new ArrayList<>(Arrays.asList(down, left, right, up));
        Collections.shuffle(bs);
        for (Cell b : bs) {
            try {
                if (b.getLifeform() != null && b.getLifeform().isFood()) {
                    return true;
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    public Cell lookAround() {
        Cell down = cell.getBlock(cell.getRow() + 1, cell.getCol());
        Cell left = cell.getBlock(cell.getRow(), cell.getCol() - 1);
        Cell right = cell.getBlock(cell.getRow(), cell.getCol() + 1);
        Cell up = cell.getBlock(cell.getRow() - 1, cell.getCol());
        return getEmpty(down, left, right, up);
    }
}
