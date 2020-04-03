package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Cell {
    private Lifeform lifeform;
    public static final int SIZE = 30;
    private Rectangle cellUI;
    private Color color;
    private World world;
    private int row;
    private int col;
    private ArrayList<Cell> neighbours;

    public Cell(Lifeform lf, World b) {
        lifeform = lf;
        if (lifeform != null) {
            lifeform.setCell(this);
            color = lifeform.getColor();
        } else {
            color = Color.WHITE;
        }
        world = b;
        cellUI = new Rectangle(SIZE, SIZE, color);
        cellUI.setStroke(Color.BLACK);

    }

    public World getWorld() {
        return world;
    }

    public void updateLifeform(Lifeform lf) {
        lifeform = lf;
        if (lifeform != null) {
            color = lifeform.getColor();

        } else {
            color = Color.WHITE;
        }

        cellUI.setFill(color);

    }

    public Rectangle getCellUI() {
        return cellUI;
    }

    public Lifeform getLifeform() {
        return lifeform;
    }

    public ArrayList<Cell> getNeighbours() {
        setNeighbours();
        Collections.shuffle(neighbours);

        return neighbours;
    }

    private void setNeighbours() {
        Cell down = world.getCell(row + 1, col);
        Cell left = world.getCell(row, col - 1);
        Cell right = world.getCell(row, col + 1);
        Cell downLeft = world.getCell(row + 1, col - 1);
        Cell downRight = world.getCell(row + 1, col + 1);
        Cell up = world.getCell(row - 1, col);
        Cell upLeft = world.getCell(row - 1, col - 1);
        Cell upRight = world.getCell(row - 1, col + 1);
        neighbours = new ArrayList<>(Arrays.asList(down, left, right,
                downLeft, downRight, up, upLeft, upRight));
        neighbours.removeAll(Collections.singleton(null));
    }


    public void setPos(int r, int c) {
        row = r;
        col = c;
    }


}
