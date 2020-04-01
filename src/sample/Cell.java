package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.*;

public class Cell {
    private Lifeform lifeform;
    private Rectangle blockUI;
    public static final int SIZE = 25;
    private Color color;
    private World board;
    int row;
    int col;
    static int counter = 0;

    public Cell(Lifeform lf, World b){
        lifeform = lf;
        if(lifeform != null){
            lifeform.setCell(this);
            color = lifeform.color;
        } else{
            color = Color.WHITE;
        }
        board = b;
        blockUI = new Rectangle(SIZE, SIZE, color);
        blockUI.setStroke(Color.BLACK);
    }

    public void setColor(Color c){
        color = c;
        blockUI.setFill(c);
    }

    public void updateLifeform(Lifeform lf){
        counter ++;
        lifeform = lf;
        if(lifeform != null){
            color = lifeform.color;

        }else{
            color = Color.WHITE;
        }

        blockUI.setFill(color);

    }

    public Rectangle getBlockUI(){
        return blockUI;
    }

    public Lifeform getLifeform(){
        return lifeform;
    }


    public World getBoard(){
        return board;
    }

    public Cell getBlock(int row, int col){
        return board.getBlock(row, col);
    }

    public ArrayList<Cell> getNeighbours(){
        Cell down = getBlock(row + 1, col);
        Cell left = getBlock(row, col - 1);
        Cell right = getBlock(row, col+1);
        Cell downLeft = getBlock(row+1, col-1);
        Cell downRight = getBlock(row + 1, col+1);
        Cell up = getBlock(row - 1, col);
        Cell upLeft = getBlock(row - 1, col - 1);
        Cell upRight = getBlock(row - 1, col + 1);

        ArrayList<Cell> neighbours = new ArrayList<>(Arrays.asList(down, left, right,
                downLeft, downRight, up, upLeft, upRight));
        neighbours.removeAll(Collections.singleton(null));

        Collections.shuffle(neighbours);

        return neighbours;
    }


    public static ArrayList<Cell> getOccupied(ArrayList<Cell> cells){
        ArrayList<Cell> occ = new ArrayList<>();
        for(Cell b: cells){
            if(b.getLifeform() != null){
                occ.add(b);
            }
        }
        return occ;
    }

//    public Block lookAround(){
//        Block down = getBlock(row + 1, col);
//        Block left = getBlock(row, col - 1);
//        Block right = getBlock(row, col+1);
//        Block downLeft = getBlock(row+1, col-1);
//        Block downRight = getBlock(row + 1, col+1);
//        Block up = getBlock(row - 1, col);
//        Block upLeft = getBlock(row - 1, col - 1);
//        Block upRight = getBlock(row - 1, col + 1);
//
//        return getMovable(down, left, right, up);


//        Block eatable = getEatable(down, left, right, up);
//        if(eatable != null){
//            lifeform.count = 0;
//            return eatable;
//        } else{
//            lifeform.count++;
//            return getEmpty(down, left, right, up);
//        }
//}

//    public Block getMovable(Block b1, Block b2, Block b3, Block b4){
//        List<Block> bs = new ArrayList<>(Arrays.asList(b1, b2, b3, b4));
//        Collections.shuffle(bs);
//        for(Block block : bs){
//            if(block.getLifeform() == null){
//                lifeform.count ++;
//                return block;
//            } else if(block.getLifeform().isFood()){
//                lifeform.count = 0;
//                return block;
//            }
//        }
//        lifeform.count++;
//        return null;
//    }
//
//    public Block getEatable(Block b1, Block b2, Block b3, Block b4){
//        List<Block> bs = new ArrayList<>(Arrays.asList(b1, b2, b3, b4));
//        Collections.shuffle(bs);
//        for(Block block : bs){
//            if(block != null && block.getLifeform() != null && block.getLifeform().isFood()){
//                return block;
//            }
//        }
//        return null;
//    }

    public Cell getEmpty(Cell b1, Cell b2, Cell b3, Cell b4){
        List<Cell> bs = new ArrayList<>(Arrays.asList(b1, b2, b3, b4));
        Collections.shuffle(bs);
        for(Cell cell : bs){
            try{
            if(cell.getLifeform() == null){
                return cell;
            }}catch (Exception e){return null;}
        }
        return null;
    }

    public void setPos(int r, int c){
        row = r;
        col = c;
    }



}
