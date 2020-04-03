package sample;

public class Game {
    public static final int BOARDSIZE = 25;
    private World world;

    public void initWorld() {
        world = new World(BOARDSIZE, BOARDSIZE);
    }

    public World getWorld() {
        return world;
    }

    public void update() {
        world.updateWorld();
        world.endTurn();
    }


}
