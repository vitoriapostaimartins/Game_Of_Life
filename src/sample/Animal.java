package sample;

public abstract class Animal extends Lifeform implements Movable {

    @Override
    public void moveTo(Cell destiny) {
        getCell().getWorld().removeLifeform(destiny.getLifeform());
        destiny.updateLifeform(this);
        getCell().updateLifeform(null);
        setCell(destiny);
    }

    @Override
    public void move() {
        Cell destiny = chooseDestiny();
        if (destiny != null) {
            moveTo(destiny);
        }
    }

    abstract boolean eat(Lifeform lf);
}
