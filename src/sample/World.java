package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class World {
    public List<Lifeform> lifeforms = new ArrayList<>();
    private Cell[][] cells;
    private GridPane worldUI;
    private int rows;
    private int cols;

    public World(int r, int c){
        rows = r;
        cols = c;
        cells = new Cell[rows][cols];
        createBoardUI();
        ClickHandler clickHandler = new ClickHandler();
        worldUI.setOnMouseClicked(clickHandler);

    }

    public List<Lifeform> getLifeforms(){
        return lifeforms;
    }

    public Cell getBlock(int row, int col){
        try{
            return cells[row][col];
        }catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }

    public GridPane getWorldUI() {
        return worldUI;
    }

    public void createBoardUI(){
        worldUI = new GridPane();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                Cell b = new Cell(null, this);
                int type = RandomGenerator.nextNumber(100);
                if(type >= 65 && type < 85){
                    Lifeform lf2 = new Plant();
                    b = new Cell(lf2, this);
                    lifeforms.add(lf2);
                } else if(type >= 85){
                    Lifeform lf = new Herbivore();
                    b = new Cell(lf, this);
                    lifeforms.add(lf);
                }
                if(b.getLifeform() != null){
                    b.getLifeform().setCell(b);
                }
                b.setPos(i, j);
                cells[i][j] = b;
                worldUI.add(b.getBlockUI(), j, i);
            }
        }
    }

    public class ClickHandler implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent mouseEvent) {
            for(Lifeform lf : lifeforms){
                if(lf.act()){
                    lf.reset();
                } else{
                    if(!lf.isDead()){
                        lf.setDead(true);
                        lf.cell.updateLifeform(null);
                        lf.cell = null;
                    }



//                    lifeforms.remove(lf);
                }
            }
        }

    }


}
