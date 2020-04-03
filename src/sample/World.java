package sample;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class World {
    private static ArrayList<Lifeform> lifeforms = new ArrayList<>();
    private static ArrayList<Lifeform> newLifeforms = new ArrayList<>();
    private static ArrayList<Lifeform> lifeformsToRemove = new ArrayList<>();
    private Cell[][] cells;
    private GridPane worldUI;
    private int rows;
    private int cols;

    public World(int r, int c) {
        rows = r;
        cols = c;
        cells = new Cell[rows][cols];
        createBoardUI();

    }

    public static void addLifeform(Lifeform lf) {
        newLifeforms.add(lf);
    }

    public void removeLifeform(Lifeform lf) {
        lifeformsToRemove.add(lf);
    }

    public Cell getCell(int row, int col) {
        try {
            return cells[row][col];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public GridPane getWorldUI() {
        return worldUI;
    }

    private void createBoardUI() {
        worldUI = new GridPane();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell b = new Cell(null, this);
                int type = RandomGenerator.nextNumber(100);
                if (type >= 65 && type < 85) {
                    Lifeform lf2 = new Plant();
                    b = new Cell(lf2, this);
                    lifeforms.add(lf2);
                } else if (type >= 85) {
                    Lifeform lf = new Herbivore();
                    b = new Cell(lf, this);
                    lifeforms.add(lf);
                }
                if (b.getLifeform() != null) {
                    b.getLifeform().setCell(b);
                }
                b.setPos(i, j);
                cells[i][j] = b;
                worldUI.add(b.getCellUI(), i, j);
            }
        }
    }

    public void updateWorld() {
        for (Lifeform lf : lifeforms) {
            if (!lf.act()) {
                lf.die();
            }
        }
    }

    public void endTurn() {
        lifeforms.forEach(Lifeform::reset);
        lifeforms.addAll(newLifeforms);
        lifeforms.removeAll(lifeformsToRemove);
    }

}
