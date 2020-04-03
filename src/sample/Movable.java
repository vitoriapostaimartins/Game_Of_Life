package sample;

public interface Movable {
    void move();

    Cell chooseDestiny();

    void moveTo(Cell destiny);
}
